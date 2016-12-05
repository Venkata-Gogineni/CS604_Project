package edu.shu.com.shufinance.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Datamodel.Student;

public class MySHUBalanceActivity extends AppCompatActivity {

    private TextView mainBalanceTextView, laundryBalanceTextView, foodBalanceTextView, printingBalanceTextView, bookStoreBalanceTextView, generalBalance;
    Student student;
    String loggedinType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        getSupportActionBar().setTitle("MY SHU BALANCE");
        student = ((MyApplication) this.getApplication()).getLoggedinStudent();
        loggedinType = ((MyApplication) this.getApplication()).getLoginType();

        mainBalanceTextView = (TextView) findViewById(R.id.value_main_balance_textView);
        laundryBalanceTextView = (TextView) findViewById(R.id.value_laundry_balance_textView);
        foodBalanceTextView = (TextView) findViewById(R.id.value_food_balance_textView);
        printingBalanceTextView = (TextView) findViewById(R.id.value_printing_balance_textView);
        bookStoreBalanceTextView = (TextView) findViewById(R.id.value_bookstore_balance_textView);
        generalBalance = (TextView) findViewById(R.id.value_general_balance_textView);

        mainBalanceTextView.setText("$" + student.getStudentBalance().getMainBalance());
        laundryBalanceTextView.setText("$" + student.getStudentBalance().getLaundryBalance());
        foodBalanceTextView.setText("$" + student.getStudentBalance().getFoodBalance());
        printingBalanceTextView.setText("$" + student.getStudentBalance().getPrintingBalance());
        bookStoreBalanceTextView.setText("$" + student.getStudentBalance().getBookStoreBalance());
        generalBalance.setText("$" + student.getStudentBalance().getGeneralBalance());


    }
}
