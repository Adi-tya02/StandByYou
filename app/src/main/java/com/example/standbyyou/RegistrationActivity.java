package com.example.standbyyou;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.standbyyou.HomeFragment;
import com.example.standbyyou.LoginActivity;
import com.example.standbyyou.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private EditText anonymousNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView clickToLogin;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), HomeFragment.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        anonymousNameEditText = findViewById(R.id.anonymousNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        registerButton = findViewById(R.id.registerButton);
        clickToLogin = findViewById(R.id.clickToLogin);

        clickToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbar);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                String anonymousName = anonymousNameEditText.getText().toString().trim();
                String email = String.valueOf(emailEditText.getText()).trim();
                String password = String.valueOf(passwordEditText.getText()).trim();

                // Check if email is in correct format
                if (!isValidEmail(email)) {
                    Toast.makeText(RegistrationActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                // Check if password meets the criteria
                if (!isValidPassword(password)) {
                    Toast.makeText(RegistrationActivity.this, "Password must contain at least one uppercase letter, one lowercase letter, one digit, and be at least 6 characters long", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                // Register user with email and password
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(RegistrationActivity.this, "Account Created.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.e(TAG, "Authentication failed: " + task.getException().getMessage());

                                    Toast.makeText(RegistrationActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}";
        return password.matches(passwordPattern);
    }
}
