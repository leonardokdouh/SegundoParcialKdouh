import model.NumberPlayerException;
import model.Players;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import service.PlayerService;
import utils.JsonUtiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, NumberPlayerException {
        String jsonPath = "jugadores.json";

        String highSalaryJsonPath = "higher_salaries.json";

        JsonUtiles json = new JsonUtiles();
        json.leer("jugadores");

        Map<String, List> playersMapPosition;
        Map<String, List> playersEyeColor;

        PlayerService pService = new PlayerService();
        List<Players> theList=pService.loadPlayers(jsonPath);


        playersMapPosition=pService.filterPlayerByPosition(theList);

        playersEyeColor=pService.filterPlayerByColor(theList);

        System.out.println("Map of Positions");

        pService.printElements(playersMapPosition);

        System.out.println("Map of Color Eyes");
        pService.printElements(playersEyeColor);


        //  System.out.println(pService.countElements(playersEyeColor, "blue", 1));

        pService.saveHightSalaries(highSalaryJsonPath, pService.hightSalariesPlayers(theList, 4999));
    }

}