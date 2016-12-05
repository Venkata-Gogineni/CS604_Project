package edu.shu.com.shufinance.Datamodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.fail;


public class StudentTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testStudent() {
        try {
            Balance student_balance = new Balance("2500", "500", "550", "200", "200", "100");
            TransactionHistory student_transactionHistory = new TransactionHistory("105001", "Credit Card", "1500");
            ArrayList<TransactionHistory> student_transactionHistoryArrayList = new ArrayList<>();
            student_transactionHistoryArrayList.add(0, student_transactionHistory);
            Parent student_parent = new Parent("Lewis Hamilton", "lewis@gmail.com", "1234", "9999999999");
            new Student("Massa Hamilton", "105", "Information Technology", "massa@gmail.com", "1234", "1212121212", student_parent, student_transactionHistoryArrayList, student_balance);


        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testStudentIllegalValue() {
        try {
            new Student(null, null, null, null, null, null, null, null, null);

        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }

}