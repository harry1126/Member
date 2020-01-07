package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findViews();
        setResult(RESULT_OK);
        ed_gender = findViewById(R.id.ed_gender);

    }
    private void findViews() {
        findViewById(R.id.goback).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
        pref.edit()
                .putString("USER",ed_gender.getText().toString())
                .commit();
        finish();

    }
}
