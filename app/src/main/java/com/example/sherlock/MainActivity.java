package com.example.sherlock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final private int CHOOSE_THIEF = 0;
    public static final String ACTION_SECEND_ACTIVITY = "com.example.sherlock.SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //Intent questionIntent = new Intent(MainActivity.this, SecondActivity.class);
        //startActivityForResult(questionIntent, CHOOSE_THIEF);
        startActivity(new Intent(ACTION_SECEND_ACTIVITY));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView infoTextView = findViewById(R.id.textViewInfo);

        if (requestCode == CHOOSE_THIEF){
            if (resultCode == RESULT_OK) {
                String thiefname = data.getStringExtra(SecondActivity.THIEF);
                infoTextView.setText(thiefname);
            }
            else{
                infoTextView.setText("");
            }
        }
    }
}
