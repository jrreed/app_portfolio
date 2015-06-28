package com.plainjimbo.appportfolio;

import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;


public class PortfolioActivity extends ActionBarActivity {
    private Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_portfolio, menu);
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

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchSpotifyStreamer(View view) {
        showToast(getString(R.string.spotify_streamer));
    }

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchScoresApp(View view) {
        showToast(getString(R.string.scores_app));
    }

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchLibraryApp(View view) {
        showToast(getString(R.string.library_app));
    }

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchBuildItBigger(View view) {
        showToast(getString(R.string.build_it_bigger));
    }

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchXyzReader(View view) {
        showToast(getString(R.string.xyz_reader));
    }

    /**
     * Called when the user clicks the 'Spotify Streamer' button. Launches the 'Spotify Streamer'
     * app
     */
    public void launchCapstone(View view) {
        showToast(getString(R.string.capstone));
    }

    /**
     * Helper method for displaying the toast message for the given appName.
     */
    private void showToast(String appName) {
        String text = "This button will launch my '" + appName + "' app!";
        cancelCurrentToast();
        currentToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        currentToast.show();
    }

    /**
     * Cancel's the currently showing toast if one exists.
     */
    private void cancelCurrentToast() {
        if (currentToast != null) {
            currentToast.cancel();
        }
    }
}
