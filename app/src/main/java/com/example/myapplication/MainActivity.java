package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    TextView textView;
    SwipeListener swipeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        relativeLayout=findViewById(R.id.relative_layout);
        textView= findViewById(R.id.text_view);
    }

    private class SwipeListener implements View.OnTouchListener{

       GestureDetector gestureDetector;
       SwipeListener(View view){
           int threshold = 100;
           int velocity_threshold = 100;

           GestureDetector.SimpleOnGestureListener listener =new GestureDetector.SimpleOnGestureListener(){
                @Override
               public  boolean onDown(MotionEvent e){
                    return true ;
                }
                @Override
               public boolean onFling(MotionEvent e1, MotionEvent e2,float velocityX ,float velocityY  ){
                    float xDiff = e2.getX() - e1.getX();
                    float yDiff= e2.getY()- e1.getY();
                    try{
                        if(Math.abs(xDiff) > Math.abs(yDiff)){
                            if(Math.abs(xDiff) >threshold) &&
                            Math.abs(velocityX ) > velocity_threshold){
                                    if (xDiff >0){
                                        textView.setText("Swiped Right");

                                    }else{
                                        textView.setText(("Swiped Left"));
                                    }
                                    return true
                            }
                        }
                        else{
                            if (Math.abs(yDiff)> threshold
                            && Math.abs(velocityY) > velocity_threshold)
                            if (yDiff) >0 {
                                textView.setText("Swiped ")
                            }
                        }

                        }catch (Exception e){
                        e.printStackTrace();
                    }
                }
           };


       }
    }
}