package edu.shu.com.shufinance.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Utilities.MyUtilities;
import edu.shu.com.shufinance.Datamodel.Student;
import edu.shu.com.shufinance.Datamodel.TransactionHistory;

public class TransferFundsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Student student;
    String loggedinType;
    Button transferFundsNowButton;
    EditText usernameCCEditText, passwordCVCEditText, amountTransferEditText;
    TextView usernameCCTextView, passwordCVCTextView;
    Spinner transferTypeSpinner;
    String selectedTransferType = "Net Banking";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_funds);
        getSupportActionBar().setTitle("TRANSFER FUNDS");
        student = ((MyApplication) this.getApplication()).getLoggedinStudent();
        loggedinType = ((MyApplication) this.getApplication()).getLoginType();

        usernameCCTextView = (TextView) findViewById(R.id.username_cc_textView);
        passwordCVCTextView = (TextView) findViewById(R.id.password_cvc_textView);

        transferTypeSpinner = (Spinner) findViewById(R.id.transfer_type_spinner);
        transferFundsNowButton = (Button) findViewById(R.id.transfer_funds_now_button);
        transferFundsNowButton.setOnClickListener(this);

        usernameCCEditText = (EditText) findViewById(R.id.username_cc_editText);
        passwordCVCEditText = (EditText) findViewById(R.id.password_cvc_editText);
        amountTransferEditText = (EditText) findViewById(R.id.transfer_amount_editText);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transfer_types, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        transferTypeSpinner.setAdapter(adapter);
        transferTypeSpinner.setOnItemSelectedListener(this);
        transferTypeSpinner.setSelection(0);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedTransferType = parent.getItemAtPosition(position).toString();
        if (selectedTransferType.equalsIgnoreCase("Credit Card")) {
            usernameCCTextView.setText("Credit Card Number");
            passwordCVCTextView.setText("CVC Number");
        } else if (selectedTransferType.equalsIgnoreCase("Net Banking")) {
            usernameCCTextView.setText("User Name");
            passwordCVCTextView.setText("Password");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        selectedTransferType = "Net Banking";
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.transfer_funds_now_button:

                if (selectedTransferType.equalsIgnoreCase("Net Banking")) {

                    if (MyUtilities.validateNetBanking(usernameCCEditText.getText().toString(), passwordCVCEditText.getText().toString())) {
                        savetheTransaction();
                        new AlertDialog.Builder(this).setTitle("Transaction Successful!").setMessage("Amount Transferred").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                TransferFundsActivity.this.finish();

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();

                    } else {
                        //invalid netbanking details
                        new AlertDialog.Builder(this).setTitle("Invalid Net Banking Details").setMessage("Please Enter Valid Banking Username and Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
                    }

                } else if (selectedTransferType.equalsIgnoreCase("Credit Card")) {

                    if (MyUtilities.validateCreditCard(usernameCCEditText.getText().toString(), passwordCVCEditText.getText().toString())) {

                        savetheTransaction();
                        new AlertDialog.Builder(this).setTitle("Transaction Successful!").setMessage("Amount Transferred").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                TransferFundsActivity.this.finish();

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();

                    } else {
                        //invalid credit card details
                        new AlertDialog.Builder(this).setTitle("Invalid Credit Card Details").setMessage("Please Enter Credit Card Number and CVC Number").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
                    }
                }

                break;
        }

    }

    private void savetheTransaction() {

        ArrayList<TransactionHistory> transactionHistoryArrayList = new ArrayList<TransactionHistory>();
        int transaction_counter = Integer.parseInt(student.getStudentTransactionHistory().get(student.getStudentTransactionHistory().size() - 1).getTransactionID());
        TransactionHistory transactionHistory = new TransactionHistory(Integer.toString(transaction_counter + 1), selectedTransferType, amountTransferEditText.getText().toString());
        int main_balance = Integer.parseInt(student.getStudentBalance().getMainBalance());
        main_balance = main_balance + Integer.parseInt(amountTransferEditText.getText().toString());
        student.getStudentBalance().setMainBalance(Integer.toString(main_balance));
        student.getStudentTransactionHistory().add(transactionHistory);
        ((MyApplication) this.getApplication()).savetoSharedPref(student);
    }

}