package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here
    protected TextView textView ;
    protected Button button1;
    protected Button button2;
    protected int tint,b1int,b2int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
             tint = savedInstanceState.getInt("text");
             b1int = savedInstanceState.getInt("b1");
             b2int = savedInstanceState.getInt("b2");
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textView = (TextView) findViewById(R.id.storyTextView);
        button1 = (Button) findViewById(R.id.buttonTop);
        button2 = (Button) findViewById(R.id.buttonBottom);
        if(savedInstanceState!=null) {
            textView.setText(tint);
            button1.setText(b1int);
            button2.setText(b2int);
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(button1.getText()==getString(R.string.T1_Ans1)||button1.getText()==getString(R.string.T2_Ans1)){
                    tint = R.string.T3_Story;
                    b1int = R.string.T3_Ans1;
                    b2int = R.string.T3_Ans2;
                }
                else if(textView.getText()==getString(R.string.T2_Story)) b2int = R.string.T5_End;
                else
                    b1int = R.string.T6_End;
                textView.setText(tint);
                button1.setText(b1int);
                button2.setText(b2int);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               if(button2.getText()==getString(R.string.T1_Ans2)){
                   tint = R.string.T2_Story;
                   b1int = R.string.T2_Ans1;
                   b2int = R.string.T2_Ans2;
               }
               else if(textView.getText()==getString(R.string.T3_Story)){
                   b2int = R.string.T5_End;
               }
               else b2int = R.string.T4_End;

               textView.setText(tint);
               button1.setText(b1int);
               button2.setText(b2int);
           }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }

    public void onSaveInstanceState(Bundle outState){
        outState.putInt("text",tint);
        outState.putInt("b1",b1int);
        outState.putInt("b2",b2int);
    }
}
