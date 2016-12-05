package edu.shu.com.shufinance.Utilities;


public class MyUtilities {

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 3;
    }

    public static boolean isMobileNumberValid(String mobileNumber) {
        //TODO: Replace this with your own logic
        return mobileNumber.length() > 9;
    }

    public static boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }


    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }


    public static boolean validateNetBanking(String userName, String Password) {

        if (userName.equalsIgnoreCase("SHU") && Password.equalsIgnoreCase("SHU")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean validateCreditCard(String creditCardNumber, String cvcNumber) {
        if (creditCardNumber.equalsIgnoreCase("1234567812345678") && cvcNumber.equalsIgnoreCase("123")) {
            return true;
        } else {
            return false;
        }
    }

}
