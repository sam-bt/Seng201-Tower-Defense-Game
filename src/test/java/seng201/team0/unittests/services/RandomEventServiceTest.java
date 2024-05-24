package seng201.team0.unittests.services;

import org.junit.jupiter.api.Test;
import seng201.team0.services.RandomEventGenerator;
import static org.junit.jupiter.api.Assertions.assertTrue;
class RandomEventServiceTest {
    @Test
    void generateLikelyTest(){
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(5);
        int generated = randomEventGenerator.generate();
        assertTrue(generated >= 5 && generated <= 15);
    }
    @Test
    void generateUnlikelyTest(){
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(1);
        int generated = randomEventGenerator.generate();
        assertTrue(generated >= 1 && generated <= 11);
    }
    @Test
    void generateRoundOneIndexTest(){
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(5);
        int generated = randomEventGenerator.generateRoundOneIndex();
        assertTrue(generated >= 0 && generated <= 2);
    }
    @Test
    void generateRoundIndexTest(){
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(1);
        int generated = randomEventGenerator.generateRoundIndex();
        assertTrue(generated >= 0 && generated <= 4);
    }
    }
