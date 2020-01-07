package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_AGEACTIVITY =100 ;
    private EditText nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        findViews();
        setResult(RESULT_OK);
        nickname = findViewById(R.id.nickname);

    }
    private void findViews() {
        findViewById(R.id.go_age_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(NicknameActivity.this,AgeActivity.class);
        startActivityForResult(intent1,RC_AGEACTIVITY);
        SharedPreferences pref = getSharedPreferences("test", MODE_PRIVATE);
        pref.edit()
                .putString("USER",nickname.getText().toString())
                .commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_AGEACTIVITY) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {

            }
        }
    }
}
