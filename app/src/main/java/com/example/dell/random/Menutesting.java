package com.example.dell.random;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Menutesting extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutesting);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.newmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.aboutUs:
            Intent intent=new Intent("com.example.dell.random.AboutUs");
            startActivity(intent);
            Toast.makeText(this,"About Us",Toast.LENGTH_LONG).show();
            break;
        case R.id.prefer:
            Intent intent1=new Intent("com.example.dell.random.Preferences");
            startActivity(intent1);
            Toast.makeText(this,"Preferences",Toast.LENGTH_LONG).show();
            break;
    }
        return false;
    }
}
