package com.santiane.entities;

import com.santiane.enumerate.City;

public class Train extends Step {


    public Train(){
        super("train");
    }
    public Train(String number, City departure, City arrival, String seat) {
        super("train",number,departure,arrival,seat);
    }
}
