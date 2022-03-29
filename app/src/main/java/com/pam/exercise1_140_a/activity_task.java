package com.pam.exercise1_140_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class activity_task extends AppCompatActivity
{

    TextView tNama;
    EditText et_Task, et_Jenis, et_Time;
    FloatingActionButton fabAdd;

    String Task, Jenis, Time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        tNama = findViewById(R.id.tNama_task);
        et_Task = findViewById(R.id.etTask_task);
        et_Jenis = findViewById(R.id.etJenis_task);
        et_Time = findViewById(R.id.etTime_task);
        fabAdd = findViewById(R.id.fabAdd_task);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");
        tNama.setText(nama);

        fabAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Task = et_Task.getText().toString();
                Jenis = et_Jenis.getText().toString();
                Time = et_Time.getText().toString();

                if(Task.isEmpty() && Time.isEmpty() && Jenis.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "All data is required!", Toast.LENGTH_LONG).show();
                }
                else if(Jenis.isEmpty() && Time.isEmpty())
                {
                    et_Jenis.setError("Jenis Task!");
                    et_Time.setError("Time Task!");
                }
                else if(Jenis.isEmpty())
                {
                    et_Jenis.setError("Jenis Task!");
                }
                else if(Time.isEmpty())
                {
                    et_Time.setError("Time Task!");
                }
                else if(!Task.isEmpty() && !Jenis.isEmpty() && !Time.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("b", Task.trim());
                    b.putString("c", Jenis.trim());
                    b.putString("d", Time.trim());

                    Intent i = new Intent(getApplicationContext(), activity_result.class);

                    i.putExtras(b);

                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Task = et_Task.getText().toString();
        Jenis = et_Jenis.getText().toString();
        Time = et_Time.getText().toString();

        if(item.getItemId() == R.id.logout)
        {
            Intent iii = new Intent(getApplicationContext(), activity_login.class);
            startActivity(iii);
        }
        else if(Task.isEmpty() && Time.isEmpty() && Jenis.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "All data is required!", Toast.LENGTH_LONG).show();
        }
        else if(Jenis.isEmpty() && Time.isEmpty())
        {
            et_Jenis.setError("Jenis Task!");
            et_Time.setError("Time Task!");
        }
        else if(Jenis.isEmpty())
        {
            et_Jenis.setError("Jenis Task!");
        }else if(Time.isEmpty())
        {
            et_Time.setError("Time Task!");
        }
        else if(item.getItemId() == R.id.submit && !Task.isEmpty() && !Jenis.isEmpty() && !Time.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

            Bundle b = new Bundle();

            b.putString("b", Task.trim());
            b.putString("c", Jenis.trim());
            b.putString("d", Time.trim());

            Intent i = new Intent(getApplicationContext(), activity_result.class);

            i.putExtras(b);

            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}