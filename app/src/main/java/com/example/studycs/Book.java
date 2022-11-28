package com.example.studycs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Book extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        CardView book1=(CardView)findViewById(R.id.book1);
        CardView book2=(CardView)findViewById(R.id.book2);
        CardView book3=(CardView)findViewById(R.id.book3);
        CardView book4=(CardView)findViewById(R.id.book4);
        CardView book5=(CardView)findViewById(R.id.book5);
        CardView book6=(CardView)findViewById(R.id.book6);
        CardView book7=(CardView)findViewById(R.id.book7);
        CardView book8=(CardView)findViewById(R.id.book8);
        CardView book9=(CardView)findViewById(R.id.book9);
        CardView book10=(CardView)findViewById(R.id.book10);

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,denotes.class);
                startActivity(intent);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,oopnotes.class);
                startActivity(intent);
            }
        });
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,dsnotes.class);
                startActivity(intent);
            }
        });
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,senotes.class);
                startActivity(intent);
            }
        });
        book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,osnotes.class);
                startActivity(intent);
            }
        });
        book6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,cnnotes.class);
                startActivity(intent);
            }
        });
        book7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,androidnotes.class);
                startActivity(intent);
            }
        });
        book8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,micronotes.class);
                startActivity(intent);
            }
        });
        book9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,nsnotes.class);
                startActivity(intent);
            }
        });
        book10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Book.this,cgnotes.class);
                startActivity(intent);
            }
        });

    }
}
