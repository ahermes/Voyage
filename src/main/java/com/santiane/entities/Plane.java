package com.santiane.entities;

import com.santiane.enumerate.City;

import static com.santiane.App.keyboard;

public class Plane extends Step {

    private String gate;
    private String baggage_drop;

    public Plane(){
        super("plane");
    }
    public Plane(String number, City departure, City arrival, String seat, String gate, String baggage_drop) {
        super("plane",number,departure,arrival,seat);
        this.gate = gate;
        this.baggage_drop = baggage_drop;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        if("".equals(gate)){
            this.gate = null;
        }else {
            this.gate = gate;
        }
    }

    public String getBaggage_drop() {
        return baggage_drop;
    }

    public void setBaggage_drop(String baggage_drop) {
        if("".equals(baggage_drop)){
            this.baggage_drop = null;
        }else {
            this.baggage_drop = baggage_drop;
        }
    }

    @Override
    public Step setVariablesMenu(Voyage voyage){
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
        System.out.println("Veuillez renseigner le numéro de porte d'embarquement (ENTRER SI AUCUN)");
        this.setGate(keyboard.nextLine());
        System.out.println("Veuillez renseigner le numéro de baggage (ENTRER SI AUCUN)");
        this.setBaggage_drop(keyboard.nextLine());
        return this;
    }


}
