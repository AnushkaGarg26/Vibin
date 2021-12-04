package com.android.developer.arslan.advancemusicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VibinCam extends AppCompatActivity {


    Button btnCam;
    public  Button btnsongs;
    ImageView imageDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibin_cam);

        btnCam = (Button) findViewById(R.id.btn_VibinCam);
        btnsongs = (Button) findViewById(R.id.btn_allSongs);
        imageDisplay = (ImageView) findViewById(R.id.imageCapture);
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
                //Intent intent1 = new Intent( packageCon)
            }
        });

        btnsongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(VibinCam.this,Tunes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageDisplay.setImageBitmap(bitmap);
    }
}