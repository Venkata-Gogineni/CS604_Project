package edu.shu.com.shufinance.Database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import edu.shu.com.shufinance.Datamodel.Balance;
import edu.shu.com.shufinance.Datamodel.Parent;
import edu.shu.com.shufinance.Datamodel.Student;
import edu.shu.com.shufinance.Datamodel.TransactionHistory;
import edu.shu.com.shufinance.Utilities.Encryption;

/**
 * Created by Surya Gogineni on 12/4/2016.
 */

public class SHUDBHelper {



    public static void createSHUStudentData(Context context) {

        //Student1 Data creation
        Balance student1_balance = new Balance("2000", "200", "250", "100", "150", "300");
        TransactionHistory student1_transactionHistory1 = new TransactionHistory("101001", "Credit Card", "2000");
        TransactionHistory student1_transactionHistory2 = new TransactionHistory("101002", "Net Banking", "3000");
        TransactionHistory student1_transactionHistory3 = new TransactionHistory("101003", "Credit Card", "2000");
        ArrayList<TransactionHistory> student1_transactionHistoryArrayList = new ArrayList<>();
        student1_transactionHistoryArrayList.add(0, student1_transactionHistory1);
        student1_transactionHistoryArrayList.add(1, student1_transactionHistory2);
        student1_transactionHistoryArrayList.add(2, student1_transactionHistory3);
        Parent student1_parent = new Parent("Ross Appleseed", "ross@gmail.com", "1234", "1111111111");
        Student student1 = new Student("John Appleseed", "101", "Information Technology", "john@gmail.com", "1234", "2222222222", student1_parent, student1_transactionHistoryArrayList, student1_balance);

        //Student2 Data creation
        Balance student2_balance = new Balance("2500", "200", "250", "400", "150", "300");
        TransactionHistory student2_transactionHistory1 = new TransactionHistory("102001", "Credit Card", "2000");
        TransactionHistory student2_transactionHistory2 = new TransactionHistory("102002", "Net Banking", "5000");
        TransactionHistory student2_transactionHistory3 = new TransactionHistory("102003", "Credit Card", "1000");
        ArrayList<TransactionHistory> student2_transactionHistoryArrayList = new ArrayList<>();
        student2_transactionHistoryArrayList.add(0, student2_transactionHistory1);
        student2_transactionHistoryArrayList.add(1, student2_transactionHistory2);
        student2_transactionHistoryArrayList.add(2, student2_transactionHistory3);
        Parent student2_parent = new Parent("Dwayne Bravo", "dwayne@gmail.com", "1234", "3333333333");
        Student student2 = new Student("Darren Bravo", "102", "Information Technology", "darren@gmail.com", "1234", "4444444444", student2_parent, student2_transactionHistoryArrayList, student2_balance);

        //Student3 Data creation
        Balance student3_balance = new Balance("1500", "200", "150", "100", "200", "300");
        TransactionHistory student3_transactionHistory1 = new TransactionHistory("103001", "Credit Card", "1000");
        TransactionHistory student3_transactionHistory2 = new TransactionHistory("103002", "Net Banking", "4000");
        TransactionHistory student3_transactionHistory3 = new TransactionHistory("103003", "Credit Card", "1000");
        ArrayList<TransactionHistory> student3_transactionHistoryArrayList = new ArrayList<>();
        student3_transactionHistoryArrayList.add(0, student3_transactionHistory1);
        student3_transactionHistoryArrayList.add(1, student3_transactionHistory2);
        student3_transactionHistoryArrayList.add(2, student3_transactionHistory3);
        Parent student3_parent = new Parent("Wayne Rooney", "wayne@gmail.com", "1234", "5555555555");
        Student student3 = new Student("Kai Rooney", "103", "Information Technology", "kai@gmail.com", "1234", "6666666666", student3_parent, student3_transactionHistoryArrayList, student3_balance);

        //Student4 Data creation
        Balance student4_balance = new Balance("1500", "200", "150", "100", "200", "300");
        TransactionHistory student4_transactionHistory1 = new TransactionHistory("104001", "Credit Card", "1500");
        TransactionHistory student4_transactionHistory2 = new TransactionHistory("104002", "Net Banking", "2000");
        TransactionHistory student4_transactionHistory3 = new TransactionHistory("104003", "Credit Card", "2000");
        ArrayList<TransactionHistory> student4_transactionHistoryArrayList = new ArrayList<>();
        student4_transactionHistoryArrayList.add(0, student4_transactionHistory1);
        student4_transactionHistoryArrayList.add(1, student4_transactionHistory2);
        student4_transactionHistoryArrayList.add(2, student4_transactionHistory3);
        Parent student4_parent = new Parent("Ricky Pointing", "ricky@gmail.com", "1234", "7777777777");
        Student student4 = new Student("Max Pointing", "104", "Information Technology", "max@gmail.com", "1234", "8888888888", student4_parent, student4_transactionHistoryArrayList, student4_balance);

        //Student5 Data creation
        Balance student5_balance = new Balance("2500", "500", "550", "200", "200", "100");
        TransactionHistory student5_transactionHistory1 = new TransactionHistory("105001", "Credit Card", "1500");
        TransactionHistory student5_transactionHistory2 = new TransactionHistory("105002", "Net Banking", "2000");
        TransactionHistory student5_transactionHistory3 = new TransactionHistory("105003", "Credit Card", "2000");
        ArrayList<TransactionHistory> student5_transactionHistoryArrayList = new ArrayList<>();
        student5_transactionHistoryArrayList.add(0, student5_transactionHistory1);
        student5_transactionHistoryArrayList.add(1, student5_transactionHistory2);
        student5_transactionHistoryArrayList.add(2, student5_transactionHistory3);
        Parent student5_parent = new Parent("Lewis Hamilton", "lewis@gmail.com", "1234", "9999999999");
        Student student5 = new Student("Massa Hamilton", "105", "Information Technology", "massa@gmail.com", "1234", "1212121212", student5_parent, student5_transactionHistoryArrayList, student5_balance);

        //Saving the Student Data to sharedpreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        Encryption encryption = new Encryption();

        String student1_json = gson.toJson(student1);
        String encryptedStudent1Json = encryption.encryption(student1_json);
        editor.putString("student1", encryptedStudent1Json);

        String student2_json = gson.toJson(student2);
        String encryptedStudent2Json = encryption.encryption(student2_json);
        editor.putString("student2", encryptedStudent2Json);

        String student3_json = gson.toJson(student3);
        String encryptedStudent3Json = encryption.encryption(student3_json);
        editor.putString("student3", encryptedStudent3Json);

        String student4_json = gson.toJson(student4);
        String encryptedStudent4Json = encryption.encryption(student4_json);
        editor.putString("student4", encryptedStudent4Json);

        String student5_json = gson.toJson(student5);
        String encryptedStudent5Json = encryption.encryption(student5_json);
        editor.putString("student5", encryptedStudent5Json);

        editor.commit();

    }



    public static ArrayList<Student> retrieveDatatoLogin(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        Encryption encryption = new Encryption();

        String student1Retrieved = sharedPreferences.getString("student1", "");
        String student1Decrypted = encryption.decryption(student1Retrieved);
        Student student1 = gson.fromJson(student1Decrypted, Student.class);

        String student2Retrieved = sharedPreferences.getString("student2", "");
        String student2Decrypted = encryption.decryption(student2Retrieved);
        Student student2 = gson.fromJson(student2Decrypted, Student.class);

        String student3Retrieved = sharedPreferences.getString("student3", "");
        String student3Decrypted = encryption.decryption(student3Retrieved);
        Student student3 = gson.fromJson(student3Decrypted, Student.class);

        String student4Retrieved = sharedPreferences.getString("student4", "");
        String student4Decrypted = encryption.decryption(student4Retrieved);
        Student student4 = gson.fromJson(student4Decrypted, Student.class);

        String student5Retrieved = sharedPreferences.getString("student5", "");
        String student5Decrypted = encryption.decryption(student5Retrieved);
        Student student5 = gson.fromJson(student5Decrypted, Student.class);

        //add the student objects to the student list
        ArrayList<Student> studentArrayList = new ArrayList<Student>(5);
        studentArrayList.add(0, student1);
        studentArrayList.add(1, student2);
        studentArrayList.add(2, student3);
        studentArrayList.add(3, student4);
        studentArrayList.add(4, student5);

        return studentArrayList;
    }
}
