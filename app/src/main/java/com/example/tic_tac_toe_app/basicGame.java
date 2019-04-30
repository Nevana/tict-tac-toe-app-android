package com.example.tic_tac_toe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class basicGame extends AppCompatActivity {
    boolean playerX;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean activeGame;
    int[][] matrix = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    TextView displayPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_game);
        displayPanel = findViewById(R.id.displayPanel);
        //Random start of X or Y
        if(randomBoolean()){
            playerX = true;
            //Set displayPanel
            displayPanel.setText("Player X starts!");
        }else {
            playerX = false;
            //Set displayPanel
            displayPanel.setText("Player O starts!");
        }
        activeGame = true;
    }
    public boolean randomBoolean(){
        return Math.random() < 0.5;
    }

    public void fieldPressed(View v){
        ImageView image = (ImageView) v;
        int tappedField = Integer.parseInt(image.getTag().toString());
        //String idString = String.format("%d", id);
        //Toast.makeText(this, idString, Toast.LENGTH_LONG).show();
        if(activeGame){
            if(gameState[tappedField] == 2){
                if(playerX){
                    image.setImageResource(R.drawable.x);
                    gameState[tappedField] = 0;
                    if(checkWinner() == "X"){
                        displayPanel.setText("Player X won!");
                    }else if(checkWinner() == "O"){
                        displayPanel.setText("Player O won!");
                    }else {
                        displayPanel.setText("Player O has to choos!");
                        playerX = false;
                    }
                }else{
                    image.setImageResource(R.drawable.o);
                    gameState[tappedField] = 1;
                    if(checkWinner() == "X"){
                        displayPanel.setText("Player X won!");
                    }else if(checkWinner() == "O"){
                        displayPanel.setText("Player O won!");
                    }else {
                        displayPanel.setText("Player X has to choos!");
                        playerX = true;
                    }
                }
            }
        }
    }
    public String checkWinner(){
        for (int[] value: matrix){
            if (gameState[value[0]] == gameState[value[1]] && gameState[value[1]] == gameState[value[2]]) {
                if(gameState[value[0]] != 2 && gameState[value[1]] != 2 && gameState[value[2]] != 2){
                    activeGame = false;
                    if(playerX) {
                        System.out.println("X won");
                        return "X";
                    }else {
                        System.out.println("0 won");
                        return "O";
                    }
                }
            }
        }
        return "2";
    }
    public void resetGame(View v){
        /*
        ImageView[] images = new ImageView[9];
        for (int i = 0; i<9; i++){
            int id = getResources().getIdentifier("imageView" +i, "id", getPackageName());
            images[i] = (ImageView) findViewById(id);
            System.out.println(images[i]);
            //images[i].setImageResource(0);
        }
        */
        ImageView image1 = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);
        ImageView image4 = findViewById(R.id.imageView4);
        ImageView image5 = findViewById(R.id.imageView5);
        ImageView image6 = findViewById(R.id.imageView6);
        ImageView image7 = findViewById(R.id.imageView7);
        ImageView image8 = findViewById(R.id.imageView8);
        ImageView image9 = findViewById(R.id.imageView9);

        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);
        image9.setImageResource(0);

        for(int i = 0; i<9; i++){
            gameState[i] = 2;
        }
        if(randomBoolean()){
            playerX = true;
            displayPanel.setText("Player X starts!");
        }else {
            playerX = false;
            displayPanel.setText("Player 0 starts!");
        }
        activeGame = true;
    }
}
