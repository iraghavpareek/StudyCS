package com.example.studycs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.common.base.Strings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class jsnotes extends AppCompatActivity {
    private TextView textView;
    private PDFView pdfView;
    ProgressBar progressBar;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mref=database.getReference("JS");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsnotes);




                pdfView=findViewById(R.id.jsn1);
                textView=findViewById(R.id.text1);
                progressBar=findViewById(R.id.progressBar);

                progressBar.setVisibility(View.VISIBLE);

                mref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        String value =dataSnapshot.getValue(String.class);
                        textView.setText(value);
                        Toast.makeText(jsnotes.this, "Updated", Toast.LENGTH_SHORT).show();
                        String url =textView.getText().toString();

                        progressBar.setVisibility(View.GONE);
                        new RetrivePdfStream().execute(url);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {


                        Toast.makeText(jsnotes.this, "Failed To Load", Toast.LENGTH_SHORT).show();

                    }
                });}
            class RetrivePdfStream extends AsyncTask<String,Void, InputStream>{

                @Override
                protected InputStream doInBackground(String... strings) {
                    InputStream inputStream=null;
                    try {
                        URL url=new URL (strings[0]);
                        HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                        if (urlConnection.getResponseCode()==200){
                            inputStream=new BufferedInputStream(urlConnection.getInputStream());
                        }
                    }catch (IOException e){
                        return null;
                    }
                    return inputStream;
                }

                @Override
                protected void onPostExecute(InputStream inputStream) {
                    pdfView.fromStream(inputStream).load();
                }
            }

}
