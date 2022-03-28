package com.pam.exercise1_140_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {
    Button btSignin;
    EditText et_Nama, et_Password;
    TextView t_Register;
    String name, password, namecheck, passcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btSignin = findViewById(R.id.btSignin_login);
        et_Nama = findViewById(R.id.etNama_login);
        et_Password = findViewById(R.id.etPassword_login);
        t_Register = findViewById(R.id.tRegister_login);

        btSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validation();
            }
        });

        t_Register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),activity_register.class);
                startActivity(intent);
            }
        });
    }

    public void validation(){
        name = et_Nama.getText().toString();
        password = et_Password.getText().toString();
        namecheck = "madd";
        passcheck = "madd123";

        if (name.isEmpty() && password.isEmpty())
        {
            et_Nama.setError("name is required!");
            et_Password.setError("password is required!");
        } else {
            if (name.equals(namecheck) && password.equals(passcheck)){
                Toast t = Toast.makeText(getApplicationContext(),
                        "Successful Login! Your e-mail : ", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                b.putString("a", name.trim());

                Intent i = new Intent(getApplicationContext(), activity_task.class);

                i.putExtras(b);

                startActivity(i);
            } else if (!name.equals(namecheck) && password.equals(passcheck)){
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct name!", Toast.LENGTH_LONG);
                t.show();
            } else if (name.equals(namecheck) && !password.equals(passcheck)){
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct password!", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),"Input the correct name and password!", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }
}