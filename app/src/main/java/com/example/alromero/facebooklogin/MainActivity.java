package com.example.alromero.facebooklogin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;


public class MainActivity extends AppCompatActivity {

    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.textView);
        Bundle bolsaR = getIntent().getExtras();
        email.setText(bolsaR.getString("email"));


        if(AccessToken.getCurrentAccessToken()==null){

            goLoginScreen();

        }

    }

    private void goLoginScreen() {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void logout(View view) {

        LoginManager.getInstance().logOut();
        goLoginScreen();

    }
}
