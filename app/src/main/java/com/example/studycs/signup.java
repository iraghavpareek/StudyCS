package com.example.studycs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Logging;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

import io.opencensus.tags.Tag;

public class signup extends AppCompatActivity {
    EditText remailId,rpassword,rname,rphone,rcpassword;
    Button rbutton;
    TextView rtextView,googlesignin,facebooksignin;
    FirebaseAuth mFirebaseAuth;
    ProgressBar progressBar;
    FirebaseAuth.AuthStateListener mAuthStateListner;
    FirebaseFirestore mfirestore;
    String userID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth=FirebaseAuth.getInstance();
        mfirestore=FirebaseFirestore.getInstance();
        remailId=findViewById(R.id.editText3);
        rpassword=findViewById(R.id.editText2);
        rcpassword=findViewById(R.id.editText5);
        rname=findViewById(R.id.editText);
        rphone=findViewById(R.id.editText4);
        rtextView=findViewById(R.id.tvsignup);
        rbutton=findViewById(R.id.btnsignup);
        progressBar=findViewById(R.id.pb1);

        googlesignin=findViewById(R.id.gsignin);
        facebooksignin=findViewById(R.id.fsignin);



        googlesignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this, "Service is Currently Unavailable,Try Again Later ", Toast.LENGTH_SHORT).show();
            }
        });

        facebooksignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this, "Service is Currently Unavailable,Try Again Later", Toast.LENGTH_SHORT).show();
            }
        });



        if (mFirebaseAuth.getCurrentUser()  != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

      rbutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final String emailID =remailId.getText().toString().trim();
              String password=rpassword.getText().toString().trim();
              String cpassword=rcpassword.getText().toString().trim();

              final String name = rname.getText().toString();
              final String phone = rphone.getText().toString();
              if (TextUtils.isEmpty(emailID)){
                  remailId.setError("Email is required.");
                  return;
              }

              if (TextUtils.isEmpty(password)){
                  rpassword.setError("Password is required.");
                  return;
              }
              if (password.length()<6){
                  rpassword.setError("Password must be Greater than 6 Character");
                  return;
              }
              if (!password.equals(cpassword)){
                  rcpassword.setError("Please Enter Same Password");
                  return;
              }
              if (TextUtils.isEmpty(name)){
                  rname.setError("Required");
                  return;
              }
              if (TextUtils.isEmpty(phone)){
                  rphone.setError("Required");
                  return;
              }

              progressBar.setVisibility(View.VISIBLE);

              mFirebaseAuth.createUserWithEmailAndPassword(emailID,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){


                          FirebaseUser fuser =mFirebaseAuth.getCurrentUser();
                          fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                              @Override
                              public void onSuccess(Void aVoid) {
                                  Toast.makeText(signup.this, "Verification Email has been Sent", Toast.LENGTH_SHORT).show();
                              }
                          }).addOnFailureListener(new OnFailureListener() {
                              @Override
                              public void onFailure(@NonNull Exception e) {
                                  Log.d("TAG","onFailure: Email not sent" + e.getMessage());

                              }
                          });
                          Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                          userID =mFirebaseAuth.getCurrentUser().getUid();
                          DocumentReference documentReference=mfirestore.collection("users").document(userID);
                          Map<String,Object> user =new HashMap<>();
                          user.put("rname", name);
                          user.put("email",emailID);
                          user.put("phone",phone);
                          documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                              @Override
                              public void onSuccess(Void aVoid) {
                                  Log.d("TAG","onSuccess: user Profile is created for"+ userID);
                              }
                          }).addOnFailureListener(new OnFailureListener() {
                              @Override
                              public void onFailure(@NonNull Exception e) {
                                  Log.d("TAG","onFailure:" + e.toString());
                              }
                          });
                          startActivity(new Intent(getApplicationContext(),signin.class));
                      }
                      else{
                          Toast.makeText(signup.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                          progressBar.setVisibility(View.GONE);

                      }
                  }
              });


          }
      });

    }

    public void Login1(View view) {
        rtextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signup.this,signin.class);
                startActivity(intent);
            }
        });
    }
}
