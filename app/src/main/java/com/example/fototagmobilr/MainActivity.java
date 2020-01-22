package com.example.fototagmobilr;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

import java.io.IOException;
import java.net.URL;
import java.io.InputStream;

import static java.lang.Float.compare;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn;
    private ImageView imView;
    Bitmap bitmap;
    private RatingBar rBar;
    private float[] rList = new float[10];
    private RatingBar[] ratingBars = new RatingBar[10];
    private ImageView[] Images = new ImageView[10];
    private int filter;
    String s1 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/bunny.jpg";
    String s2 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/chinchilla.jpg";
    String s3 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/doggo.jpg";
    String s4 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/fox.jpg";
    String s5 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/hamster.jpg";
    String s6 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/husky.jpg";
    String s7 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/kitten.png";
    String s8 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/loris.jpg";
    String s9 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/puppy.jpg";
    String s10 = "https://www.student.cs.uwaterloo.ca/~cs349/w19/assignments/images/sleepy.png";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetRating();
        addListenerOnButton();
        addClearButtonListener();
        filterImageListener();
    }



    private void makeAllVisible(){

        for(int i=0; i<10; i++){

            ratingBars[i].setVisibility(View.VISIBLE);
            Images[i].setVisibility(View.VISIBLE);
        }
    }




    public void filterImageListener(){


        final RatingBar fBar = (RatingBar) findViewById(R.id.filter_bar);

        fBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                makeAllVisible();

                    for(int i=0; i<10; i++){

                        float t1 = (float) ratingBars[i].getRating();
                        float t2 = (float) fBar.getRating();

                        int comp = compare(t1,t2);

                        if(comp < 0 ) {
                            ratingBars[i].setVisibility(View.GONE);
                            Images[i].setVisibility(View.GONE);
                        }

                    }

            }
        });
    }







    public void addListenerOnButton(){

        btn = (ImageButton) findViewById(R.id.load_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetRating();

                imView = (ImageView) findViewById(R.id.image_1);
                Images[0] = imView;
                new GetImageFromURL(imView).execute(s1);

                imView = (ImageView) findViewById(R.id.image_2);
                Images[1] = imView;
                new GetImageFromURL(imView).execute(s2);

                imView = (ImageView) findViewById(R.id.image_3);
                Images[2] = imView;
                new GetImageFromURL(imView).execute(s3);

                imView = (ImageView) findViewById(R.id.image_4);
                Images[3] = imView;
                new GetImageFromURL(imView).execute(s4);

                imView = (ImageView) findViewById(R.id.image_5);
                Images[4] = imView;
                new GetImageFromURL(imView).execute(s5);

                imView = (ImageView) findViewById(R.id.image_6);
                Images[5] = imView;
                new GetImageFromURL(imView).execute(s6);

                imView = (ImageView) findViewById(R.id.image_7);
                Images[6] = imView;
                new GetImageFromURL(imView).execute(s7);

                imView = (ImageView) findViewById(R.id.image_8);
                Images[7] = imView;
                new GetImageFromURL(imView).execute(s8);

                imView = (ImageView) findViewById(R.id.image_9);
                Images[8] = imView;
                new GetImageFromURL(imView).execute(s9);

                imView = (ImageView) findViewById(R.id.image_10);
                Images[9] = imView;
                new GetImageFromURL(imView).execute(s10);



        }
        });

    }

    //Listener for clear button press
    public void addClearButtonListener(){

        btn = (ImageButton) findViewById(R.id.clear_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetRating();

                imView = (ImageView) findViewById(R.id.image_1);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_2);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_3);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_4);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_5);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_6);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_7);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_8);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_9);
                imView.setImageResource(R.drawable.black_border);

                imView = (ImageView) findViewById(R.id.image_10);
                imView.setImageResource(R.drawable.black_border);




            }
        });


        }




    public void resetRating() {

        rBar = (RatingBar) findViewById(R.id.rBar1);
        rBar.setRating(0);
        rList[0] = 0;
        ratingBars[0] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar2);
        rBar.setRating(0);
        rList[1] = 0;
        ratingBars[1] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar3);
        rBar.setRating(0);
        rList[2] = 0;
        ratingBars[2] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar4);
        rBar.setRating(0);
        rList[3] = 0;
        ratingBars[3] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar5);
        rBar.setRating(0);
        rList[4] = 0;
        ratingBars[4] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar6);
        rBar.setRating(0);
        rList[5] = 0;
        ratingBars[5] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar7);
        rBar.setRating(0);
        rList[6] = 0;
        ratingBars[6] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar8);
        rBar.setRating(0);
        rList[7] = 0;
        ratingBars[7] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar9);
        rBar.setRating(0);
        rList[8] = 0;
        ratingBars[8] = rBar;

        rBar = (RatingBar) findViewById(R.id.rBar10);
        rBar.setRating(0);
        rList[9] = 0;
        ratingBars[9] = rBar;

    }


        // The following code was obtained from this source : https://www.youtube.com/watch?v=Il3uB5u2pSA

    public class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {

        ImageView imgView;

        public GetImageFromURL(ImageView imgV){
            this.imgView = imgV;
        }


        @Override
        protected Bitmap doInBackground(String... url){
            String urld = url[0];
            bitmap = null;
            try{
                InputStream str = new java.net.URL(urld).openStream();
                bitmap = BitmapFactory.decodeStream(str);
            }  catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
         protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }

    }



}
