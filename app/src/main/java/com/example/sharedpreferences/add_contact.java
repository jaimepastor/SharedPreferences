package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class add_contact extends AppCompatActivity {

    private final int ADDED_RESULT_CODE = 1;
    private final int CANCEL_RESULT_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    public void addToList(View v){
        Intent intent = new Intent(this, MainActivity.class);

        setResult(ADDED_RESULT_CODE, intent);
        finish();
    }

    public void cancel(View v){
        Intent intent = new Intent(this, MainActivity.class);

        setResult(CANCEL_RESULT_CODE, intent);
        finish();
    }
}
