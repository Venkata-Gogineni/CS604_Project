package edu.shu.com.shufinance.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.shu.com.shufinance.R;
import edu.shu.com.shufinance.Utilities.MyApplication;
import edu.shu.com.shufinance.Utilities.MyUtilities;
import edu.shu.com.shufinance.Datamodel.Student;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Student student;
    String loggedinType;
    Button changePAsswordButton, saveProfileButton;
    EditText studentNameEditText, parentNameEditText, studentSHUIDEditText, courseEditText, studentEmailEditText, parentEmailEditText, studentMobileEditText, parentMobileEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("MY PROFILE");

        student = ((MyApplication) this.getApplication()).getLoggedinStudent();
        loggedinType = ((MyApplication) this.getApplication()).getLoginType();

        changePAsswordButton = (Button) findViewById(R.id.change_password_Button);
        saveProfileButton = (Button) findViewById(R.id.save_profile_Button);

        changePAsswordButton.setOnClickListener(this);
        saveProfileButton.setOnClickListener(this);

        studentNameEditText = (EditText) findViewById(R.id.student_name_editText);
        parentNameEditText = (EditText) findViewById(R.id.parent_name_editText);
        studentSHUIDEditText = (EditText) findViewById(R.id.student_shu_id_editText);
        courseEditText = (EditText) findViewById(R.id.course_editText);
        studentEmailEditText = (EditText) findViewById(R.id.student_email_editText);
        parentEmailEditText = (EditText) findViewById(R.id.parent_email_editText);
        studentMobileEditText = (EditText) findViewById(R.id.student_mobile_editText);
        parentMobileEditText = (EditText) findViewById(R.id.parent_mobile_editText);

        studentNameEditText.setText(student.getStudentName());
        parentNameEditText.setText(student.getStudentParent().getParentName());
        studentSHUIDEditText.setText(student.getStudent_SHU_ID());
        courseEditText.setText(student.getStudentCourse());
        studentEmailEditText.setText(student.getStudentEmailID());
        parentEmailEditText.setText(student.getStudentParent().getParentEmailID());
        studentMobileEditText.setText(student.getStudentMobileNumber());
        parentMobileEditText.setText(student.getStudentParent().getParentMobileNumber());


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.change_password_Button:
                Intent intent = new Intent(this, ChangePassword.class);
                startActivity(intent);
                break;
            case R.id.save_profile_Button:
                if (!MyUtilities.isMobileNumberValid(studentMobileEditText.getText().toString())) {
                    new AlertDialog.Builder(this).setTitle("Mobile Number Incorrect").setMessage("Please enter valid Student Mobile Number").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                } else if (!MyUtilities.isMobileNumberValid(parentMobileEditText.getText().toString())) {
                    new AlertDialog.Builder(this).setTitle("Mobile Number Incorrect").setMessage("Please enter valid Parent Mobile Number").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                } else {
                    student.setStudentMobileNumber(studentMobileEditText.getText().toString());
                    student.getStudentParent().setParentMobileNumber(parentMobileEditText.getText().toString());

                    ((MyApplication) this.getApplication()).savetoSharedPref(student);
                    new AlertDialog.Builder(this).setTitle("Profile Saved").setMessage("Mobile Number updated!").setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
                }
                break;

            default:
                break;
        }

    }

}