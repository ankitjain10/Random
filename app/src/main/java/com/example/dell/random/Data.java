package com.example.dell.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Data extends Activity implements View.OnClickListener {

    EditText inputText;
    Button leftButton, rightButton;
    TextView outText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initializer();

    }

    private void initializer() {
        inputText = (EditText) findViewById(R.id.inputText);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        outText = (TextView) findViewById(R.id.outText);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rightButton: {
                Intent intention=new Intent(Data.this,RadioButton.class);
                startActivityForResult(intention,0);
            }
            break;
            case R.id.leftButton: {
            String bread=inputText.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("key",bread);
                Intent intent=new Intent(this,RadioButton.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            break;
                    }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle bundle=data.getExtras();
            String i=bundle.getString("answer");
            outText.setText(i);
        }
    }
}