package com.gihansandaru.camera2compact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.CharacterPickerDialog;
import android.view.TextureView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.gihansandaru.camera2apihelper.CameraAPIHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private CameraAPIHelper cameraAPIHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextureView textureView = findViewById(R.id.textureview);
         int writeExternalStoragePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        int cameraPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 2);
        }else {
            cameraAPIHelper = new CameraAPIHelper.Builder(textureView, this)
                    .setCameraType(CameraAPIHelper.CameraType.BACK)
                    .setImageCompressionRatio(80)
                    .setImageWidthandHeight(600, 600)
                    .build();
        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File saveFile = new File(Environment.getExternalStorageDirectory(), "gihantest.png");
                cameraAPIHelper.takePictureAndSavetoFile(saveFile, new CameraAPIHelper.CameraAPIFileReadyCallBack() {
                    @Override
                    public void fileReady(File file) {
                        if(file.exists()){
                            int a=0;
                            //cameraAPIHelper.closeCamera();
                        }
                    }
                });

            }
        });


    }
}
