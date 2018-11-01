package com.example.nikhil.videorecorderdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static boolean CAMERA_AVAILABLE = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //note if camera available.
        CAMERA_AVAILABLE = checkIfCameraAvailable(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Button startCameraBtn = findViewById(R.id.btn_start_camera);

        //disable btn if unavailable
        if (CAMERA_AVAILABLE) {
            startCameraBtn.setEnabled(true);
        } else {
            startCameraBtn.setEnabled(false);
        }


        startCameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start camera activity
                Intent i = new Intent(MainActivity.this, RecorderActivity.class);
                startActivity(i);
            }
        });
    }

    //method to check camera availability in device
    private boolean checkIfCameraAvailable(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }


    }
}
