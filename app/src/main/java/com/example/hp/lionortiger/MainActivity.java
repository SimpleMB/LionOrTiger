package com.example.hp.lionortiger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum Player {
        one, two, none
    }

    private Player currentPlayer = Player.one;
    private Player playerChoice[] = new Player[9];
    int [][] winnerRowsColumns = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private TextView playerNumber;
    private String win;
    private boolean isItWon;
    private Player acctualPlayer;
    private GridLayout gridLayout;
    Button gameReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNumber = findViewById(R.id.playerNumber);
        playerNumber.setText("Player ONE");
        playerChoice [0] = Player.none;
        playerChoice [1] = Player.none;
        playerChoice [2] = Player.none;
        playerChoice [3] = Player.none;
        playerChoice [4] = Player.none;
        playerChoice [5] = Player.none;
        playerChoice [6] = Player.none;
        playerChoice [7] = Player.none;
        playerChoice [8] = Player.none;
        gridLayout = findViewById(R.id.gridLayout);
        gameReset = findViewById(R.id.buttonReset);

        gameReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameReset();
            }
        });




    }

//    public void checkWinner() {
//
//        if (playerChoice[0] != null && playerChoice[3] != null && playerChoice[6] != null && playerChoice[0] == playerChoice[3] && playerChoice[3] == playerChoice[6]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[1] != null && playerChoice[4] != null && playerChoice[7] != null && playerChoice[1] == playerChoice[4] && playerChoice[4] == playerChoice[7]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[2] != null && playerChoice[5] != null && playerChoice[8] != null && playerChoice[2] == playerChoice[5] && playerChoice[5] == playerChoice[8]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[0] != null && playerChoice[1] != null && playerChoice[2] != null && playerChoice[0] == playerChoice[1] && playerChoice[1] == playerChoice[2]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[3] != null && playerChoice[4] != null && playerChoice[5] != null && playerChoice[3] == playerChoice[4] && playerChoice[4] == playerChoice[5]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[6] != null && playerChoice[7] != null && playerChoice[8] != null && playerChoice[6] == playerChoice[7] && playerChoice[7] == playerChoice[8]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[0] != null && playerChoice[4] != null && playerChoice[8] != null && playerChoice[0] == playerChoice[4] && playerChoice[4] == playerChoice[8]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//
//        } else if (playerChoice[2] != null && playerChoice[4] != null && playerChoice[6] != null && playerChoice[2] == playerChoice[4] && playerChoice[4] == playerChoice[6]) {
//
//            playerNumber.setText(win);
//            isItWon = true;
//        }
//    }


    public void buttonIsTapped(View imageView) {

        ImageView imageTaped = (ImageView) imageView;

        int imgViewTag = Integer.parseInt(imageTaped.getTag().toString());
        if (playerChoice[imgViewTag] == Player.none && !isItWon) {

            playerChoice[imgViewTag] = currentPlayer;


            imageTaped.setTranslationX(-2000);
            imageTaped.setRotation(0);

            if (currentPlayer == Player.one) {

                imageTaped.setImageResource(R.drawable.tiger);
                win = "Player ONE wygrał";
                acctualPlayer = Player.one;
                currentPlayer = Player.two;
                playerNumber.setText("Player TWO");


            } else {

                imageTaped.setImageResource(R.drawable.lion); // Setting image to be placed in selected ImageView
                win = "Player TWO wygrał";
                acctualPlayer = Player.two;
                currentPlayer = Player.one;                     // Changing player
                playerNumber.setText("Player ONE");


            }

            imageTaped.animate().translationXBy(2000).setDuration(300).alpha(1).rotation(3600);

//            checkWinner();
            for (int[] winnerColumns: winnerRowsColumns ) {

                if (playerChoice[winnerColumns[0]] == playerChoice[winnerColumns[1]] && playerChoice[winnerColumns[1]] == playerChoice[winnerColumns[2]] && playerChoice[winnerColumns[0]] != Player.none) {


                    playerNumber.setText("Player " + acctualPlayer + " won!");
                    isItWon = true;
                }

            }

        }


    }

    public void gameReset() {

        isItWon = false;
        playerChoice [0] = Player.none;
        playerChoice [1] = Player.none;
        playerChoice [2] = Player.none;
        playerChoice [3] = Player.none;
        playerChoice [4] = Player.none;
        playerChoice [5] = Player.none;
        playerChoice [6] = Player.none;
        playerChoice [7] = Player.none;
        playerChoice [8] = Player.none;
        playerNumber.setText("Player ONE");
        currentPlayer = Player.one;

        for (int index = 0; index < gridLayout.getChildCount(); index++) {

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0f);

        }



    }
}
