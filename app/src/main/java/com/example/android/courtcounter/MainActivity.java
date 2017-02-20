package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;
    Button bt3;

    Button bt4;
    Button bt5;
    Button bt6;

    int scoreTeamA=0;
    int scoreTeamB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMeth();
    }

    public void buttonMeth(){
        bt1 = (Button) findViewById(R.id.free_throw);
        bt2 = (Button) findViewById(R.id.two_points);
        bt3 = (Button) findViewById(R.id.three_points);

        bt4 = (Button) findViewById(R.id.three_pointsb);
        bt5 = (Button) findViewById(R.id.two_pointsb);
        bt6 = (Button) findViewById(R.id.free_throwb);

        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);

        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);

    }

    public void displayForTeam(int score, int viewId) {
        if(viewId == R.id.free_throw || viewId == R.id.two_points || viewId == R.id.three_points){
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }
        else if(viewId == R.id.free_throwb || viewId == R.id.two_pointsb || viewId == R.id.three_pointsb){
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score));
        }
        else if(viewId == R.id.reset){
            TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
            scoreViewA.setText(String.valueOf(score));
            TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
            scoreViewB.setText(String.valueOf(score));
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.three_points:
                    scoreTeamA += 3;
                    displayForTeam(scoreTeamA, view.getId());
                    break;
                case R.id.two_points:
                    scoreTeamA += 2;
                    displayForTeam(scoreTeamA, view.getId());
                    break;
                case R.id.free_throw:
                    scoreTeamA++;
                    displayForTeam(scoreTeamA, view.getId());
                    break;
                case R.id.three_pointsb:
                    scoreTeamB += 3;
                    displayForTeam(scoreTeamB, view.getId());
                    break;
                case R.id.two_pointsb:
                    scoreTeamB += 2;
                    displayForTeam(scoreTeamB, view.getId());
                    break;
                case R.id.free_throwb:
                    scoreTeamB++;
                    displayForTeam(scoreTeamB, view.getId());
                    break;
            }
        }
    };

    public void resetScore(View view){
        scoreTeamA = scoreTeamB = 0;
        displayForTeam(scoreTeamA, view.getId());
    }

}

/*
*
* <resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
* */
