package com.example.lesson_2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Constants{

    private final String webSite = "https://ru.wikipedia.org/wiki/";
    private ImageButton back, btnWeb;
    private TextView town;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        workBtnBackSellectTown();
        goToWiki();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString(TEXT, town.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        town.setText(saveInstanceState.get(TEXT).toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            town.setText(data.getStringExtra(TEXT));
        }
    }

    private void findView() {
        back = findViewById(R.id.btnBack);
        btnWeb = findViewById(R.id.btnWeb);
        town = findViewById(R.id.myTown);
    }

    private void workBtnBackSellectTown() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SellectTownActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
    }

    private void goToWiki() {
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = webSite + town.getText().toString();
                Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });
    }
}
