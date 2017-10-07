package edu.greenriver.kevinlocke.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.random;

public class GuessingActivity extends AppCompatActivity {

    int guessNumber = 0;
    int numberOfGuesses;
    public static String intentTag = "inputData";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        guessNumber = getRandomNumber();
        numberOfGuesses = 0;
    }

    public void CheckNumber(View view)
    {
        EditText numberInput = (EditText) findViewById(R.id.numberText);

        if(numberInput.getText().length() == 0)
        {
            Toast.makeText(getApplicationContext(), "Please enter a valid number between 1 and 20", Toast.LENGTH_SHORT).show();
            return;
            // not counting guesses for a null value
        }

        // add guess to count
        numberOfGuesses++;

        int guessedNumber = Integer.parseInt(numberInput.getText().toString());
        if(guessedNumber > 20 || guessedNumber < 1)
        {
            Toast.makeText(getApplicationContext(), "Please provide number between 1 and 20", Toast.LENGTH_SHORT).show();
            return;
        }

        if(guessedNumber < guessNumber)
        {
            Toast.makeText(getApplicationContext(), "Guess is to low.", Toast.LENGTH_SHORT).show();
        }
        else if(guessedNumber > guessNumber)
        {
            Toast.makeText(getApplicationContext(), "Guess is to high.", Toast.LENGTH_SHORT).show();
        }
        else if(guessedNumber == guessNumber)
        {
            // woo you got it correct, would you like a cookie?
            String toastMsg = "You got it correct!";
            if(numberOfGuesses > 20)
            {
                toastMsg = toastMsg + " Only took you more tries than numbers..."; // why not
            }
            Toast.makeText(getApplicationContext(), "You got it correct", Toast.LENGTH_LONG).show();
            LoadActivity();
        }
    }


    // Get a random number.
    public int getRandomNumber()
    {
        int ranNum = (int)(Math.random() * 21);
        if(ranNum == 0)
        {
            ranNum++; // make it 1 cause im lazy
        }

        return ranNum;
    }

    public void LoadActivity()
    {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
        intent.putExtra(intentTag, String.valueOf(numberOfGuesses));
        startActivity(intent);
    }
}
