package com.example.lesson_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellect_town);
        Toast.makeText(getApplicationContext(), "on Create", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "on Start", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Start");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "on Restore", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Restore");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "on Resume", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "on Pause", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "on Stop", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "on Restart", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "on Destroy", Toast.LENGTH_SHORT).show();
        Log.d("log", "on Destroy");
    }
}
