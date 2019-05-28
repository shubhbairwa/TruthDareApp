package com.example.truthdare;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
private Button button;
private ImageView imageView;
private Random random=new Random();
private int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
    }


    public void spin(View view){

       int  newDirection=random.nextInt(9000)+9000;

        float pivotX=imageView.getWidth()/2;
        float pivotY=imageView.getHeight()/2;
       Animation rotate=new RotateAnimation(lastDirection,newDirection,pivotX,pivotY); //it is used for animation and ROTATE ANIMATION is used to rotate a thing with four parameter
        rotate.setDuration(5000);
        rotate.setFillAfter(true);//it is used to get the animation there after done it like when you left a thing on a place it should be there unless you move it.
       rotate.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {
               button.setEnabled(false);
           }

           @Override
           public void onAnimationEnd(Animation animation) {
           button.setEnabled(true);
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });
Toast.makeText(this,"Bottle is moving...Wait to stop",Toast.LENGTH_SHORT).show();

        lastDirection=newDirection; //so that next spin start from previous position not from origin
        imageView.startAnimation(rotate); //because animation is done on image not rotate object
    }
}
