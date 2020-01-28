package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public File mImageFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // open System Camera
        Intent startCameraApp = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES); // private area

        try {
            this.mImageFile = File.createTempFile("testImage", ".jpg", dir);
            Uri uri = FileProvider.getUriForFile(this, "com.example.camera.fileprovider", this.mImageFile);
            startCameraApp.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(startCameraApp, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("app returns");
        ImageView imageView = findViewById(R.id.imageView);
        Bitmap bitmap = BitmapFactory.decodeFile(this.mImageFile.getAbsolutePath());
        imageView.setImageBitmap(bitmap);
        /*Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);*/

    }
}
