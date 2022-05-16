package com.cookandroid.p1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail;
    Button login, signUp, reg_register;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    private View bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.btm_nav_menu);
        bottomNavigationView.setOnClickListener((View.OnClickListener) new TabSelectedListener());

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        txtInLayoutUsername = findViewById(R.id.txtInLayoutUsername);
        txtInLayoutPassword = findViewById(R.id.txtInLayoutPassword);
        rememberMe = findViewById(R.id.rememberMe);


        ClickLogin();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSignUp();
            }
        });


    }

    private void ClickLogin() {
    }

    private void ClickSignUp() {
    }

    class TabSelectedListener implements NavigationBarView.OnItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new home_fragment()).commit();
                    break;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new search_fragment()).commit();
                    break;
                case R.id.plus:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new plus_fragment()).commit();
                    break;
                case R.id.chat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new chat_fragment()).commit();
                    break;
                case R.id.mypage:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, new user_fragment()).commit();
                    break;
            }
            return true;
        }

    //This is method for doing operation of check login
    private void ClickLogin() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                } else {
                    //Here you can write the codes for checking username
                }
                if (password.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutPassword.setError("Password should not be empty");
                } else {
                    //Here you can write the codes for checking password
                }

                if (rememberMe.isChecked()) {
                    //Here you can write the codes if box is checked
                } else {
                    //Here you can write the codes if box is not checked
                }

            }

        });

    }

    //The method for opening the registration page and another processes or checks for registering
    private void ClickSignUp() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_main,null);
        dialog.setView(dialogView);

        reg_username = dialogView.findViewById(R.id.reg_username);
        reg_password = dialogView.findViewById(R.id.reg_password);
        reg_firstName = dialogView.findViewById(R.id.reg_firstName);
        reg_lastName = dialogView.findViewById(R.id.reg_lastName);
        reg_email = dialogView.findViewById(R.id.reg_email);
        reg_confirmemail = dialogView.findViewById(R.id.reg_confirmemail);
        reg_register = dialogView.findViewById(R.id.reg_register);
        txtInLayoutRegPassword = dialogView.findViewById(R.id.txtInLayoutRegPassword);

        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reg_username.getText().toString().trim().isEmpty()) {

                    reg_username.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                }
                if (reg_password.getText().toString().trim().isEmpty()) {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                    reg_password.setError("Please fill out this field");
                } else {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                    //Here you can write the codes for checking password
                }
                if (reg_firstName.getText().toString().trim().isEmpty()) {

                    reg_firstName.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking firstname

                }
                if (reg_lastName.getText().toString().trim().isEmpty()) {

                    reg_lastName.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking lastname
                }
                if (reg_email.getText().toString().trim().isEmpty()) {

                    reg_email.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking email
                }
                if (reg_confirmemail.getText().toString().trim().isEmpty()) {

                    reg_confirmemail.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking confirmemail
                }
            }
        });


        dialog.show();


    }

    BottomNavigationView bottomNavigationView;

    }
}
