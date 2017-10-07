package edu.greenriver.kevinlocke.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        if(getIntent().hasExtra(GuessingActivity.intentTag)) {
            String msg = getIntent().getStringExtra(GuessingActivity.intentTag);
            TextView totalGuesses = (TextView) findViewById(R.id.numGuessesText);
            String guessText = totalGuesses.getText().toString();
            totalGuesses.setText(msg);
        }

    }

    public void PlayAgain(View view)
    {
        // start the game over
        Intent intent = new Intent(this, LandingActivity.class);
        startActivity(intent);
    }
}
