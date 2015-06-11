package com.example.dell.random;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dell on 6/10/2015.
 */
public class Menu extends ListActivity {

    String[] classes={"MainActivity","textPlay","Camera","Example 3","Example 4",
            "Example 5","Example 6","Example 7","Example 8","Example 9",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //List View Adapter
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,classes));
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


}
