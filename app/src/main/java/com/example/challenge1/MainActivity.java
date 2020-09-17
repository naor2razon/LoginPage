package com.example.challenge1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private EditText edtTextName,edtTextPass,edtTextRePass,edtTextEmail;
    private Button btnPickImage,btnRegister;
    private TextView txtLicense,txtWarnName,txtWarnEmail,txtWarnPass,txtWarnRePass,txtCountry,txtGender;
    private Spinner spinnerCountry;
    private RadioGroup rgGender;
    private CheckBox checkBoxLicenseAgree;
    private ConstraintLayout parent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"will see",Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }

    private void initRegister() {
        Log.d(TAG,"INITREGISTER:started");
        if (validateData()){
            if(checkBoxLicenseAgree.isChecked()){
                showSnackBar();
            }else{
                Toast.makeText(MainActivity.this,"Please agree to License first",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Log.d(TAG,"SHOWSNACKBAR:started");
        txtWarnRePass.setVisibility(View.GONE);
        txtWarnPass.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnName.setVisibility(View.GONE);

        Snackbar.make(parent,"User Registered",Snackbar.LENGTH_INDEFINITE).setAction("Dissmis", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();

    }

    private boolean validateData() {
        Log.d(TAG,"VALIDATEDATA:started");
        if(edtTextName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Please enter name");
            return false;
        }else{
            deleteWarn(txtWarnName);
        }

        if(edtTextEmail.getText().toString().equals("")){
            txtWarnEmail.setVisibility(View.VISIBLE);
            txtWarnEmail.setText("Please enter email");
            return false;
        }else{
            deleteWarn(txtWarnEmail);
        }

        if(edtTextPass.getText().toString().equals("")){
            txtWarnPass.setVisibility(View.VISIBLE);
            txtWarnPass.setText("Please enter password");
            return false;
        }else{
            deleteWarn(txtWarnPass);
        }

        if (edtTextRePass.getText().toString().equals("")){
            txtWarnRePass.setVisibility(View.VISIBLE);
            txtWarnRePass.setText("Please reenter the password");
            return false;
        }else{
            deleteWarn(txtWarnRePass);
        }

        if(!edtTextPass.getText().toString().equals(edtTextRePass.getText().toString())){
            txtWarnRePass.setVisibility(View.VISIBLE);
            txtWarnRePass.setText("Password not match");
            return false;
        }

        return true;

    }

    private void deleteWarn(TextView warn) {
        warn.setVisibility(View.GONE);
    }


    private void initViews() {
        Log.d(TAG,"INITVIEWS:started");

        edtTextName = findViewById(R.id.edtTextName);
        edtTextPass = findViewById(R.id.edtTextPass);
        edtTextEmail = findViewById(R.id.edtTextEmail);
        edtTextRePass = findViewById(R.id.edtTextRePass);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnName= findViewById(R.id.txtWarnName);
        txtWarnPass=findViewById(R.id.txtWarnPass);
        txtWarnRePass=findViewById(R.id.txtWarnRePass);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        rgGender=findViewById(R.id.rgGender);
        checkBoxLicenseAgree=findViewById(R.id.checkBoxLicenseAgree);
        parent=findViewById(R.id.parent);


    }
}