package edu.shu.com.shufinance.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import edu.shu.com.shufinance.Adapters.TransactionsAdapter;
import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Datamodel.Student;


public class TransactionHistoryActivity extends AppCompatActivity {

    Student student;
    String loggedinType;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

    }
}
