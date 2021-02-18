package com.practise.dice_roll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Random rng=new Random();
    private ImageView dice;
    private Button spin,clear;
    int k=0;
    TextView p1score,p2score,showturn;
    private int score1=0,score2=0,a,b,c,i=0,choice;
    private boolean player1_choice=true,win=false;
   public static Integer[] mThumbIds = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice=findViewById(R.id.img);
        spin=findViewById(R.id.spin);
        spin.setTag(0);
        clear=findViewById(R.id.clear);
        clear.setTag(1);
        p1score=findViewById(R.id.playerOneScore);
        p2score=findViewById(R.id.playerTwoScore);
        showturn=findViewById(R.id.turn);
        spin.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if((int)v.getTag()==0){
            if(!win) {
                DiceRoll();
            }
            else{
                Toast.makeText(getApplicationContext(), "Clear to start new game", Toast.LENGTH_SHORT).show();
            }
        }
        else if((int)v.getTag()==1){
            dice.setImageResource(R.drawable.dice1);
            p1score.setText("0");
            p2score.setText("0");
            player1_choice=true;
            win=false;
            showturn.setText("Turn: Player1");
        }
    }


    private void DiceRoll() {
        choice = rng.nextInt(6) + 1;
        i = 0;
        k = 0;
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            Random rng1=new Random();
            public void run() {

                i=rng1.nextInt(6);
                dice.setImageResource(mThumbIds[i]);
                k++;
                if (k < 10)
                    handler.postDelayed(this, 150);//for interval...
                if (k == 10) {
                    switchCase();
                }
            }
        };
        if (k < 10)
            handler.postDelayed(runnable, 50);
    }
    public void switchCase(){
        switch (choice) {
            case 1:
                dice.setImageResource(R.drawable.dice1);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 1;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 1;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;

            case 2:
                dice.setImageResource(R.drawable.dice2);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 2;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 2;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;

            case 3:
                dice.setImageResource(R.drawable.dice3);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 3;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 3;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;

            case 4:
                dice.setImageResource(R.drawable.dice4);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 4;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 4;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;

            case 5:
                dice.setImageResource(R.drawable.dice5);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 5;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 5;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;

            case 6:
                dice.setImageResource(R.drawable.dice6);
                if (player1_choice) {
                    a = Integer.parseInt(p1score.getText().toString());
                    a = a + 6;
                    p1score.setText(String.valueOf(a));
                } else {
                    a = Integer.parseInt(p2score.getText().toString());
                    a = a + 6;
                    p2score.setText(String.valueOf(a));
                }
                if (a > 24)
                    win = true;
                break;
        }
        if (win) {
            if (player1_choice)
                Toast.makeText(getApplicationContext(), "Game over!! Player1 wins", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Game over!! Player2 wins", Toast.LENGTH_SHORT).show();

        }
        else {
            player1_choice = !player1_choice;
            if(player1_choice)
                showturn.setText("Turn: Player1");
            else
                showturn.setText("Turn: Player2");
        }
    }

}
