package com.plainjimbo.appportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class CreditsActivity extends AppCompatActivity {
    ArrayList<String> mCreditsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        initCreditsList();
        initCreditsListView();
    }

    /**
     * Initializes the list of credits as an ArrayList<String> from the assets/credits.json file.
     */
    private void initCreditsList() {
        mCreditsList = new ArrayList<String>();
        try {
            // Open the credits.json asset file and read it into a byte[].
            InputStream creditsStream = getAssets().open("credits.json");
            byte[] bytes = new byte[creditsStream.available()];
            creditsStream.read(bytes);
            creditsStream.close();

            // Convert the byte[] -> String -> JSONArray then add all the credit strings
            JSONArray jsonArray = new JSONArray(new String(bytes, "UTF-8"));
            for(int index=0, elements = jsonArray.length(); index < elements; index++) {
                mCreditsList.add(jsonArray.getString(index));
            }
        } catch (IOException exc) {
        } catch (JSONException exc) {}
    }

    /**
     * Initializes the ListView with an ArrayAdapter bound to our credits data source.
     */
    private void initCreditsListView() {
        ArrayAdapter<String> creditsListAdapter = new ArrayAdapter<String>(this, R.layout.listitem_credit, R.id.listitem_credit_textview, mCreditsList);
        ListView creditsListView = (ListView)findViewById(R.id.listview_credits);
        creditsListView.setAdapter(creditsListAdapter);
    }
}
