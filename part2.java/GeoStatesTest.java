package GeoPolitical;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoStatesTest {

    @Test
    public void getStates() {

        var states = GeoStates.NORTH_CENTRAL;
        String[] expected = {"BENUE", "FCT", "KOGI", "KWARA", "NASARAWA", "NIGER", "PLATEAU"};
        assertArrayEquals(states.getStates() ,expected );


    }

    @Test
    public void getPoliticalZone() {

        String statesToSearch = "ABIA";
        var zoneToReturn = GeoStates.SOUTH_EAST;
        assertEquals(zoneToReturn,GeoStates.getPoliticalZone(statesToSearch));

    }
}