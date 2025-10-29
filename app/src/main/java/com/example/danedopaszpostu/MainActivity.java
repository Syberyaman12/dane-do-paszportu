package com.example.danedopaszpostu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name, lastName, Numer;
    Button submit;
    RadioButton blue, green, hazel;

    ImageView imageFace, imageFinger;

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

        name = findViewById(R.id.editName);
        lastName = findViewById(R.id.editNazwisko);
        Numer = findViewById(R.id.editNumer);
        submit = findViewById(R.id.button);
        blue = findViewById(R.id.niebieskie);
        green = findViewById(R.id.zielone);
        hazel = findViewById(R.id.piwne);
        imageFace = findViewById(R.id.imageView);
        imageFinger = findViewById(R.id.imageView2);


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                String temp = name.getText().toString() + " " + lastName.getText().toString() + " kolor oczu ";

                if(blue.isChecked()){
                    temp += "niebieski";
                }
                if(green.isChecked()){
                    temp += "zielone";
                }
                if(hazel.isChecked()){
                    temp += "piwne";
                }

                String id = Numer.getText().toString();

                if(id.equals("000")){
                    imageFace.setImageResource(R.raw.a000zdjecie);
                    imageFinger.setImageResource(R.raw.a000odcisk);
                }

                if(id.equals("111")){
                    imageFace.setImageResource(R.raw.a111zdjecie);
                    imageFinger.setImageResource(R.raw.a111odcisk);
                }

                if(id.equals("333")){
                    imageFace.setImageResource(R.raw.a333zdjecie);
                    imageFinger.setImageResource(R.raw.a333odcisk);
                }

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("dane")
                        .setMessage(temp)
                        .setPositiveButton("OK", null)
                        .show();

            }
        });

    }
}