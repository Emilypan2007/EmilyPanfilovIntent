package com.example.emilypanfilovintent;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button plus,sub,multiplication,division,equal,delete,credits;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        plus=(Button)findViewById(R.id.plus);
        sub=(Button)findViewById(R.id.sub);
        multiplication=(Button)findViewById(R.id.multiplication);
        division=(Button)findViewById(R.id.division);
        equal=(Button)findViewById(R.id.equal);
        delete=(Button)findViewById(R.id.delete);
        credits=(Button)findViewById(R.id.credits);
        display=(EditText) findViewById(R.id.display);
        plus.setBackgroundColor(Color.rgb(255,130,250));
        sub.setBackgroundColor(Color.rgb(255,130,250));
        multiplication.setBackgroundColor(Color.rgb(255,130,250));
        division.setBackgroundColor(Color.rgb(255,130,250));
        delete.setBackgroundColor(Color.rgb(255,130,250));
        equal.setBackgroundColor(Color.rgb(255,130,250));
        credits.setBackgroundColor(Color.rgb(255,130,250));

    }
}