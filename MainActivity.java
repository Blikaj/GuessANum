package com.example.guessanum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText guessnum;
    public long numbre;
    public int level;
    Button sendGuess;
    Button lvlone;
    Button lvltwo;
    Button lvlthree;
    TextView answ;
    TextView guessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessnum = (EditText) findViewById(R.id.guessNumber);
        sendGuess = (Button) findViewById(R.id.buttonSend);
        lvlone = (Button) findViewById(R.id.lvlone);
        lvltwo = (Button) findViewById(R.id.lvltwo);
        lvlthree = (Button) findViewById(R.id.lvlthree);
        answ = (TextView) findViewById(R.id.answertext);
        level = 10;
        guessNumber = (TextView) findViewById(R.id.textView2);
    }

    public void levelone(View v) {
        level = 10;
        answ.setVisibility(View.INVISIBLE);
        String s;
        s = "Угадайте число от 1 до 10";
        guessNumber.setText(s.toCharArray(), 0, s.length());
    }

    public void leveltwo(View v) {
        level = 50;
        answ.setVisibility(View.INVISIBLE);
        String s;
        s = "Угадайте число от 1 до 50";
        guessNumber.setText(s.toCharArray(), 0, s.length());
    }

    public void levelthree(View v) {
        level = 100;
        answ.setVisibility(View.INVISIBLE);
        String s;
        s = "Угадайте число от 1 до 100";
        guessNumber.setText(s.toCharArray(), 0, s.length());
    }

    public void sendaguess(View v){
        int min = 1;
        String s = "empty";
        int randomNum = ThreadLocalRandom.current().nextInt(min, level + 1);
        int p1 = Integer.parseInt(guessnum.getText().toString());
        if (p1 == randomNum) {
            s = "Верно! Загаданное число было " + randomNum;
        }
        else{
            s = "Неверно! Загаданное число было " + randomNum;
        }
        answ.setText(s.toCharArray(), 0, s.length());
        answ.setVisibility(View.VISIBLE);
    }
}