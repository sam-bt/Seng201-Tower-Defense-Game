package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.services.RoundService;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test RoundService implementation
 * @author Samuel Beattie
 */
public class RoundServiceTest {
    /**
     * Test 100m track length calculator implementation
     */
    @Test
    void trackLengthTestOne(){
        assertEquals(RoundService.trackLengthCalculator(-10.0),100);
        assertEquals(RoundService.trackLengthCalculator(0.5),100);
        assertEquals(RoundService.trackLengthCalculator(1.0),100);
    }
    /**
     * Test 90m track length calculator implementation
     */
    @Test
    void trackLengthTestTwo(){
        assertEquals(RoundService.trackLengthCalculator(1.5),90);
        assertEquals(RoundService.trackLengthCalculator(2.0),90);
    }
    /**
     * Test 80m track length calculator implementation
     */
    @Test
    void trackLengthTestThree(){
        assertEquals(RoundService.trackLengthCalculator(2.7),80);
        assertEquals(RoundService.trackLengthCalculator(3.0),80);
    }
    /**
     * Test 70m track length calculator implementation
     */
    @Test
    void trackLengthTestFour(){
        assertEquals(RoundService.trackLengthCalculator(3.1),70);
        assertEquals(RoundService.trackLengthCalculator(4),70);
    }
    /**
     * Test 60m track length calculator implementation
     */
    @Test
    void trackLengthTestOFive(){
        assertEquals(RoundService.trackLengthCalculator(4.3),60);
        assertEquals(RoundService.trackLengthCalculator(5),60);
    }
    /**
     * Test 50m track length calculator implementation
     */
    @Test
    void trackLengthTestSix(){
        assertEquals(RoundService.trackLengthCalculator(5.4),50);
        assertEquals(RoundService.trackLengthCalculator(6.0),50);
    }
    /**
     * Test 40m track length calculator implementation
     */
    @Test
    void trackLengthTestSeven(){
        assertEquals(RoundService.trackLengthCalculator(6.1),40);
        assertEquals(RoundService.trackLengthCalculator(7.0),40);
    }
    /**
     * Test 30m track length calculator implementation
     */
    @Test
    void trackLengthTestEight(){
        assertEquals(RoundService.trackLengthCalculator(7.9),30);
        assertEquals(RoundService.trackLengthCalculator(8.0),30);
    }
    /**
     * Test 20m track length calculator implementation
     */
    @Test
    void trackLengthTestNine(){
        assertEquals(RoundService.trackLengthCalculator(9.0),20);
        assertEquals(RoundService.trackLengthCalculator(11.0),20);
    }
}
