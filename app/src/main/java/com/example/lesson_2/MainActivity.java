package com.example.lesson_2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements Constants{

    private final String webSite = "https://ru.wikipedia.org/wiki/";
    private ImageButton backBtn, webBtn;
    private TextView townTextView;
    private Button forDaysBtn, byTheClockBtn;
    private ForDaysFragment forDaysFragment = new ForDaysFragment();
    private ByTheClockFragment byTheClockFragment = new ByTheClockFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        workBtnBackSelectTown();
        goToWiki();
        forDaysBtn.setOnClickListener(new ListenerOnReplace(forDaysFragment));
        byTheClockBtn.setOnClickListener(new ListenerOnReplace(byTheClockFragment));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString(TEXT, townTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        townTextView.setText(Objects.requireNonNull(saveInstanceState.get(TEXT)).toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            townTextView.setText(data.getStringExtra(TEXT));
        }
    }

    private void findView() {
        backBtn = findViewById(R.id.BackBtn);
        webBtn = findViewById(R.id.webBtn);
        townTextView = findViewById(R.id.myTownTextView);
        forDaysBtn = findViewById(R.id.forDaysBtn);
        byTheClockBtn = findViewById(R.id.byTheClockBtn);

    }

    private void workBtnBackSelectTown() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectTownActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
    }

    private void goToWiki() {
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = webSite + townTextView.getText().toString();
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });
    }

    private class ListenerOnReplace implements View.OnClickListener {

        Fragment fragment;

        ListenerOnReplace(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            replaceFragment();
        }

        private void replaceFragment() {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, fragment);
            ft.commit();
        }
    }
}
