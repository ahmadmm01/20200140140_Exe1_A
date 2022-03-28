package com.pam.exercise1_140_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class activity_register extends AppCompatActivity {

    EditText et_Nama, et_Email, et_Password, et_RePassword;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_Nama = findViewById(R.id.etNama_register);
        et_Email = findViewById(R.id.etEmail_register);
        et_Password = findViewById(R.id.etPassword_register);
        et_RePassword = findViewById(R.id.etRePassword_register);
        btRegister = findViewById(R.id.btRegister_register);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et_Nama.getText().toString().isEmpty() || et_Email.getText().toString().isEmpty() || et_Password.getText().toString().isEmpty() || et_RePassword.getText().toString().isEmpty()) {
                    Snackbar.make(view, "All data is required to be filled!", Snackbar.LENGTH_LONG).show();
                }
                else {
                    if(et_Password.getText().toString().equals(et_RePassword.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Successfully Register!", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(),activity_task.class);

                        startActivity(i);
                    }
                    else {
                        Snackbar.make(view, "Password and Repassword must be same!", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}