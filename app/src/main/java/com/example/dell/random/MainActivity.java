package com.example.dell.random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    TextView resultText;
    TextView guessText;
    EditText inputText;
    Button randomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Declare the widgets!
        guessText=(TextView)findViewById(R.id.guessText);
        inputText=(EditText)findViewById(R.id.inputText);
        randomButton=(Button)findViewById(R.id.randomButton);
        resultText =(TextView)findViewById(R.id.resultText);
//Fetch String from EditText
       /* String result=inputText.getText().toString();*/
//OnButtonClick Method
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                final int  randomNum=random.nextInt(6)+1;
                String randomNumString;
                randomNumString=Integer.toString(randomNum);
                resultText.setText("Number Generated is : " + randomNumString);

//compare guessed number with Random Number.
                final int numcomp= Integer.parseInt(inputText.getText().toString());
                if(numcomp==randomNum){
                    guessText.setTextColor(Color.GREEN);
                    guessText.setText("!!Number Matched!!");
                }
                else {
                    guessText.setTextColor(Color.RED);
                    guessText.setText("!!Sorry, Try again!!");
                }
//Clear the EditText again
                inputText.setText("");
            }
        });
    }
}
