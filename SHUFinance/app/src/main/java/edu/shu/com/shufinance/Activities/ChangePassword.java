package edu.shu.com.shufinance.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Utilities.MyUtilities;
import edu.shu.com.shufinance.Datamodel.Student;

public class ChangePassword extends AppCompatActivity implements View.OnClickListener {

    private EditText currentPasswordEditText, newPasswordEditText, confirmNewPasswordEditText;
    private Button submitButton;
    Student student;
    String loggedinType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setTitle("CHANGE PASSWORD");

        student = ((MyApplication) this.getApplication()).getLoggedinStudent();
        loggedinType = ((MyApplication) this.getApplication()).getLoginType();

        currentPasswordEditText = (EditText) findViewById(R.id.current_password_editText);
        newPasswordEditText = (EditText) findViewById(R.id.new_password_editText);
        confirmNewPasswordEditText = (EditText) findViewById(R.id.confirm_new_password_editText);
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:

                if (!MyUtilities.isEmpty(currentPasswordEditText.getText().toString()) && !MyUtilities.isPasswordValid(currentPasswordEditText.getText().toString())) {

                    new AlertDialog.Builder(this).setTitle("Current Password is Incorrect").setMessage("Please enter valid Current Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

                } else if (!MyUtilities.isEmpty(newPasswordEditText.getText().toString()) || !MyUtilities.isPasswordValid(newPasswordEditText.getText().toString())) {
                    new AlertDialog.Builder(this).setTitle("New Password is Incorrect").setMessage("Please enter valid New Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

                } else if (!MyUtilities.isEmpty(confirmNewPasswordEditText.getText().toString()) || !MyUtilities.isPasswordValid(confirmNewPasswordEditText.getText().toString())) {
                    new AlertDialog.Builder(this).setTitle("Confirm New Password is Incorrect").setMessage("Please enter valid Confirm New Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

                } else if (newPasswordEditText.getText().toString().equalsIgnoreCase(confirmNewPasswordEditText.getText().toString())) {

                    if (loggedinType.equalsIgnoreCase("Parent")) {
                        if (currentPasswordEditText.getText().toString().equalsIgnoreCase(student.getStudentParent().getParentPassword())) {

                            student.getStudentParent().setParentPassword(newPasswordEditText.getText().toString());
                            ((MyApplication) this.getApplication()).savetoSharedPref(student);
                            new AlertDialog.Builder(this).setTitle("Password Changed").setMessage("Password is updated!").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    ChangePassword.this.finish();
                                }
                            }).setIcon(android.R.drawable.ic_dialog_alert).show();

                        } else {
                            //current password is incorrect
                            new AlertDialog.Builder(this).setTitle("Current Password is Incorrect").setMessage("Please enter valid Current Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                }
                            }).setIcon(android.R.drawable.ic_dialog_alert).show();
                        }

                    } else if (loggedinType.equalsIgnoreCase("Student")) {
                        if (currentPasswordEditText.getText().toString().equalsIgnoreCase(student.getStudentParent().getParentPassword())) {

                            student.setStudentPassword(newPasswordEditText.getText().toString());
                            ((MyApplication) this.getApplication()).savetoSharedPref(student);
                            new AlertDialog.Builder(this).setTitle("Password Changed").setMessage("Password is updated!").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    ChangePassword.this.finish();
                                }
                            }).setIcon(android.R.drawable.ic_dialog_alert).show();

                        } else {
                            //current password is incorrect
                            new AlertDialog.Builder(this).setTitle("Current Password is Incorrect").setMessage("Please enter valid Current Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                }
                            }).setIcon(android.R.drawable.ic_dialog_alert).show();
                        }

                    }

                } else {
                    //new password and confirm new password do not match
                    new AlertDialog.Builder(this).setTitle("New Password Error").setMessage("New Password and Confirm New Password do not match.").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                }

                break;
        }
    }
}
