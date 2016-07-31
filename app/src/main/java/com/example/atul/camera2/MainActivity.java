package com.example.atul.camera2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button, button2;
    ImageView imageView, imageView2, imageView3;
    Bitmap bmp;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,a);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){

            Bundle b = data.getExtras();
            bmp = (Bitmap) b.get("data");
            imageView.setImageBitmap(bmp);
            a++;
            //imageView2.setImageBitmap(bmp);
        }

        else if(requestCode==2){
            Bundle b1 = data.getExtras();
            bmp = (Bitmap) b1.get("data");
            imageView2.setImageBitmap(bmp);
            a--;

            if (requestCode==1){
                Bundle b2 = data.getExtras();
                bmp = (Bitmap) b2.get("data");
                imageView3.setImageBitmap(bmp);
            }
        }

        /*else if(requestCode==1){

        }*/

    }
}
