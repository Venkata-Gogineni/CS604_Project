package edu.shu.com.shufinance.Datamodel;


public class Balance {


    String mainBalance;
    String laundryBalance;
    String foodBalance;
    String printingBalance;
    String bookStoreBalance;
    String generalBalance;


    public Balance(String mainBalance, String laundryBalance, String foodBalance, String printingBalance, String bookStoreBalance, String generalBalance) {
        this.mainBalance = mainBalance;
        this.laundryBalance = laundryBalance;
        this.foodBalance = foodBalance;
        this.printingBalance = printingBalance;
        this.bookStoreBalance = bookStoreBalance;
        this.generalBalance = generalBalance;
    }

    public String getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(String mainBalance) {
        this.mainBalance = mainBalance;
    }

    public String getLaundryBalance() {
        return laundryBalance;
    }

    public void setLaundryBalance(String laundryBalance) {
        this.laundryBalance = laundryBalance;
    }

    public String getFoodBalance() {
        return foodBalance;
    }

    public void setFoodBalance(String foodBalance) {
        this.foodBalance = foodBalance;
    }

    public String getPrintingBalance() {
        return printingBalance;
    }

    public void setPrintingBalance(String printingBalance) {
        this.printingBalance = printingBalance;
    }

    public String getBookStoreBalance() {
        return bookStoreBalance;
    }

    public void setBookStoreBalance(String bookStoreBalance) {
        this.bookStoreBalance = bookStoreBalance;
    }

    public String getGeneralBalance() {
        return generalBalance;
    }

    public void setGeneralBalance(String generalBalance) {
        this.generalBalance = generalBalance;
    }
}
