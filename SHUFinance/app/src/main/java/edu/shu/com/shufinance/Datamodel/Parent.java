package edu.shu.com.shufinance.Datamodel;


public class Parent {

    String parentName;
    String parentEmailID;
    String parentPassword;
    String parentMobileNumber;


    public Parent(String parentName, String parentEmailID, String parentPassword, String parentMobileNumber) {
        this.parentName = parentName;
        this.parentEmailID = parentEmailID;
        this.parentMobileNumber = parentMobileNumber;
        this.parentPassword = parentPassword;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmailID() {
        return parentEmailID;
    }

    public void setParentEmailID(String parentEmailID) {
        this.parentEmailID = parentEmailID;
    }

    public String getParentMobileNumber() {
        return parentMobileNumber;
    }

    public void setParentMobileNumber(String parentMobileNumber) {
        this.parentMobileNumber = parentMobileNumber;
    }

    public String getParentPassword() {
        return parentPassword;
    }

    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
    }
}
