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
    public void isPasswordValidEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isPasswordValid("1234"));

    }

    @Test
    public void isPasswordValidNotEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();

        assertNotEquals(false, myUtilities.isPasswordValid("1234"));
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
    public void isMobileNumberValidEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isMobileNumberValid("1234567890"));

    }

    @Test
    public void isMobileNumberValidNotEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertNotEquals(false, myUtilities.isMobileNumberValid("1234567890"));

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
    public void isEmailValidEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isEmailValid("test@test.com"));
        assertEquals(false, myUtilities.isEmailValid("test"));

    }

    @Test
    public void isEmailValidValidNotEquals() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertNotEquals(false, myUtilities.isMobileNumberValid("test@test.com"));

    }

    @Test
    public void isEmailValidNullArguments() throws Exception {

        try {
            MyUtilities myUtilities = new MyUtilities();
            assertEquals(false, myUtilities.isEmailValid(null));
        } catch (NullPointerException e) {

        }

    }

    @Test
    public void isEmpty() throws Exception {

        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.isEmpty(""));
        assertEquals(false, myUtilities.isEmpty("test"));
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
    public void validateNetBanking() throws Exception {
        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateNetBanking("SHU", "SHU"));
        assertEquals(false, myUtilities.validateNetBanking("test", "SHU"));
        assertEquals(false, myUtilities.validateNetBanking("SHU", "test"));
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
    public void validateCreditCard() throws Exception {

        MyUtilities myUtilities = new MyUtilities();
        assertEquals(true, myUtilities.validateCreditCard("1234567812345678", "123"));
        assertEquals(false, myUtilities.validateCreditCard("123", "1234567812345678"));
        assertEquals(false, myUtilities.validateCreditCard("1234567812345678", "test"));
        assertEquals(false, myUtilities.validateCreditCard("test", "123"));


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