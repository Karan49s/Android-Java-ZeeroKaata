package com.example.zeero_kaata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Singleplayer extends AppCompatActivity {
    private Button buttons[]=new Button[9];
    private Button restart;
    private int turncnt=0;
    String Messagelog="";
    TextView tv;
    char board[] = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ' };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        buttons[0]=findViewById(R.id.button1);
        buttons[1]=findViewById(R.id.button2);
        buttons[2]=findViewById(R.id.button3);
        buttons[3]=findViewById(R.id.button4);
        buttons[4]=findViewById(R.id.button5);
        buttons[5]=findViewById(R.id.button6);
        buttons[6]=findViewById(R.id.button7);
        buttons[7]=findViewById(R.id.button8);
        buttons[8]=findViewById(R.id.button9);
        restart=findViewById(R.id.button10);
        tv=findViewById(R.id.textView);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
                buttons[0].setText("");
                buttons[1].setText("");
                buttons[2].setText("");
                buttons[3].setText("");
                buttons[4].setText("");
                buttons[5].setText("");
                buttons[6].setText("");
                buttons[7].setText("");
                buttons[8].setText("");
                turncnt=0;
                board[0] =' '; board[1] =' '; board[2] =' '; board[3] =' '; board[4] =' ';
                board[5] =' '; board[6] =' '; board[7] =' '; board[8] =' '; board[9] =' ';
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(true);
                buttons[2].setEnabled(true);
                buttons[3].setEnabled(true);
                buttons[4].setEnabled(true);
                buttons[5].setEnabled(true);
                buttons[6].setEnabled(true);
                buttons[7].setEnabled(true);
                buttons[8].setEnabled(true);
            }
        });
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(0);
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(1);
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(2);
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(3);
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(4);
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(5);
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(6);
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(7);
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(8);
            }
        });
    }

    private void play(int i) {
       if(board[i+1]==' ')
        {
            buttons[i].setText("X");
            buttons[i].setEnabled(false);
            board[i+1]='X';
            turncnt++;
            Messagelog="You took position " + i +"\n\n\n";
            tv.setText(""+Messagelog+tv.getText());

            if(isWinner(board)==1)
            {
                Messagelog="You WON\n\n\n";
                tv.setText(""+Messagelog+tv.getText());
                playerwon();
            }
            else if(turncnt==9)
            {
                Messagelog="DRAW\n\n\n";
                tv.setText(""+Messagelog+tv.getText());
                draw();
            }
            else if(turncnt<9)
            {
                cpumove();
                turncnt++;
                if(isWinner(board)==2)
                {
                    Messagelog="You LOSE\n\n\n";
                    tv.setText(""+Messagelog+tv.getText());
                    youlost();
                }
            }
        }
    }

    private void playerwon() {
        buttons[0].setEnabled(false);
        buttons[1].setEnabled(false);
        buttons[2].setEnabled(false);
        buttons[3].setEnabled(false);
        buttons[4].setEnabled(false);
        buttons[5].setEnabled(false);
        buttons[6].setEnabled(false);
        buttons[7].setEnabled(false);
        buttons[8].setEnabled(false);

    }

    private void youlost() {
        buttons[0].setEnabled(false);
        buttons[1].setEnabled(false);
        buttons[2].setEnabled(false);
        buttons[3].setEnabled(false);
        buttons[4].setEnabled(false);
        buttons[5].setEnabled(false);
        buttons[6].setEnabled(false);
        buttons[7].setEnabled(false);
        buttons[8].setEnabled(false);

    }

    private void draw() {
        buttons[0].setEnabled(false);
        buttons[1].setEnabled(false);
        buttons[2].setEnabled(false);
        buttons[3].setEnabled(false);
        buttons[4].setEnabled(false);
        buttons[5].setEnabled(false);
        buttons[6].setEnabled(false);
        buttons[7].setEnabled(false);
        buttons[8].setEnabled(false);
    }

    private void cpumove() {
        char tempboard[]=new char[10];
        for (int i = 0;i <= 8;i++)
        {
            tempboard=board.clone();
            if (tempboard[i+1] ==' ')
            {
                tempboard[i+1]='O';
                if (isWinner(tempboard) == 2)
                {
                    board[i+1] = 'O';
                    buttons[i].setText("O");
                    buttons[i].setEnabled(false);
                    Messagelog="cpu took place " + i +"\n\n\n";
                    tv.setText(""+Messagelog+tv.getText());
                    return;
                }

            }
        }
        for (int i = 0;i <= 8;i++)
        {
            tempboard=board.clone();
            if (tempboard[i+1] == ' ')
            {
                tempboard[i+1]='X';
                if (isWinner(tempboard) == 1)
                {
                    board[i+1] = 'O';
                    buttons[i].setText("O");
                    buttons[i].setEnabled(false);
                    Messagelog="cpu took place " + i +"\n\n\n";
                    tv.setText(""+Messagelog+tv.getText());
                    return;
                }

            }
        }

        while(true)
        {
            Random rand = new Random();
            int i=rand.nextInt(9);
            if (board[i+1] == ' ')
            {

                board[i+1] = 'O';
                buttons[i].setText("O");
                buttons[i].setEnabled(false);
                Messagelog="cpu took place " + i +"\n\n\n";
                tv.setText(""+Messagelog+tv.getText());
                return;
            }
        }


    }




    private int isWinner(char board[]) {
        if (board[1] == 'X' && board[2] == 'X' && board[3] == 'X' ||
                board[4] == 'X' && board[5] == 'X' && board[6] == 'X' ||
                board[7] == 'X' && board[8] == 'X' && board[9] == 'X' ||
                board[1] == 'X' && board[4] == 'X' && board[7] == 'X' ||
                board[2] == 'X' && board[5] == 'X' && board[8] == 'X' ||
                board[3] == 'X' && board[6] == 'X' && board[9] == 'X' ||
                board[1] == 'X' && board[5] == 'X' && board[9] == 'X' ||
                board[3] == 'X' && board[5] == 'X' && board[7] == 'X')
            return 1;
        else if (board[1] == 'O' && board[2] == 'O' && board[3] == 'O' ||
                board[4] == 'O' && board[5] == 'O' && board[6] == 'O' ||
                board[7] == 'O' && board[8] == 'O' && board[9] == 'O' ||
                board[1] == 'O' && board[4] == 'O' && board[7] == 'O' ||
                board[2] == 'O' && board[5] == 'O' && board[8] == 'O' ||
                board[3] == 'O' && board[6] == 'O' && board[9] == 'O' ||
                board[1] == 'O' && board[5] == 'O' && board[9] == 'O' ||
                board[3] == 'O' && board[5] == 'O' && board[7] == 'O')
            return 2;
        else
            return 0;
    }
}
