package com.example.rockpaperscisssior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView compSelect ;
    TextView userSelect;
    String pressedButton;
    TextView resultView;
    TextView counter;
    TextView compVic;
    TextView textView;
    TextView textView2;
    Button rockButton;
    Button paperButton;
    Button scissiorButton;
    Button playPauseButton;
    int c = 1;
    String[] opt = {"ROCK", "PAPER" , "SCISSOR"};
    String[] onvic = {"Nice", "Ohhhhooo!!!", "lucky"};
    String[] onloss = {"ooppppss!!", "unlucky:(", "Hehehe!!"};
    Random rand = new Random();
    int points =0;
    int timesPlayed = 0;
    int comppoints = 0;

    //on selecting button
    public void selected(View view) {
        //getting user input
        pressedButton = (String) view.getTag();
        int ip = Integer.parseInt(pressedButton);
        userSelect.setText(opt[Integer.parseInt(pressedButton)]);
        //finding winner
        int comp = rand.nextInt(3);
        compSelect.setText(opt[comp]);
        if (timesPlayed < 10) {
            timesPlayed += 1;
            if (ip == comp) {
                resultView.setText("Tie :|");
            } else if (ip == 0 && comp == 1) {
                resultView.setText(onloss[comp]);
                comppoints += 1;
                compVic.setText("Point:-" + comppoints);
            } else if (ip == 0 && comp == 2) {
                resultView.setText(onvic[comp]);
                points += 1;
            } else if (ip == 1 && comp == 2) {
                resultView.setText(onloss[comp]);
                comppoints += 1;
                compVic.setText("Point:-" + comppoints);
            } else if (ip == 1 && comp == 0) {
                resultView.setText(onvic[comp]);
                points += 1;
            } else if (ip == 2 && comp == 0) {
                resultView.setText(onloss[comp]);
                comppoints += 1;
                compVic.setText("Point:-" + comppoints);
            } else if (ip == 2 && comp == 1) {
                resultView.setText(onvic[comp]);
                points += 1;
            }
            //updating counter
            counter.setText(points + "/" + timesPlayed);

        }else {
            if (comppoints > points) {
                resultView.setText("Computer Wins");
            } else if (comppoints < points) {
                resultView.setText("You Win");
            } else {
                resultView.setText("Game Tie !");
            }
            playPauseButton.setText("Play Again");

            rockButton.setEnabled(false);
            scissiorButton.setEnabled(false);
            paperButton.setEnabled(false);
            c = 1;
        }

    }

    public void playPause(View view){
        playPauseButton = findViewById(R.id.playPauseButton);
        playPauseButton.setText("Stop");

        //making visible and invisible on play or stop action
        if(c==1) {
            rockButton.setVisibility(View.VISIBLE);
            paperButton.setVisibility(View.VISIBLE);
            scissiorButton.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            counter.setVisibility(View.VISIBLE);
            compVic.setVisibility(View.VISIBLE);
            compSelect.setVisibility(View.VISIBLE);
            userSelect.setVisibility(View.VISIBLE);
            resultView.setText("Select One");
            compVic.setText("Point:-0");
            rockButton.setEnabled(true);
            scissiorButton.setEnabled(true);
            paperButton.setEnabled(true);
            points = 0;
            comppoints =0;
            timesPlayed = 0;

            counter.setText("0/0");
            c = 0;
        }else {
            rockButton.setVisibility(View.INVISIBLE);
            paperButton.setVisibility(View.INVISIBLE);
            scissiorButton.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
            counter.setVisibility(View.INVISIBLE);
            compVic.setVisibility(View.INVISIBLE);
            compSelect.setVisibility(View.INVISIBLE);
            userSelect.setVisibility(View.INVISIBLE);
            playPauseButton.setText("Play!!");
            resultView.setText("Let's Play");
            compVic.setText("Point:-0");
            points = 0;
            comppoints =0;
            timesPlayed = 0;
            counter.setText("0/0");
            c=1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finding
        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissiorButton = findViewById(R.id.scissiorButton);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        counter = findViewById(R.id.counter);
        resultView = findViewById(R.id.resultView);
        compVic = findViewById(R.id.compVic);
        userSelect = findViewById(R.id.userSelect);
        compSelect = findViewById(R.id.compSelect);
        //making invisible
        rockButton.setVisibility(View.INVISIBLE);
        paperButton.setVisibility(View.INVISIBLE);
        scissiorButton.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        counter.setVisibility(View.INVISIBLE);
        compVic.setVisibility(View.INVISIBLE);

    }
}