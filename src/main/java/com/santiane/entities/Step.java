package com.santiane.entities;

import com.santiane.enumerate.City;
import com.santiane.utils.ObjectToJson;

import static com.santiane.App.keyboard;

public abstract class Step {
    protected String type;
    protected String number;
    protected City departure;
    protected City arrival;
    protected String seat;

    public Step(String type){
        this.type = type;
    }
    public Step(String type, String number, City departure, City arrival, String seat) {
        this.type = type;
        this.number = number;
        this.departure = departure;
        this.arrival = arrival;
        this.seat = seat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDeparture() {
        return departure.toString();
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival.toString();
    }

    public void setArrival(City arrival) {
        this.arrival = arrival;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        if("".equals(seat)){
            this.seat = null;
        }else {
            this.seat = seat;
        }
    }

    public boolean checkParameters(String type, String number, City departure, City arrival, String seat){
        return type != null && number != null && departure != null && arrival != null && !"".equals(type) && !"".equals(number);
    }

    public Step setVariablesMenu(Voyage voyage) {
        System.out.println("Menu Etape:");
        System.out.println("--------------");
        System.out.println("Veuillez renseigner le numéro du " + this.type);
        this.number = keyboard.nextLine();
        while ("".equals(this.number)){
            System.out.println("le numéro du " + this.type + "ne peux pas être vide, merci de le renseigner");
            this.number = keyboard.nextLine();
        }
        System.out.println("Veuillez renseigner une ville de départ:");
        this.departure = cityMenu();
        while (!voyage.checkCityDeparture(this.getDeparture())) {
            System.out.println("Une étape de votre voyage est djà au départ de " + this.departure);
            System.out.println("Vous vouliez peut-être choisir " + voyage.getLastArrival() + " ?");
            System.out.println("Veuillez renseigner une autre ville de départ:");
            this.departure = cityMenu();
        }
        System.out.println("Veuillez renseigner une ville de d'arrivée:");
        this.arrival = cityMenu();
        while (this.departure == this.arrival){
            System.out.println("L'arrivée ne peux pas être la même que le départ");
            System.out.println("Veuillez renseigner une ville de d'arrivée:");
            this.arrival = cityMenu();
        }
        while (!voyage.checkCityArrival(this.getArrival())) {
            System.out.println("Une étape de votre voyage arrive déjà à " + this.arrival);
            System.out.println("Veuillez renseigner une autre ville d'arrivée:");
            this.arrival = cityMenu();
        }
        System.out.println("Veuillez renseigner le numéro de siège (ENTRER SI AUCUN)");
        this.setSeat(keyboard.nextLine());
        return this;
    }

    public City cityMenu(){
        int option = 100;
        while (option >= 100){
            for (int i = 0; i < City.values().length; i++) {
                System.out.println((i + 1) + ". " + City.values()[i]);
            }
            System.out.println("--------------");
            System.out.println("Faites un choix:");
            try {
                option = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                option = 100;
            }
            if(option >= City.values().length) option = 100;
        }
        return City.values()[option-1];
    }


    @Override
    public String toString() {
        return ObjectToJson.getJsonString(this);
    }
}
