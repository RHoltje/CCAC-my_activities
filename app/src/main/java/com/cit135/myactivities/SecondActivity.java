package com.cit135.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btnGo_back_to_Main_Activity;
    private TextView displayMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(this, "toasty message for the second activity",
                Toast.LENGTH_SHORT).show();


        //getting the message from the main activity
        Bundle myextras = getIntent().getExtras();

        displayMessage = (TextView) findViewById(R.id.textView);

        //conditional statement
        if (myextras != null) {
            String mymessage = myextras.getString("Message");
            int myInt = myextras.getInt("value");
            displayMessage.setText(mymessage + " " + String.valueOf(myInt));

        }


        //button actions
        btnGo_back_to_Main_Activity = (Button) findViewById(R.id.btnSubmit2);
        btnGo_back_to_Main_Activity.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //message (intent) for main activity goes here
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                intent.putExtra("Second_Activity_Speaks", "I am from the Second Activity!" );
                intent.putExtra("moreNumbers", 1492);

                startActivity(intent);


               // startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });
    }
}
