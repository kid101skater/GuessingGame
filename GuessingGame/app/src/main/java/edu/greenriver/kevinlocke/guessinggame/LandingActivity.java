package edu.greenriver.kevinlocke.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void StartGame(View view)
    {
        // start the new game activity
        Intent intent = new Intent(this, GuessingActivity.class);
        startActivity(intent);
    }
}
