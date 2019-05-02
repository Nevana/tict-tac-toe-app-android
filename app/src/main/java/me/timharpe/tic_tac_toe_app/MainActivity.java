package me.timharpe.tic_tac_toe_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.timharpe.tic-tac-toe-app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openBasicGame(View v) {
        startActivity(new Intent(this, basicGame.class));
    }
    public void openAiGame(View v){
        startActivity(new Intent(this, aiGame.class));
    }
}