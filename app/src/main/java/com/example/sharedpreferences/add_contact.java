package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class add_contact extends AppCompatActivity {

    private final int ADDED_RESULT_CODE = 1;
    private final int CANCEL_RESULT_CODE = 2;
    private EditText contactName;
    private EditText contactNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        contactName = findViewById(R.id.contactName);
        contactNumber = findViewById(R.id.contactNumber);
    }

    public void addToList(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("CONTACT_NAME", contactName.getText().toString());
        intent.putExtra("CONTACT_NUMBER", contactNumber.getText().toString());

        setResult(ADDED_RESULT_CODE, intent);
        finish();
    }

    public void cancel(View v){
        Intent intent = new Intent(this, MainActivity.class);

        setResult(CANCEL_RESULT_CODE, intent);
        finish();
    }
}
