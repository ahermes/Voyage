package com.santiane.entities;

import com.santiane.enumerate.City;
import com.santiane.utils.ObjectToJson;

import java.util.ArrayList;
import java.util.List;

public class Voyage {
    private String name;
    private List<Step> stepList;

    public Voyage(){
        name = "";
        stepList = new ArrayList<Step>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public boolean addToStepList(Step step){
        if(!checkCityArrival(step.getArrival()) && !checkCityArrival(step.getDeparture())){
            return false;
        }
        return this.stepList.add(step);
    }

    public boolean checkCityArrival(String arrival) {
        for (Step step : this.stepList) {
            if(step.getArrival().equals(arrival)){
                return false;
            }
        }
        return true;
    }


    public boolean checkCityDeparture(String departure) {
        for (Step step : this.stepList) {
            if(step.getDeparture().equals(departure)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return ObjectToJson.getJsonString(getStepList());
    }

    public String getLastArrival() {
        return stepList.get(stepList.size()-1).getArrival();
    }

    public String getLastDeparture() {
        return stepList.get(stepList.size()-1).getDeparture();
    }
}
