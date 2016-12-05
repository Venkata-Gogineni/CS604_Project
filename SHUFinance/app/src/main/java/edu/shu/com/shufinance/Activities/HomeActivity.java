package edu.shu.com.shufinance.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Datamodel.Student;

import static edu.shu.com.shufinance.R.id.my_profile_button;
import static edu.shu.com.shufinance.R.id.my_shu_balance_button;
import static edu.shu.com.shufinance.R.id.shu_policies_button;
import static edu.shu.com.shufinance.R.id.transaction_history_button;
import static edu.shu.com.shufinance.R.id.transfer_funds_button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView welcomeTextView;
    private Button myProfileButton, transactionHistoryButton, mySHUBalanceButton, transferFundsButton, shuPoliciesButton;
    Student student;
    String loggedinType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        student = ((MyApplication) this.getApplication()).getLoggedinStudent();
        loggedinType = ((MyApplication) this.getApplication()).getLoginType();

        Intent intent = getIntent();
        welcomeTextView = (TextView) findViewById(R.id.welcome_textView);

        if (loggedinType.equalsIgnoreCase("Parent")) {
            welcomeTextView.setText("Welcome " + student.getStudentParent().getParentName());
        } else if (loggedinType.equalsIgnoreCase("Student")) {
            welcomeTextView.setText("Welcome " + student.getStudentName());

        }

        myProfileButton = (Button) findViewById(my_profile_button);
        transactionHistoryButton = (Button) findViewById(transaction_history_button);
        mySHUBalanceButton = (Button) findViewById(my_shu_balance_button);
        transferFundsButton = (Button) findViewById(transfer_funds_button);
        shuPoliciesButton = (Button) findViewById(shu_policies_button);

        myProfileButton.setOnClickListener(this);
        transactionHistoryButton.setOnClickListener(this);
        mySHUBalanceButton.setOnClickListener(this);
        transferFundsButton.setOnClickListener(this);
        shuPoliciesButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case my_profile_button:

                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);

                break;
            case transaction_history_button:

                intent = new Intent(this, TransactionHistoryActivity.class);
                startActivity(intent);
                break;
            case my_shu_balance_button:

                intent = new Intent(this, MySHUBalanceActivity.class);
                startActivity(intent);
                break;
            case transfer_funds_button:
                if (loggedinType.equalsIgnoreCase("Parent")) {
                    intent = new Intent(this, TransferFundsActivity.class);
                    startActivity(intent);
                } else {
                    studentCannotTransferAlert();
                }
                break;
            case shu_policies_button:

                intent = new Intent(this, SHUPoliciesActivity.class);
                startActivity(intent);
                break;


            default:
                break;
        }

    }

    private void studentCannotTransferAlert() {

        new AlertDialog.Builder(this).setTitle("Student Cannot Transfer Funds").setMessage("Only Parent is eligible to transfer Funds.").setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }
}