package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Players {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("balance")
    private String balance;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("eyeColor")
    private String eyeColor;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("position")
    private String position;


    public Players() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(id, players.id) && Objects.equals(guid, players.guid) && Objects.equals(isActive, players.isActive) && Objects.equals(balance, players.balance) && Objects.equals(age, players.age) && Objects.equals(eyeColor, players.eyeColor) && Objects.equals(name, players.name) && Objects.equals(email, players.email) && Objects.equals(phone, players.phone) && Objects.equals(position, players.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, isActive, balance, age, eyeColor, name, email, phone, position);
    }

    @Override
    public String toString() {
        return "Players{" +
                "id='" + id + '\'' +
                ", guid='" + guid + '\'' +
                ", isActive=" + isActive +
                ", balance='" + balance + '\'' +
                ", age=" + age +
                ", eyeColor='" + eyeColor + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
