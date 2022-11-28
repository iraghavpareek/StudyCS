package com.example.studycs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class Languages extends AppCompatActivity {
    private GridLayout gridLayout;
    public CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        CardView cvl1 =(CardView)findViewById(R.id.cvl1);
        CardView cvl2 =(CardView)findViewById(R.id.cvl2);
        CardView cvl3 =(CardView)findViewById(R.id.cvl3);
        CardView cvl4 =(CardView)findViewById(R.id.cvl4);
        CardView cvl5 =(CardView)findViewById(R.id.cvl5);
        CardView cvl6 =(CardView)findViewById(R.id.cvl6);
        CardView cvl7 =(CardView)findViewById(R.id.cvl7);
        CardView cvl8 =(CardView)findViewById(R.id.cvl8);
        CardView cvl9 =(CardView)findViewById(R.id.cvl9);
        CardView cvl10 =(CardView)findViewById(R.id.cvl10);
        CardView cvl11 =(CardView)findViewById(R.id.cvl11);
        CardView cvl12 =(CardView)findViewById(R.id.cvl12);

        cvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,javascript.class);
                startActivity(intent);
            }
        });

        cvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,python.class);
                startActivity(intent);
            }
        });
        cvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,javalanguage.class);
                startActivity(intent);
            }
        });
        cvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,c.class);
                startActivity(intent);
            }
        });
        cvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,php.class);
                startActivity(intent);
            }
        });
        cvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,swift.class);
                startActivity(intent);
            }
        });
        cvl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,cpp.class);
                startActivity(intent);
            }
        });
        cvl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,ruby.class);
                startActivity(intent);
            }
        });
        cvl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,objectivec.class);
                startActivity(intent);
            }
        });
        cvl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,sql.class);
                startActivity(intent);
            }
        });
        cvl11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,html.class);
                startActivity(intent);
            }
        });
        cvl12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Languages.this,css.class);
                startActivity(intent);
            }
        });
    }
}
