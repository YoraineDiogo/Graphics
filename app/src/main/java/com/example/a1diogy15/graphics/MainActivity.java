package com.example.a1diogy15.graphics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //my custom view should be the main voew of the activity
        //so remove the below

        //setContentView(R.layout.activity_main);

        //and add
        GraphicsView gv = new GraphicsView(this);
        setContentView(gv);
    }

    //BACKGROUND THREADS CANNOT UPDATE THE MAIN UI

    /*
    *
    * publishProgress() - allows us to update the main UI
    * thread while the background task is running
    *
    * */

    //AsyncTask<Input params, Progress, Result>

    /*
    *
    * Main UI thread                           Background AsyncTask
    *                                          doInBackground
    *                                          move the monster
    * onProgressUpdate()  <------------------  publishProgress(mx, my)
    * update your UI
    *
    * */

    /*
    *
    * onProgressUpdaate(){
    *       postInvalidate();   --> Forces the voew to redraw itself
    *
    * */

}
