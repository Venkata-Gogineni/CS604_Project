package edu.shu.com.shufinance.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.util.ArrayList;

import edu.shu.com.shufinance.Database.SHUDBHelper;
import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.Encryption;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Utilities.MyUtilities;
import edu.shu.com.shufinance.Datamodel.Balance;
import edu.shu.com.shufinance.Datamodel.Parent;
import edu.shu.com.shufinance.Datamodel.Student;
import edu.shu.com.shufinance.Datamodel.TransactionHistory;

import static edu.shu.com.shufinance.Database.SHUDBHelper.retrieveDatatoLogin;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;
    private String selectedLoginType = "Parent";
    private boolean setup = false;
    private boolean loginPassed = false;
    ArrayList<Student> listofStudents = new ArrayList<Student>(5);

    @Override
    protected void onResume() {
        super.onResume();
        loginPassed = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        setup = sharedPreferences.getBoolean("setup", false);
        if (!setup) {
            createSHUData();
        }
        listofStudents = SHUDBHelper.retrieveDatatoLogin(this);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        Spinner loginTypeSpinner = (Spinner) findViewById(R.id.loginType);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.login_types, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        loginTypeSpinner.setAdapter(adapter);
        loginTypeSpinner.setOnItemSelectedListener(this);
        loginTypeSpinner.setSelection(0);
        mLoginFormView = findViewById(R.id.login_form);

    }

    private void createSHUData() {
        SHUDBHelper.createSHUStudentData(this);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("setup", true);
        editor.commit();
    }






    private void attemptLogin() {

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (!MyUtilities.isEmpty(password) && !MyUtilities.isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            cancel = true;
        }

        // Check for a valid email address.
        if (MyUtilities.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            cancel = true;
        } else if (!MyUtilities.isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login
        } else {

            validateEmailPasswordinDB(email, password);

        }
    }


    private void validateEmailPasswordinDB(String email, String password) {


        if (selectedLoginType.equalsIgnoreCase("Parent")) {

            for (Student student : listofStudents) {

                if (student.getStudentParent().getParentEmailID().equalsIgnoreCase(email)) {

                    if (student.getStudentParent().getParentPassword().equalsIgnoreCase(password)) {

                        ((MyApplication) this.getApplication()).setLoggedinStudent(student);
                        ((MyApplication) this.getApplication()).setLoginType(selectedLoginType);

                        loginPassed = true;
                        //proceed to Home as Parent
                        Intent intent = new Intent(this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }
                }
            }

            userNamePasswordNotFoundAlert();

        } else if (selectedLoginType.equalsIgnoreCase("Student")) {

            for (Student student : listofStudents) {
                if (student.getStudentEmailID().equalsIgnoreCase(email)) {

                    if (student.getStudentPassword().equalsIgnoreCase(password)) {
                        ((MyApplication) this.getApplication()).setLoggedinStudent(student);
                        ((MyApplication) this.getApplication()).setLoginType(selectedLoginType);
                        loginPassed = true;
                        //proceed to Home as Student
                        Intent intent = new Intent(this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);


                    }
                }
            }
            userNamePasswordNotFoundAlert();
        }


    }

    private void userNamePasswordNotFoundAlert() {

        if (loginPassed) {

        } else {
            new AlertDialog.Builder(this).setTitle("UserName/Password not Found").setMessage("Please enter valid Username and Password").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            }).setIcon(android.R.drawable.ic_dialog_alert).show();
        }
    }

    
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selectedLoginType = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        selectedLoginType = "Parent";
    }


}

