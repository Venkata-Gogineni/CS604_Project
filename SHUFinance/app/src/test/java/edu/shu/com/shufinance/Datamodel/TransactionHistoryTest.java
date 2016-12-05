package edu.shu.com.shufinance.Datamodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class TransactionHistoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testBalance() {
        try {
            new TransactionHistory("105003", "Credit Card", "2000");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testBalanceIllegalValue() {
        try {
            new TransactionHistory(null, null, null);

        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }


}