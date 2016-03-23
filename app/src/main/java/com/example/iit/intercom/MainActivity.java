package com.example.iit.intercom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    StarterApplication starterApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        starterApplication = (StarterApplication)getApplicationContext();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private Menu mMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        mMenu = menu;
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.turnOnCamera_Clicked) {


        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        switch (id) {
            case R.id.turnOnCamera_Clicked:

             /*   MenuItem item2 = mMenu.findItem(R.id.history_Clicked);
                eventCameraOnClicked();

                if(mMenu!=null){
                item2.setVisible(false);
                }*/
                eventCameraOnClicked();
                break;
            case R.id.turnOffCamera_Clicked:
                eventCameraOffClicked();
                //Toast.makeText(MainActivity.this, item.getItemId(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.turnOnmicro_Clicked:
                eventMicroOnClicked();
                //Toast.makeText(MainActivity.this, item.getItemId(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.turnOffmicro_Clicked:
                eventMicroOffClicked();
                //Toast.makeText(MainActivity.this, item.getItemId(), Toast.LENGTH_SHORT).show();

                break;
            case R.id.close_door_Clicked:
                eventCloseDoorClicked();
                break;
            case R.id.open_door_Clicked:
                eventOpenDoorClicked();
                break;
            case R.id.door_hisotory:
                eventDoorHisotryClicked();
                break;
            case R.id.video_hisotory:
                eventVideoHisotryClicked();
                break;
            case R.id.door_status_Clicked:
                eventStatusDoorClicked();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void login(String login, String pwd) throws com.parse.ParseException {
        //ParseUser pu = logIn("system","system");
        ParseUser.logInInBackground("system", "system", new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {
                // text2.setText(user.getUsername());
                Log.v("-------------------",user.getUsername());
            }
        });


    }

    private void eventCameraOnClicked() {
        Toast.makeText(MainActivity.this, "Camera on Clicked", Toast.LENGTH_SHORT).show();

        try {
            login("ali","dmk");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private void eventCameraOffClicked() {
        Toast.makeText(MainActivity.this, "Camera off Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventMicroOnClicked() {
        Toast.makeText(MainActivity.this, "Micro On Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventMicroOffClicked() {
        Toast.makeText(MainActivity.this, "Micro Off Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventOpenDoorClicked() {
        Toast.makeText(MainActivity.this, "Open Door Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventCloseDoorClicked() {
        Toast.makeText(MainActivity.this, "Close Door Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventStatusDoorClicked() {
        Toast.makeText(MainActivity.this, " Door Status Clicked", Toast.LENGTH_SHORT).show();
    }


    private void eventDoorHisotryClicked() {
        Toast.makeText(MainActivity.this, "Door History Clicked", Toast.LENGTH_SHORT).show();
    }

    private void eventVideoHisotryClicked() {
        Toast.makeText(MainActivity.this, "Video History Clicked", Toast.LENGTH_SHORT).show();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {

        mMenu = menu;
        return true;
    }

}
