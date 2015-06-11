package com.example.dell.random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dell on 6/11/2015.
 */
public class Camera extends Activity implements View.OnClickListener {

    ImageView setPic;
    ImageButton takePic;
    Button setWall;

    final static int cameraData=0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        initiazeparams();
        InputStream is=getResources().openRawResource(R.drawable.icon);
        bmp= BitmapFactory.decodeStream(is);

    }

    private void initiazeparams() {
        setPic=(ImageView)findViewById(R.id.setPic);
        takePic=(ImageButton)findViewById(R.id.takePic);
        setWall=(Button)findViewById(R.id.setWall);
        takePic.setOnClickListener(this);
        setWall.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            bmp=(Bitmap)extras.get("data");
            setPic.setImageBitmap(bmp);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setWall:{
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            break;
            case R.id.takePic:{
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,cameraData);
            }
            break;
        }


    }

}
