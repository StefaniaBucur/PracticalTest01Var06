package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {
    int new_no;
    int to_guess_number = -1;
    int score = 0;

    TextView score_text = findViewById(R.id.text_score) ;
    TextView score_text = findViewById(R.id.text_score) ;
    TextView text_guessed = findViewById(R.id.guess_text);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);
       // final TextView text_guessed = findViewById(R.id.guess_text);
        final Random rand = new Random();
        final int number_g =  rand.nextInt(5);
        //int to_guess_number = -1;
        //int score = 0;
        score_text = findViewById(R.id.text_score) ;
        text_guessed = findViewById(R.id.guess_text);
      //  score_text = findViewById(R.id.text_score);
      //  score_text.setText(String.valueOf(score));
       // TextView score_text = findViewById(R.id.text_score) ;
        final TextView text_guessed = findViewById(R.id.guess_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("number")) {
            to_guess_number = intent.getIntExtra("number", -1);
        }

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.button_generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_no = rand.nextInt(5);
                text_guessed.setText(String.valueOf(new_no));

            }
        });


        findViewById(R.id.button_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(new_no == to_guess_number){
                    score++;
                    score_text.setText(String.valueOf(score));

                }
            }
        });
        score_text = findViewById(R.id.text_score) ;
      //  text_guessed = findViewById(R.id.guess_text);
        if (savedInstanceState.containsKey("score")) {
            score_text.setText(savedInstanceState.getString("score"));
        } else {
            score_text.setText("0");
        }
        if (savedInstanceState.containsKey("guess")) {
            text_guessed.setText(savedInstanceState.getString("guess"));
        } else {
            text_guessed.setText("");
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView score_text = findViewById(R.id.text_score) ;
        TextView text_guessed = findViewById(R.id.guess_text);
        savedInstanceState.putString("guess", text_guessed.getText().toString());
        savedInstanceState.putString("score", score_text.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        restoreBundle(savedInstanceState);

    }

    private void restoreBundle(Bundle savedInstanceState) {
        TextView score_text = findViewById(R.id.text_score) ;
        TextView text_guessed = findViewById(R.id.guess_text);
        if (savedInstanceState.containsKey("score")) {
            score_text.setText(savedInstanceState.getString("score"));
        } else {
            score_text.setText("0");
        }
        if (savedInstanceState.containsKey("guess")) {
            text_guessed.setText(savedInstanceState.getString("guess"));
        } else {
            text_guessed.setText("");
        }
    }
}
