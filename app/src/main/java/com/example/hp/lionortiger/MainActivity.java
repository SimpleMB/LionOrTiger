package com.example.hp.lionortiger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum Player {
        one, two
    }

    Player currentPlayer = Player.one;
    Player playerChoice[] = new Player[9];
    TextView playerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNumber = findViewById(R.id.playerNumber);
        playerNumber.setText("Player ONE");


    }



    public void buttonIsTapped (View imageView) {

        ImageView imageTaped = (ImageView) imageView;
        int imgViewTag = Integer.parseInt(imageTaped.getTag().toString());
        playerChoice [imgViewTag] = currentPlayer;

        imageTaped.setTranslationX(-2000);
        imageTaped.setRotation(0);

        if (currentPlayer == Player.one) {

            imageTaped.setImageResource(R.drawable.tiger);
            currentPlayer = Player.two;
            playerNumber.setText("Player TWO");


        } else {

            imageTaped.setImageResource(R.drawable.lion);  // Setting image to be placed in selected ImageView
            currentPlayer = Player.one;                     // Changing player
            playerNumber.setText("Player ONE");


        }

        imageTaped.animate().translationXBy(2000).setDuration(300).alpha(1).rotation(3600);

        checkWinner();
    }

    public void checkWinner () {

        if (playerChoice[0] != null && playerChoice[3] != null && playerChoice[6] != null && playerChoice[0] == playerChoice[3] && playerChoice[3] == playerChoice[6]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[1] != null && playerChoice[4] != null && playerChoice[7] != null && playerChoice[1] == playerChoice[4] && playerChoice[4] == playerChoice[7]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[2] != null && playerChoice[5] != null && playerChoice[8] != null && playerChoice[2] == playerChoice[5] && playerChoice[5] == playerChoice[8]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[0] != null && playerChoice[1] != null && playerChoice[2] != null && playerChoice[0] == playerChoice[1] && playerChoice[1] == playerChoice[2]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[3] != null && playerChoice[4] != null && playerChoice[5] != null && playerChoice[3] == playerChoice[4] && playerChoice[4] == playerChoice[5]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[6] != null && playerChoice[7] != null && playerChoice[8] != null && playerChoice[6] == playerChoice[7] && playerChoice[7] == playerChoice[8]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[0] != null && playerChoice[4] != null && playerChoice[8] != null && playerChoice[0] == playerChoice[4] && playerChoice[4] == playerChoice[8]) {

                playerNumber.setText(currentPlayer + " wygrał!");

            } else if (playerChoice[2] != null && playerChoice[4] != null && playerChoice[6] != null && playerChoice[2] == playerChoice[4] && playerChoice[4] == playerChoice[6]) {

                playerNumber.setText(currentPlayer + " wygrał!");
            }
        }
    }
