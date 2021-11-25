package com.example.guessanum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView tv;
    CheckBox chb;


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
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
    }

    public void changedif(int lvl){
        String s;
        switch (lvl){
            case (10):
                level = 10;
                answ.setVisibility(View.INVISIBLE);
                s = "Угадайте число от 1 до 10";
                guessNumber.setText(s.toCharArray(), 0, s.length());
                break;
            case (50):
                level = 50;
                answ.setVisibility(View.INVISIBLE);
                s = "Угадайте число от 1 до 50";
                guessNumber.setText(s.toCharArray(), 0, s.length());
                break;
            case(100):
                level = 100;
                answ.setVisibility(View.INVISIBLE);
                s = "Угадайте число от 1 до 100";
                guessNumber.setText(s.toCharArray(), 0, s.length());
                break;
        }

    }

    public void levelone(View v) {
        changedif(10);
    }

    public void leveltwo(View v) {
        changedif(50);
    }

    public void levelthree(View v) {
        changedif(100);
    }

    public void sendaguess(View v){
        int min = 1;
        String s = "empty";
        int randomNum = ThreadLocalRandom.current().nextInt(min, level + 1);
        int p1 = 0;
        if (guessnum.getText().toString().length() == 0 ) {
            p1 = 0;
        }
        else {
            p1 = Integer.parseInt(guessnum.getText().toString());
        }
        if (p1 == randomNum) {
            s = "Верно! Загаданное число было " + randomNum;
        }
        else{
            s = "Неверно! Загаданное число было " + randomNum;
        }
        answ.setText(s.toCharArray(), 0, s.length());
        answ.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        tv.setText(sb.toString());
        int idd = item.getItemId();

        switch (idd) {
            case (R.id.menu_levelone):
                changedif(10);
                return super.onOptionsItemSelected(item);
            case (R.id.menu_leveltwo):
                changedif(50);
                return super.onOptionsItemSelected(item);
            case (R.id.menu_levelthree):
                changedif(100);
                return super.onOptionsItemSelected(item);
            case(R.id.menu_exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
