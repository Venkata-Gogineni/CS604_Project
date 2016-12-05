package edu.shu.com.shufinance.Datamodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class BalanceTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBalance() {
        try {
            new Balance("2500", "500", "550", "200", "200", "100");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


}