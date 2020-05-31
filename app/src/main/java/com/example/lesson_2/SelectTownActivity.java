package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelectTownActivity extends AppCompatActivity implements Constants{

    private Button mskBtn, spbBtn, rndBtn, okBtn;
    private EditText townEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellect_town);
        findView();
        listenerBtn(mskBtn);
        listenerBtn(spbBtn);
        listenerBtn(rndBtn);
        selectTown();
    }

    private void findView() {
        mskBtn = findViewById(R.id.mskBtn);
        spbBtn = findViewById(R.id.spBtn);
        rndBtn = findViewById(R.id.rostovBtn);
        townEditText = findViewById(R.id.findTownEditText);
        okBtn = findViewById(R.id.okBtn);
    }

    private void listenerBtn(final Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                townEditText.setText(btn.getText());
            }
        });
    }

    private void selectTown() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult= new Intent();
                intentResult.putExtra(TEXT, townEditText.getText().toString());
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}
