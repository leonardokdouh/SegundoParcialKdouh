package model;

import java.util.Map;

public class NumberPlayerException extends Throwable {


    private Integer number;


    public NumberPlayerException(Integer number, Integer dif, Class<? extends Map> name, String key) {

        super("Number of players of key " + key
                + " from the map: " +name
                + " limit is " + number
                + " And the differnece is " + (dif - number));

        this.number = number;
    }

    public Integer getCapacity() {
        return number;
    }

    public void setCapacity(Integer capacity) {
        this.number = capacity;
    }

}
