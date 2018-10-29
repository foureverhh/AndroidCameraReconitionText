package com.example.zfgg04.androidcamerareconitiontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.text.TextRecognizer;

public class MainActivity extends AppCompatActivity {

    SurfaceView cameraView;
    TextView textView;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = findViewById(R.id.surface_view);
        textView = findViewById(R.id.text_view);

        //Set Detector as TextRecognizer
        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

        //Set CameraSource to transfer info from camera to detector
        cameraSource = new CameraSource.Builder(getApplicationContext(),textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280,1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build();

    }
}
