package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutPhone = findViewById(R.id.layoutPhone);
        LinearLayout layoutSocial = findViewById(R.id.layoutSocial);
        LinearLayout layoutEmail = findViewById(R.id.layoutEmail);

        // Handle Phone click
        layoutPhone.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+970599195534"));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Calling +970 599 195 534", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Social / GitHub / Twitter handle click
        layoutSocial.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/AndroidDev"));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Opening @AndroidDev", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Email click
        layoutEmail.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:io.kaware@android.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hello from Android App");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Email: io.kaware@android.com", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
