package com.example.pwpb6_lat2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra person";
    public TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = (TextView) findViewById(R.id.tv_object_received);
        Person Persona = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + Persona.getName() + ",Email : " + Persona.getEmail()
                + ",Age : " + Persona.getAge() + ",Location : " + Persona.getCity();
        tvObject.setText(text);
    }
}