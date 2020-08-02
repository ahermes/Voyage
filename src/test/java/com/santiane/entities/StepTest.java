package com.santiane.entities;

import com.santiane.enumerate.City;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StepTest {
    Step bus;
    Step plane;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        bus = new Bus("airport", City.Londres,City.Tokyo,"B45");
        plane = new Plane("airport",City.NewYork,City.LosAngeles,"B45","A4","43322");
    }

    @Test
    public void checkParametersAllGood() {
        assertTrue(bus.checkParameters("bus","airport", City.Londres,City.Tokyo,"B45"));
    }

    @Test
    public void checkParametersTypeNull() {
        assertFalse(bus.checkParameters(null,"airport", City.Londres,City.Tokyo,"B45"));
    }
    @Test
    public void checkParametersTypeEmpty() {
        assertFalse(bus.checkParameters("","airport", City.Londres,City.Tokyo,"B45"));
    }
    @Test
    public void checkParametersNumberNull() {
        assertFalse(bus.checkParameters("bus",null, City.Londres,City.Tokyo,"B45"));
    }
    @Test
    public void checkParametersNumberEmpty() {
        assertFalse(bus.checkParameters("bus","", City.Londres,City.Tokyo,"B45"));
    }
    @Test
    public void checkParametersDepartureNull() {
        assertFalse(bus.checkParameters("bus","airport", null,City.Tokyo,"B45"));
    }
    @Test
    public void checkParametersArrivalNull() {
        assertFalse(bus.checkParameters("bus","airport", City.Londres,null,"B45"));
    }

    @Test
    public void checkParametersSeatNull() {
        assertTrue(bus.checkParameters("bus","airport", City.Londres,City.Tokyo,null));
    }

    @Test
    public void cityMenu() {
        systemInMock.provideLines("10", "4");
        City c = bus.cityMenu();
        assertEquals(City.Nice, c);
    }
}