package com.example.demo;


import java.util.Date;

public class Team {
    private String name;
    private String city;
    private String owner;
    private int stadiumCapacity;
    private String competition;
    private int numberOfPlayers;
    private Date founded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public Team(String name, String city, String owner, int stadiumCapacity, String competition, int numberOfPlayers, Date founded) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.stadiumCapacity = stadiumCapacity;
        this.competition = competition;
        this.numberOfPlayers = numberOfPlayers;
        this.founded = founded;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", Owner: " + owner + ", Capacity: " + stadiumCapacity + ", Competition: " + competition
                + "Number of Players: " + numberOfPlayers + ", Founded: " + founded.toString();
    }

}
