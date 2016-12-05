package edu.shu.com.shufinance.Datamodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ParentTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParent() {
        try {
            new Parent("Lewis Hamilton", "lewis@gmail.com", "1234", "9999999999");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testParentIllegalValue() {
        try {
            new Parent(null, null, null, null);

        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }


}