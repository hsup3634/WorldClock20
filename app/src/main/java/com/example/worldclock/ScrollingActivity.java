package com.example.worldclock;

import android.icu.text.TimeZoneFormat;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import static java.lang.System.currentTimeMillis;

public class ScrollingActivity extends AppCompatActivity {


    LinearLayout sydneyb, newyorkb, tokyob, hanoib, londonb, seoulb, dubaib;
    TextView newyorkTime;
    Calendar current;
    long milliSeconds;
    SimpleDateFormat sdf;
    Date resultDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        sydneyb = (LinearLayout) findViewById(R.id.sydneyhide);
        newyorkb = (LinearLayout) findViewById(R.id.newyorkhide);
        tokyob = (LinearLayout) findViewById(R.id.tokyohide);
        hanoib = (LinearLayout) findViewById(R.id.hanoihide);
        londonb = (LinearLayout) findViewById(R.id.londonhide);
        seoulb = (LinearLayout) findViewById(R.id.seoulhide);
        dubaib = (LinearLayout) findViewById(R.id.dubaihide);


        //Sydney Current Time
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.sydneyTime);
                                long date = currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {

                }
            }

        };
        t.start();


        /*/New York
        newyorkTime = (TextView) findViewById(R.id.newyorkTime);
        newyorkTimeMethod();
        protected newyorkTimeMethod() {
            TimeZone timeZone = TimeZone.getTimeZone("America/New_York");

            int TimeZoneOffset = timeZone.getRawOffset() / (60 * 1000);

            int hrs = TimeZoneOffset / 60;
            int mins = TimeZoneOffset % 60;

            milliSeconds = milliSeconds + timeZone.getRawOffset();

            resultDate = new Date(milliSeconds);
            System.out.println(sdf.format(resultDate));
            //timeZone.setText(TimeZoneName + " : GMT " + hrs + "." + mins);
            newyorkTime.setText("" + sdf.format(resultDate));
            milliSeconds = 0;
        }*/





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "✓ Click on the image to hide a city \n✓ Click on the eye button to show all cities", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                sydneyb.setVisibility(View.VISIBLE);
                newyorkb.setVisibility(View.VISIBLE);
                tokyob.setVisibility(View.VISIBLE);
                hanoib.setVisibility(View.VISIBLE);
                londonb.setVisibility(View.VISIBLE);
                seoulb.setVisibility(View.VISIBLE);
                dubaib.setVisibility(View.VISIBLE);
            }
        });


    }








        public void sydneybClicked(View v){
            sydneyb.setVisibility(View.GONE);
        }

        public void newyorkbClicked(View v){
            newyorkb.setVisibility(View.GONE);
         }

        public void tokyobClicked(View v){
            tokyob.setVisibility(View.GONE);
        }

        public void hanoibClicked(View v){
            hanoib.setVisibility(View.GONE);
        }

        public void londonbClicked(View v){
            londonb.setVisibility(View.GONE);
        }

        public void seoulbClicked(View v){
            seoulb.setVisibility(View.GONE);
        }

        public void dubaibClicked(View v){
            dubaib.setVisibility(View.GONE);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
