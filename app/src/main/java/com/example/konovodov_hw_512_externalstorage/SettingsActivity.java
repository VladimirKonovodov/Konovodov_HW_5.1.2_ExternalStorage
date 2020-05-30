package com.example.konovodov_hw_512_externalstorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class SettingsActivity extends AppCompatActivity {
    private Button applyPathBtn;
    private EditText editTextPath;
    public static final int REQUEST_CODE_PERMISSION_WRITE_STORAGE = 100;
    public File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        applyPathBtn = findViewById(R.id.applyPathBtn);
        editTextPath = findViewById(R.id.editTextPath);

        applyPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int permissionStatus = ContextCompat.checkSelfPermission(SettingsActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
                    loadImg();
                } else {
                    ActivityCompat.requestPermissions(SettingsActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSION_WRITE_STORAGE);

                }
            }
        });

    }



    private void loadImg() {

        if (isExternalStorageWritable()) {

            try {
                String fileName = String.valueOf(editTextPath.getText());

                file = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

            }
            catch(Exception e){
                Toast.makeText(this, "проблемы с именем файла", Toast.LENGTH_SHORT).show();
            }

            ImageView imageView = findViewById(R.id.imVSettingsBackground);
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bitmap!=null) {
                imageView.setImageBitmap(bitmap);

                Intent intent = new Intent(this, MainActivity.class);
                // указываем первым параметром ключ, а второе значение
                // по ключу мы будем получать значение с Intent

                bitmap.getByteCount();
                intent.putExtra("name", file.getName());
                intent.putExtra("filepath", file.getAbsolutePath());

                // показываем новое Activity
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Такого файла не существует.\n Введите другое имя", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResult) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION_WRITE_STORAGE:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    loadImg();
                } else {
                    //Not Work
                    Toast.makeText(SettingsActivity.this, "Разрешение на доступ отсутствует", Toast.LENGTH_SHORT).show();
                }
        }
    }


}
