package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SellectTownActivity extends AppCompatActivity implements Constants{

    private Button msk, spb, rnd, ok;
    private EditText town;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellect_town);
        find();
        listenerBtn(msk);
        listenerBtn(spb);
        listenerBtn(rnd);
        sellectTown();
    }

    private void find() {
        msk = findViewById(R.id.moscow);
        spb = findViewById(R.id.sp);
        rnd = findViewById(R.id.rostov);
        town = findViewById(R.id.findTown);
        ok = findViewById(R.id.ok);
    }

    private void listenerBtn(final Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                town.setText(btn.getText());
            }
        });
    }

    private void sellectTown() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult= new Intent();
                intentResult.putExtra(TEXT, town.getText().toString());
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}
