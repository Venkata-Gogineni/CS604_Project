package edu.shu.com.shufinance.Datamodel;

import java.util.ArrayList;


public class Student {

    String studentName;
    String student_SHU_ID;
    String studentCourse;
    String studentEmailID;
    String studentPassword;
    String studentMobileNumber;
    Parent studentParent;
    ArrayList<TransactionHistory> studentTransactionHistory;
    Balance studentBalance;


    public Student(String studentName, String student_SHU_ID, String studentCourse, String studentEmailID, String studentPassword, String studentMobileNumber, Parent studentParent, ArrayList<TransactionHistory> studentTransactionHistory, Balance studentBalance) {
        this.studentName = studentName;
        this.student_SHU_ID = student_SHU_ID;
        this.studentCourse = studentCourse;
        this.studentEmailID = studentEmailID;
        this.studentMobileNumber = studentMobileNumber;
        this.studentParent = studentParent;
        this.studentTransactionHistory = studentTransactionHistory;
        this.studentBalance = studentBalance;
        this.studentPassword = studentPassword;
    }

    public ArrayList<TransactionHistory> getStudentTransactionHistory() {
        return studentTransactionHistory;
    }

    public void setStudentTransactionHistory(ArrayList<TransactionHistory> studentTransactionHistory) {
        this.studentTransactionHistory = studentTransactionHistory;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudent_SHU_ID() {
        return student_SHU_ID;
    }

    public void setStudent_SHU_ID(String student_SHU_ID) {
        this.student_SHU_ID = student_SHU_ID;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentEmailID() {
        return studentEmailID;
    }

    public void setStudentEmailID(String studentEmailID) {
        this.studentEmailID = studentEmailID;
    }

    public String getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(String studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }

    public Parent getStudentParent() {
        return studentParent;
    }

    public void setStudentParent(Parent studentParent) {
        this.studentParent = studentParent;
    }


    public Balance getStudentBalance() {
        return studentBalance;
    }

    public void setStudentBalance(Balance studentBalance) {
        this.studentBalance = studentBalance;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }


}
