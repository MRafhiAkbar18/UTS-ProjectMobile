package com.example.kiit.tictactoe;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int myActivePlayer=0;
    //0 for cross and 1 for circle
    int counter = 0;
    int counter1 = 0;
    int[] myGameState={2,2,2,2,2,2,2,2,2};
    public void imageTapped(View view)
    {
        ImageView myTapped=(ImageView) view;

        int tappedimageTag=Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tappedimageTag]==2) {
            myGameState[tappedimageTag] = myActivePlayer;
            if (myActivePlayer == 0) {
                myTapped.setImageResource(R.drawable.icons8delete64);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else {
                myTapped.setImageResource(R.drawable.icons8round64);
                myTapped.animate().rotationY(360).setDuration(1000);
                myActivePlayer = 0;

            }
        }
        else
        {

            Toast.makeText(MainActivity.this,
                    "This place is already filled", Toast.LENGTH_LONG).show();
        }
    }
    public void playAgain(View view)
    {
        Log.i("msg","Button is tapped");
        for(int i=0;i<myGameState.length;i++)
        myGameState[i]=2;

        myActivePlayer=0;

        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.lineone);
        for(int i=0;i<linearLayout.getChildCount();i++)
        {
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout1=(LinearLayout) findViewById(R.id.linetwo);
        for(int i=0;i<linearLayout1.getChildCount();i++)
        {
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2=(LinearLayout) findViewById(R.id.linethree);
        for(int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton b = (ImageButton) findViewById(R.id.change_text_button1);
        ImageButton a = (ImageButton) findViewById(R.id.change_text_button);


        Resources res = getResources();
        final String[] list = res.getStringArray(R.array.list);
        final String[] list1 = res.getStringArray(R.array.list1);
        ((TextView) findViewById(R.id.text_to_change1)).setText(list1[counter1]);
        ((TextView) findViewById(R.id.text_to_change)).setText(list[counter]);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tx = (TextView) findViewById(R.id.text_to_change1);
                counter1++;
                if (counter1 >= list1.length)
                    counter1 = 0;

                tx.setText(list1[counter1]);

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tx = (TextView) findViewById(R.id.text_to_change);
                counter++;
                if (counter >= list.length)
                    counter = 0;

                tx.setText(list[counter]);

            }
        });
    }
}
