package com.example.dell.random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class RadioButton extends ActionBarActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    TextView outText,inputText;
    Button returnButton;
    RadioGroup radioGroup;
    String getBread,setData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        init();
        //Bundle bundle=getIntent().getExtras();
        //getBread=bundle.getString("key");

        //inputText.setText(getBread);

    }

    private void init() {
        outText=(TextView)findViewById(R.id.outText);
        inputText=(TextView)findViewById(R.id.inputText);
        returnButton=(Button)findViewById(R.id.returnButton);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        returnButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        Bundle bundle=new Bundle();
        Intent intent=new Intent(RadioButton.this,Data.class);
        bundle.putString("answer",setData);
        //intent.getExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
        Toast.makeText(this,"clicked mee ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb1:
            {
                setData="ok!";
            }
            break;
            case R.id.rb2:
            {
                setData="yes!";
            }
            break;
            case R.id.rb3:
            {
                setData="no!";
            }
            break;
        }
        outText.setText(setData);
    }
}
