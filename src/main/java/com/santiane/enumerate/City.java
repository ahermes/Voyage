package com.santiane.enumerate;

public enum City {
    Paris ("Paris"),
    Marseille ("Marseille"),
    Tokyo ("Tokyo"),
    Nice ("Nice"),
    Lyon ("Lyon"),
    Montpellier ("Montpellier"),
    Londres ("Londres"),
    NewYork ("New York"),
    LosAngeles ("Los Angles");

    private String name = "";

    //Constructeur
    City(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

 }
