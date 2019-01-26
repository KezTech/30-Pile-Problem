package com.example.a30pile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    Button btn2;
    TextView counter;
    EditText range;
    TextView result;
    int con = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaraion of Variables

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        counter = (TextView) findViewById(R.id.count);
        range = (EditText) findViewById(R.id.range);
        result = (TextView) findViewById(R.id.result);


        // Button is disabled by default
        btn2.setEnabled(false);


        // Function for Button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1();

            }
        });


        // Function for Button 1

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2();
            }
        });
    }


    //Called Button 1
    public void btn1() {

        if (con >= 1) {
            if (range.getText().toString().length() == 0) {
                Toast.makeText(getApplicationContext(), "Enter 1-6 Number to Play",
                        Toast.LENGTH_LONG).show();
            } else {

                final int Cval = Integer.parseInt(range.getText().toString());


                if (Cval <= 6) {
                    con = con - Cval;
                    range.getText().clear();
                    btn1.setEnabled(false);
                    btn2.setEnabled(true);
                    counter.setText(Integer.toString(con));
                    Winner();


                } else {
                    Toast.makeText(getApplicationContext(), "Out Of Range! Rule VOID",
                            Toast.LENGTH_LONG).show();
                }


            }


        }


    }


    //Called Button 2

    public void btn2() {

        if (con >= 1) {
            if (range.getText().toString().length() == 0) {
                Toast.makeText(getApplicationContext(), "Enter 1-6 Number to Play",
                        Toast.LENGTH_LONG).show();
            } else {

                final int Cval = Integer.parseInt(range.getText().toString());


                if (Cval <= 6) {
                    con = con - Cval;
                    range.getText().clear();
                    btn1.setEnabled(true);
                    btn2.setEnabled(false);
                    counter.setText(Integer.toString(con));
                    Winner();


                } else {
                    Toast.makeText(getApplicationContext(), "Out Of Range! Rule VOID",
                            Toast.LENGTH_LONG).show();
                }


            }


        }


    }

    //Winner Funtion
    public void Winner() {


        if ((con <= 0) && (btn1.isEnabled())) {


            result.setVisibility(TextView.VISIBLE);


            result.setText("B - Winner Winner Chicken Diiner");

        }
        if ((con <= 0) && (btn2.isEnabled())) {


            result.setVisibility(TextView.VISIBLE);

            result.setText("A - Winner Winner Chicken Dinner");
        }
    }


}
