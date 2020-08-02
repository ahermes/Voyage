package com.santiane.utils;

import com.santiane.entities.Bus;
import com.santiane.entities.Plane;
import com.santiane.entities.Step;
import com.santiane.entities.Voyage;
import com.santiane.enumerate.City;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectToJsonTest {
    Step bus;
    Step plane;
    Voyage voyage;
    @Before
    public void setUp() throws Exception {
        bus = new Bus("airport", City.Londres,City.Tokyo,"B45");
        plane = new Plane("airport",City.NewYork,City.LosAngeles,"B45","A4","43322");
        voyage = new Voyage();
        voyage.addToStepList(bus);
        voyage.addToStepList(plane);
    }

    @Test
    public void getJsonString() {
        String test = ObjectToJson.getJsonString(bus);
        assertEquals("{\"type\":\"bus\",\"number\":\"airport\",\"departure\":\"Londres\",\"arrival\":\"Tokyo\",\"seat\":\"B45\"}", test);
    }
    @Test
    public void getJsonStringFromNullObject() {
        bus = null;
        String test = ObjectToJson.getJsonString(bus);
        assertEquals("null", test);
    }
    @Test
    public void getJsonStringFromArrayObject() {
        String test = ObjectToJson.getJsonString(voyage.getStepList());
        assertEquals("[{\"type\":\"bus\",\"number\":\"airport\",\"departure\":\"Londres\",\"arrival\":\"Tokyo\",\"seat\":\"B45\"},{\"type\":\"plane\",\"number\":\"airport\",\"departure\":\"New York\",\"arrival\":\"Los Angles\",\"seat\":\"B45\",\"gate\":\"A4\",\"baggage_drop\":\"43322\"}]",
                test);
    }
}