package com.example.sharedpreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_ADDCONTACT_CODE = 5;
    private final int REQUEST_DELETECONTACT_CODE = 6;
    private final int ADDED_RESULT_CODE = 1;
    private final int CANCEL_RESULT_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View v){
        Intent intent = new Intent(this, add_contact.class);
        startActivityForResult(intent, REQUEST_ADDCONTACT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_ADDCONTACT_CODE){
            if(resultCode == ADDED_RESULT_CODE){

            } else if(resultCode == CANCEL_RESULT_CODE){

            } else {
                Toast.makeText(getApplicationContext(), "WEIRD ERROR", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == REQUEST_DELETECONTACT_CODE){

        }
    }
}
