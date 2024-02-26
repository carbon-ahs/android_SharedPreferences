package com.axiagroups.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String MESSAGE_ID = "0";
    private EditText enterMsgET;
    private TextView showMsgTV;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMsgET = findViewById(R.id.enterMsgET);
        showMsgTV = findViewById(R.id.showMsgTV);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = enterMsgET.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("msg", msg);
                editor.apply(); // saving
            }
        });

        // get data from SP
        SharedPreferences getSPData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getSPData.getString("msg", "deflt value");
        showMsgTV.setText(value);
        
    }
}