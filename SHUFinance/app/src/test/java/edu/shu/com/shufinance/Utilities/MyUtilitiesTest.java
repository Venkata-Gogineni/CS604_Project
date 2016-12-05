package edu.shu.com.shufinance.Utilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MyUtilitiesTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isPasswordValidPassTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isPasswordValid("1234"));

    }

    @Test
    public void isPasswordValidFailTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertNotEquals(true, myUtilities.isPasswordValid("124"));
    }

    @Test
    public void isPasswordValidNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            assertEquals(false, myUtilities.isPasswordValid(null));
        } catch (NullPointerException e) {

        }

    }

    @Test
    public void isMobileNumberValidPassTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isMobileNumberValid("1234567890"));

    }

    @Test
    public void isMobileNumberValidFailTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isMobileNumberValid("123456789"));

    }

    @Test
    public void isMobileNumberValidNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            assertEquals(false, myUtilities.isMobileNumberValid(null));
        } catch (NullPointerException e) {

        }

    }


    @Test
    public void isEmailValidPassTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isEmailValid("test@test.com"));


    }

    @Test
    public void isEmailValidFailTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isEmailValid("test"));

    }


    @Test
    public void isEmptyFailTest() throws Exception {

        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isEmpty("test"));
    }

    @Test
    public void isEmptyNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            myUtilities.isEmpty(null);
        } catch (NullPointerException e) {

        }

    }

    @Test
    public void validateNetBankingPassTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateNetBanking("SHU", "SHU"));
    }

    @Test
    public void validateNetBankingFailTest() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateNetBanking("test", "SHU"));

    }
    @Test
    public void validateNetBankingNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            myUtilities.validateNetBanking(null, null);
        } catch (NullPointerException e) {

        }

    }

    @Test
    public void validateCreditCardPassTest() throws Exception {

        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateCreditCard("1234567812345678", "123"));
    }

    @Test
    public void validateCreditCardFailTest() throws Exception {

        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateCreditCard("1234567812345678", "223"));
    }

    @Test
    public void validateCreditCardNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            myUtilities.validateCreditCard(null, null);
        } catch (NullPointerException e) {

        }

    }
}