package com.example.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0==o;1==x;2==NULL
    boolean flag = true;
    int player = 0;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] win = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void tap(View view){
        ImageView img = (ImageView) view;
        int cur = Integer.parseInt(img.getTag().toString());

        if(!flag){
            flag = true;
            player = 0;
            for(int i=0; i<state.length; i++){
                state[i] = 2;
            }
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

            TextView status = findViewById(R.id.status);
            status.setText("X's Turn : Tap to play");
        }

        if(state[cur] == 2)
        {
            state[cur] = player;
            img.setTranslationY(-1000f);
            if (player == 0) {
                img.setImageResource(R.drawable.o);
                player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn : Tap to play");
            } else {
                img.setImageResource(R.drawable.x);
                player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn : Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] pos: win){
            if(state[pos[0]] == state[pos[1]] && state[pos[1]] == state[pos[2]] && state[pos[0]]!=2){
                String winner;
                flag = false;
                if(state[pos[0]] == 0){
                    winner = "O has won";
                }
                else{
                    winner = "X has won";
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}