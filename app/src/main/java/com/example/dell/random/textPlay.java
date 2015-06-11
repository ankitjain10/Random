package com.example.dell.random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

import static android.view.Gravity.RIGHT;

/**
 * Created by dell on 6/10/2015.
 */
public class textPlay extends Activity implements View.OnClickListener
{
    EditText inputText;
    Button submitButton;
    ToggleButton toggleButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_play);
        cheese();
        toggleButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    private void cheese() {
        submitButton = (Button) findViewById(R.id.sButton);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        inputText = (EditText) findViewById(R.id.inputText);
        resultText = (TextView) findViewById(R.id.resultText);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sButton: {
                String inputString = inputText.getText().toString();
                if (inputString.contentEquals("left")) {
                    resultText.setText(inputString);
                    resultText.setGravity(Gravity.START);
                } else if (inputString.contentEquals("right")) {
                    resultText.setText(inputString);
                    resultText.setGravity(RIGHT);
                } else if (inputString.contentEquals("center")) {
                    resultText.setText(inputString);
                    resultText.setGravity(Gravity.CENTER);
                } else if (inputString.contentEquals("blue")) {
                    resultText.setTextColor(Color.BLUE);
                } else if (inputString.contentEquals("green")) {
                    resultText.setTextColor(Color.GREEN);
                } else if (inputString.contentEquals("red")) {
                    resultText.setTextColor(Color.RED);
                } else if (inputString.contains("wtf")) {
                    Random num = new Random();
                    resultText.setText("wtf");
                    resultText.setTextSize(num.nextInt(175));
                    resultText.setTextColor(Color.rgb(num.nextInt(255), num.nextInt(255), num.nextInt(255)));
                    switch (num.nextInt(3)) {
                        case 0: {
                            resultText.setGravity(Gravity.START);
                            break;
                        }
                        case 1: {
                            resultText.setGravity(Gravity.CENTER);
                            break;
                        }
                        case 2: {
                            resultText.setGravity(Gravity.END);
                            break;
                        }

                    }
                } else
                    Toast.makeText(textPlay.this, "clicked", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.toggleButton: {
                if (toggleButton.isChecked())
                    inputText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                else
                    inputText.setInputType(InputType.TYPE_CLASS_TEXT);

            }
            break;

        }
    }
}


