package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int RC_NICKNAMEACTIVITY = 110;
    private TextView name;
    private TextView age;
    private TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        if(TextUtils.isEmpty(name.getText().toString())&&TextUtils.isEmpty(age.getText().toString())&&TextUtils.isEmpty(gender.getText().toString())){
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivityForResult(intent,RC_NICKNAMEACTIVITY);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_NICKNAMEACTIVITY){
            if(resultCode != RESULT_OK) {
                finish();
            }

        }
    }
}
