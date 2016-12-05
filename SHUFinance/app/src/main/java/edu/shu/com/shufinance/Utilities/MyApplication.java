package edu.shu.com.shufinance.Utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import edu.shu.com.shufinance.Datamodel.Student;


public class MyApplication extends Application {

    Student loggedinStudent;
    String loginType;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public Student getLoggedinStudent() {
        return loggedinStudent;
    }

    public void setLoggedinStudent(Student loggedinStudent) {
        this.loggedinStudent = loggedinStudent;
    }

    public void savetoSharedPref(Student student) {
        this.setLoggedinStudent(student);
        //Saving the Student Data to sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        Encryption encryption = new Encryption();

        String student_json = gson.toJson(student);
        String encryptedStudentJson = encryption.encryption(student_json);

        switch (student.getStudent_SHU_ID()) {

            case "101":
                editor.putString("student1", encryptedStudentJson);
                editor.commit();
                break;

            case "102":
                editor.putString("student2", encryptedStudentJson);
                editor.commit();

                break;
            case "103":
                editor.putString("student3", encryptedStudentJson);
                editor.commit();
                break;

            case "104":
                editor.putString("student4", encryptedStudentJson);
                editor.commit();
                break;
            case "105":
                editor.putString("student5", encryptedStudentJson);
                editor.commit();
                break;

            default:
                break;


        }
    }
}
