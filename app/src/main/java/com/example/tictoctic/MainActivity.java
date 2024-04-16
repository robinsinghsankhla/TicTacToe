package com.example.tictoctic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton button_1, button_2, button_3, button_4, button_5,
                    button_reStart,button_6, button_7, button_8, button_9;
    TextView XScore,OScore,Round;
    int Xscore=0,Oscore=0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int count = 0;
    int round = 0;
    int flag = 0;//it use to click X and O alternative

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setId();
        //for reStart the match
        button_reStart.setOnClickListener(view -> reStart());

    }

    public void onClickButton(View v) {
        AppCompatButton currentButton = (AppCompatButton) v;
        if (currentButton.getText() == "") {
            if (flag == 0) {
                currentButton.setText("X");
                count++;
                flag = 1;
            } else if (flag == 1) {
                currentButton.setText("O");
                count++;
                flag = 0;
            }
            if (count > 4) {
                getButtonValue();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {//first condition row 1 equal
                    Toast.makeText(this, "Winner is "+b1, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {// second condition row 2 equal
                    Toast.makeText(this, "Winner is "+b4, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {//third condiition row 3 equal
                    Toast.makeText(this, "Winner is "+b7, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {//fourth condition coloum 1 eqaul
                    Toast.makeText(this, "Winner is "+b1, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {// fifth condition coloum 2 equal
                    Toast.makeText(this, "Winner is "+b2, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {// sixth condition coloum 3 equal
                    Toast.makeText(this, "Winner is "+b3, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {// seventh condition diagonal 1 equal
                    Toast.makeText(this, "Winner is "+b1, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {// eighth condition diagonal 2 equal
                    Toast.makeText(this, "Winner is "+b3, Toast.LENGTH_SHORT).show();
                    score();
                    newGame();
                }
                else if(count==9) {//when there is no match at the end
                    Toast.makeText(this, "Match has been Drawn", Toast.LENGTH_SHORT).show();
                    newGame();
                }
            }
        }

    }
        private void newGame(){//for the next game where fisrt move will be of winner
            if(flag==0) flag=1;
            else flag=0;
            count = 0;
            round++;
            Round.setText(Integer.toString(round));
            button_1.setText("");
            button_2.setText("");
            button_3.setText("");
            button_4.setText("");
            button_5.setText("");
            button_6.setText("");
            button_7.setText("");
            button_8.setText("");
            button_9.setText("");
        }
        private void reStart(){//for restart the match form starting
        flag = 0;
        count = 0;
        Xscore = 0;
        Oscore = 0;
        round = 0;
        Round.setText("0");
        XScore.setText("0");
        OScore.setText("0");
        button_1.setText("");
        button_2.setText("");
        button_3.setText("");
        button_4.setText("");
        button_5.setText("");
        button_6.setText("");
        button_7.setText("");
        button_8.setText("");
        button_9.setText("");
            Toast.makeText(this, "Match has benn ReStarted", Toast.LENGTH_SHORT).show();
        }
        private void getButtonValue () {
            b1 = button_1.getText().toString();
            b2 = button_2.getText().toString();
            b3 = button_3.getText().toString();
            b4 = button_4.getText().toString();
            b5 = button_5.getText().toString();
            b6 = button_6.getText().toString();
            b7 = button_7.getText().toString();
            b8 = button_8.getText().toString();
            b9 = button_9.getText().toString();
        }
        private void setId () {
            button_1 = findViewById(R.id.button_1);
            button_2 = findViewById(R.id.button_2);
            button_3 = findViewById(R.id.button_3);
            button_4 = findViewById(R.id.button_4);
            button_5 = findViewById(R.id.button_5);
            button_6 = findViewById(R.id.button_6);
            button_7 = findViewById(R.id.button_7);
            button_8 = findViewById(R.id.button_8);
            button_9 = findViewById(R.id.button_9);
            button_reStart = findViewById(R.id.button_restart);
            XScore = findViewById(R.id.txt_Xscore);
            OScore = findViewById(R.id.txt_Oscore);
            Round = findViewById(R.id.txt_round);
        }
        private void score(){
            if(flag==0) Oscore++;
            else Xscore++;
            XScore.setText(Integer.toString(Xscore));
            OScore.setText(Integer.toString(Oscore));
        }
    }

