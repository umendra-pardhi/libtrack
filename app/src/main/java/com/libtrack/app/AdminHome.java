package com.libtrack.app;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminHome extends AppCompatActivity implements View.OnClickListener {


    private CardView searchBook,addBook,removeBook,updateBook,issueBook,returnBook,logOut,collect1,reissueButton, issueNDC;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        FirebaseApp.initializeApp(this);
        firebaseAuth=FirebaseAuth.getInstance();
        searchBook=(CardView)findViewById(R.id.searchBook);
        addBook=(CardView)findViewById(R.id.addBook);
        removeBook=(CardView)findViewById(R.id.removeBook);
        collect1=(CardView)findViewById(R.id.collect1);
        updateBook=(CardView)findViewById(R.id.updateBook);
        issueBook=(CardView)findViewById(R.id.issueBook);
        returnBook=(CardView)findViewById(R.id.returnBook);
        logOut=(CardView)findViewById(R.id.logOut);
        reissueButton=(CardView)findViewById(R.id.reissueBook);
        issueNDC=(CardView) findViewById(R.id.issueNDC);
        db=FirebaseFirestore.getInstance();

        searchBook.setOnClickListener(this);
        addBook.setOnClickListener(this);
        removeBook.setOnClickListener(this);
        updateBook.setOnClickListener(this);
        issueBook.setOnClickListener(this);
        returnBook.setOnClickListener(this);
        logOut.setOnClickListener(this);
        collect1.setOnClickListener(this);
        reissueButton.setOnClickListener(this);
        issueNDC.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v==logOut)
        {
            db.document("User/"+firebaseAuth.getCurrentUser().getEmail()).update("fcmToken",null).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        firebaseAuth.signOut();
                        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(AdminHome.this, "Try Again !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        if(v==searchBook)
        {
            startActivity(new Intent(getApplicationContext(),SearchBookSet.class));
        }
        if(v==addBook)
        {
            startActivity(new Intent(getApplicationContext(),AdminAddBook.class));
        }
        if(v==removeBook)
        {
            startActivity(new Intent(getApplicationContext(),AdminRemoveBook.class));
        }
        if(v==issueBook)
        {
            startActivity(new Intent(getApplicationContext(),AdminIssueBook.class));
        }
        if(v==returnBook)
        {
            startActivity(new Intent(getApplicationContext(),AdminReturnBook.class));
        }

        if(v==updateBook)
        {
            startActivity(new Intent(getApplicationContext(),AdminUpdateBook.class));
        }
        if(v==collect1)
        {
            startActivity(new Intent(getApplicationContext(),AdminCollectFine.class));
        }
        if(v==reissueButton)
        {
            startActivity(new Intent(getApplicationContext(),AdminReissueBook.class));
        }

        if(v==issueNDC)
        {
            startActivity(new Intent(getApplicationContext(),AdminIssueNDC.class));
        }


    }

}
