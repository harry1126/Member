package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_GENDERACTIVITY =101 ;
    private EditText ed_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findViews();
        setResult(RESULT_OK);
        ed_age = findViewById(R.id.ed_age);

    }
    private void findViews() {
        findViewById(R.id.go_gender_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent2 = new Intent(AgeActivity.this,GenderActivity.class);
        startActivityForResult(intent2,RC_GENDERACTIVITY);
        SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
        pref.edit()
                .putString("AGE",ed_age.getText().toString())
                .commit();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_GENDERACTIVITY) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {

            }
        }
    }
}
