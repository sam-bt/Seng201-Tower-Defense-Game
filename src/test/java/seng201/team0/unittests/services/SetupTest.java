package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.models.Setup;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test SetupTest implementation
 * @author Samuel Beattie
 */


public class SetupTest {
    /**
     * Test that the name and round number are correctly set
     */
    @Test
    void setupTest(){
        Setup setup = new Setup("Test Player", 15L);
        assertEquals(setup.getName(), "Test Player");
        assertEquals(setup.getNumRounds(), 15);
    }
}
