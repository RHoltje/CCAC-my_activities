package com.cit135.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnGo_to_Second_Activity;
    private TextView msg_from_second_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "toasty toasted toast",
                Toast.LENGTH_SHORT).show();





        //bundle object that will get and hold stuff from second activity
        Bundle extras_from_second_activity = getIntent().getExtras();

        //create text view filled by message from second activity
        msg_from_second_activity = (TextView) findViewById(R.id.textView2);
        //conditional statement
        if(extras_from_second_activity != null) {


            String anotherMessage = extras_from_second_activity.getString("Second_Activity_Speaks");

            int anotherInt = extras_from_second_activity.getInt("moreNumbers");
            msg_from_second_activity.setText(anotherMessage+ " " + String.valueOf(anotherInt));

        }



        btnGo_to_Second_Activity = (Button) findViewById(R.id.btnSubmit);
        btnGo_to_Second_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(MainActivity.this, SecondActivity.class));

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("Message", "The Main Activity says hello" );
                intent.putExtra("SecondMsg", "Hola from Main Act");
                intent.putExtra("value", 90210);

                startActivity(intent);
                }

        });

    }
}
