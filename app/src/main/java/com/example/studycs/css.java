package com.example.studycs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class css extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css);

        CardView js1=(CardView)findViewById(R.id.js1);
        CardView js2=(CardView)findViewById(R.id.js2);

        js1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(css.this,cssnotes.class);
                startActivity(intent);
            }
        });
        js2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(css.this,cssvideo.class);
                startActivity(intent);
            }
        });
    }
}
