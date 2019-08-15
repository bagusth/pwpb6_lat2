package com.example.pwpb6_lat2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity;
    public Button btnMovewithDataActivity;
    public Button btnMoveActivityWithObject;
    public Button btnMoveWithObject;

    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMovewithDataActivity = (Button) findViewById(R.id.btn_move_with_data_activity);
        btnMovewithDataActivity.setOnClickListener(this);

        btnMoveActivityWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        btnMoveActivityWithObject.setOnClickListener(this);

        btnDialNumber = (Button) findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        btnMoveResult = (Button) findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Bagus Tito Hindarto");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, "17");
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person Persona = new Person();
                Persona.setName("Bagus Tito Hindarto");
                Persona.setAge(17);
                Persona.setEmail("bagustitohindarto112@gmail.com");
                Persona.setCity("Bandoeng");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);

                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, Persona);
                startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "089656634632";
                Intent dialPhoneNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneNumber);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
