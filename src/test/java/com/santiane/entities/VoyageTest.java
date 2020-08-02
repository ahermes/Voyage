package com.santiane.entities;

import com.santiane.enumerate.City;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VoyageTest {

    Step bus;
    Step bus2;
    Step plane;
    Step train;
    Voyage voyage;
    @Before
    public void setUp() throws Exception {
        bus = new Bus("airport", City.Londres,City.Tokyo,"B45");
        bus2 = new Bus("airport", City.Londres,City.Tokyo,"B45");
        plane = new Plane("airport",City.NewYork,City.LosAngeles,"B45","A4","43322");
        train = new Train("airport", City.Tokyo,City.NewYork,"B45");
        voyage = new Voyage();
    }

    @Test
    public void addToStepList() {
        assertTrue(voyage.addToStepList(bus));
        assertTrue(voyage.addToStepList(plane));
        assertTrue(voyage.addToStepList(train));
        assertFalse(voyage.addToStepList(plane));
    }


    @Test
    public void checkCityArrival() {
        voyage.addToStepList(bus);
        assertFalse(voyage.checkCityArrival(bus2.getArrival()));
        assertTrue(voyage.checkCityArrival(train.getArrival()));
    }

    @Test
    public void checkCityDeparture() {
        voyage.addToStepList(bus);
        assertFalse(voyage.checkCityDeparture(bus2.getDeparture()));
        assertTrue(voyage.checkCityDeparture(train.getDeparture()));
    }

    @Test
    public void getLastArrival() {
        voyage.addToStepList(bus);
        assertEquals(City.Tokyo.toString(), voyage.getLastArrival());
        voyage.addToStepList(train);
        assertEquals(City.NewYork.toString(), voyage.getLastArrival());
    }

    @Test
    public void getLastDeparture() {
        voyage.addToStepList(bus);
        assertEquals(City.Londres.toString(), voyage.getLastDeparture());
        voyage.addToStepList(train);
        assertEquals(City.Tokyo.toString(), voyage.getLastDeparture());
    }
}