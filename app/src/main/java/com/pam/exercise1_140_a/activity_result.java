package com.pam.exercise1_140_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_result extends AppCompatActivity
{
    TextView t_Task, t_Jenis, t_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t_Task = findViewById(R.id.tNamaTask_result);
        t_Jenis = findViewById(R.id.tJenis_result);
        t_Time = findViewById(R.id.tTimeTask_result);

        Bundle bundle = getIntent().getExtras();

        String Task, Jenis, Time;
        Task = bundle.getString("b");
        Jenis = bundle.getString("c");
        Time = bundle.getString("d");

        t_Task.setText(Task);
        t_Jenis.setText(Jenis);
        t_Time.setText(Time);
    }
}