package seng201.team0.unittests.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seng201.team0.models.Money;
public class MoneyTest {
    private Money testMoney;

    @BeforeEach
    public void setupTest(){
        testMoney = new Money();
    }
}
