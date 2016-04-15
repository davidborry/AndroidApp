package com.example.david.polynews2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by david on 14/04/2016.
 */
public class MenuActivity extends AppCompatActivity {

    private ImageButton test;
    private ImageButton campusButton;

    private View.OnClickListener testClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuActivity.this, TestActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener campusClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initializeButtons();


    }

    public void initializeButtons(){
        test = (ImageButton) findViewById(R.id.testApp);
        test.setOnClickListener(testClick);

        campusButton = (ImageButton) findViewById(R.id.campusButton);
        campusButton.setOnClickListener(campusClick);
    }
}
