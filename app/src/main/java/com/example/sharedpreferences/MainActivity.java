package com.example.sharedpreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_ADDCONTACT_CODE = 5;
    private final int REQUEST_DELETECONTACT_CODE = 6;
    private final int ADDED_RESULT_CODE = 1;
    private final int CANCEL_RESULT_CODE = 2;
    private LinearLayout innerLayout;
    private List<String> listOfContacts;
    private String concatenatedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innerLayout = findViewById(R.id.innerLayout);
        listOfContacts = new ArrayList<>();
        concatenatedString = "";

        loadData();
    }

    public void addContact(View v){
        Intent intent = new Intent(this, add_contact.class);
        startActivityForResult(intent, REQUEST_ADDCONTACT_CODE);
    }

    private void addContactToList(String name, String number){
        String contact = name + " - " + number;
        TextView tv_concat = new TextView(this);
        tv_concat.setText(contact);

        innerLayout.addView(tv_concat);

        listOfContacts.add(contact);
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (String x: listOfContacts){
            concatenatedString = concatenatedString.concat(x);
            concatenatedString = concatenatedString.concat("!");
        }

        System.out.println("HELLO \n\n\n");
        System.out.println(concatenatedString);
        editor.putString("CONTACTS", concatenatedString);
        editor.commit();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("SHARED_PREFS", MODE_PRIVATE);

        concatenatedString = sharedPreferences.getString("CONTACTS", "");
        listOfContacts = new ArrayList<>(Arrays.asList(concatenatedString.split("!")));
        TextView tv_concat;
        for (String x: listOfContacts){
            tv_concat = new TextView(this);
            tv_concat.setText(x);
            innerLayout.addView(tv_concat);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_ADDCONTACT_CODE){
            if(resultCode == ADDED_RESULT_CODE){
                Toast.makeText(getApplicationContext(), "SUCCESSFULLY ADDED: " + data.getStringExtra("CONTACT_NAME"), Toast.LENGTH_LONG).show();

                addContactToList(data.getStringExtra("CONTACT_NAME"), data.getStringExtra("CONTACT_NUMBER"));
            } else if(resultCode == CANCEL_RESULT_CODE){
                Toast.makeText(getApplicationContext(), "CANCELLED", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "WEIRD ERROR", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == REQUEST_DELETECONTACT_CODE){

        }
    }
}
