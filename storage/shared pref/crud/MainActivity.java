package com.example.practice;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private SharedPreferences sharedPreferences;
    private TextView nameTextView;
    private TextView emailTextView;
    private EditText nameEditText;
    private EditText emailEditText;

    public static final String MY_PREFERENCE = "mypref";
    public static final String NAME_KEY = "nameKey";
    public static final String EMAIL_KEY = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.etName);
        emailTextView = findViewById(R.id.etEmail);
        nameEditText = findViewById(R.id.etName);
        emailEditText = findViewById(R.id.etEmail);

        sharedPreferences = getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
        loadData();
    }

    private void loadData() {
        if (sharedPreferences.contains(NAME_KEY)) {
            nameTextView.setText(sharedPreferences.getString(NAME_KEY, ""));
        }
        if (sharedPreferences.contains(EMAIL_KEY)) {
            emailTextView.setText(sharedPreferences.getString(EMAIL_KEY, ""));
        }
    }

    public void save(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.putString(EMAIL_KEY, email);
        editor.apply();
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        nameEditText.setText("");
        emailEditText.setText("");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(NAME_KEY);
        editor.remove(EMAIL_KEY);
        editor.apply();
        Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
    }

    public void get(View view) {
        loadData();
    }

    public void update(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.putString(EMAIL_KEY, email);
        editor.apply();
        Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}