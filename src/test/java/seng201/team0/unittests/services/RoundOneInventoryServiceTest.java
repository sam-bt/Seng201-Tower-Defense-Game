package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Tower;
import seng201.team0.services.RoundOneInventoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test RoundOneInventoryService implementation
 * @author Samuel Beattie
 */

class RoundOneInventoryServiceTest {
    /**
     * Round One Inventory Service
     */
    RoundOneInventoryService testRoundOneInventoryService;
    /**
     * Set up a RoundOneInventoryService instance before each test
     */
    @BeforeEach
    void setupTest() {
        testRoundOneInventoryService = new RoundOneInventoryService(1.2);
    }
    /**
     * Test towers are as expected (done by checking names)
     */
    @Test
    void towerNameTest(){
        List<Tower> towerList = testRoundOneInventoryService.getTowerList();
        assertEquals(towerList.get(0).getTowerName(), "Heavy Coal");
        assertEquals(towerList.get(1).getTowerName(), "Light Coal");
        assertEquals(towerList.get(2).getTowerName(), "Heavy Iron");
        assertEquals(towerList.get(3).getTowerName(), "Light Iron");
        assertEquals(towerList.get(4).getTowerName(), "Heavy Gold");
        assertEquals(towerList.get(5).getTowerName(), "Light Gold");

    }
}
