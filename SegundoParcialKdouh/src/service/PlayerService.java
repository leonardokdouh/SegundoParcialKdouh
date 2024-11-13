package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumberPlayerException;
import model.Players;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class PlayerService {

    private ObjectMapper mapper = new ObjectMapper();

    List<Players> positionTank = new ArrayList<>();
    List<Players> positionHealer = new ArrayList<>();
    List<Players> positionSupport = new ArrayList<>();
    List<Players> blueEyes = new ArrayList<>();
    List<Players> brownEyes = new ArrayList<>();
    List<Players> greenEyes = new ArrayList<>();


    Map<String, List> eyeColors = new LinkedHashMap<String, List>();
    Map<String, List> playerPosition = new LinkedHashMap<String, List>();


    public void addElement(String key, List value, Map<String, List> map) {
        map.put(key, value);
    }

    public int countElementsOnMap(Map<String, List> myMap) {
        int counter = 0;
        for (int i = 0; i < myMap.size(); i++) {
            counter = myMap.get(i).size();
        }
        return counter;
    }

    public void printElements(Map<String, List> myMap) {
        myMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public List getElementByKey(String key, Map<String, List> myMap) {
        return myMap.get(key);
    }


    public int countElements(Map<String, List> map, String key, int number) throws NumberPlayerException {
        int numberOfElements=map.get(key).size();

        if(numberOfElements>number){
        throw new NumberPlayerException(number, numberOfElements, map.getClass(), key);
        }else {
            return numberOfElements;
        }
    }




    public List<Players> loadPlayers(String filePath) throws IOException {
        Players[] playersArray = mapper.readValue(new File(filePath), Players[].class);
        return Arrays.asList(playersArray);
    }

    public Map<String, List>  filterPlayerByPosition(List<Players> players) {
        for (Players player : players) {
            String position = player.getPosition();
            switch (position) {
                case "soporte":
                    positionSupport.add(player);
                    break;

                case "curador":
                    positionHealer.add(player);
                    break;

                case "tanque":
                    positionTank.add(player);
                    break;
            }
        }
        playerPosition.put("tanque", positionTank);
        playerPosition.put("curador", positionHealer);
        playerPosition.put("soporte", positionSupport);

        return playerPosition;
    }

    public Map<String, List> filterPlayerByColor(List<Players> players) {
        for (Players player : players) {
            String eyeColor = player.getEyeColor();
            switch (eyeColor) {
                case "green":
                    greenEyes.add(player);
                    break;

                case "blue":
                    blueEyes.add(player);
                    break;

                case "brown":
                    brownEyes.add(player);
                    break;
            }
        }
        eyeColors.put("green", greenEyes);
        eyeColors.put("blue", blueEyes);
        eyeColors.put("brown", brownEyes);

        return eyeColors;
    }


    public List<Players> hightSalariesPlayers(List<Players> players, Integer minSalary){
        List<Players> higherBalances = new ArrayList<>();
        for (Players player : players) {

            String cutString = player.getBalance().replace("$", "").replace(",","" );
            BigDecimal number = new BigDecimal(cutString);

            Integer integerValue = number.intValue();
            if (integerValue>minSalary) {
                higherBalances.add(player);
            }
        }
        return higherBalances;
    }
    public void saveHightSalaries(String filePath, List<Players> higherBalances) throws IOException {
        mapper.writeValue(new File(filePath), higherBalances);
    }

}
