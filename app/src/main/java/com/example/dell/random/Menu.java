package com.example.dell.random;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by dell on 6/10/2015.
 */
public class Menu extends ListActivity {

    String[] classes={"MainActivity","textPlay","Camera","Data","RadioButton",
            "Menutesting","Example 6","Example 7","Example 8","Example 9",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //List View Adapter
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,classes));
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.newmenu,menu);
        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String pos=classes[position];
        Class ourClass= null;
        try {
            ourClass = Class.forName("com.example.dell.random."+pos);
            Intent intent=new Intent(this,ourClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutUs:
                Intent intent=new Intent("com.example.dell.random.AboutUs");
                startActivity(intent);
                Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();
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
