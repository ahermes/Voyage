package com.santiane.entities;

import com.santiane.enumerate.City;

public class Bus extends Step {

    public Bus(){
        super("bus");
    }

    public Bus(String number, City departure, City arrival, String seat) {
        super("bus",number,departure,arrival,seat);
    }
}
