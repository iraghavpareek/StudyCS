package com.example.studycs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class html extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        CardView js1=(CardView)findViewById(R.id.js1);
        CardView js2=(CardView)findViewById(R.id.js2);

        js1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(html.this,htmlnotes.class);
                startActivity(intent);
            }
        });
        js2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(html.this,htmlvideo.class);
                startActivity(intent);
            }
        });
    }
}
