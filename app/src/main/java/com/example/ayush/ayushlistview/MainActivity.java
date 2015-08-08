package com.example.ayush.ayushlistview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a array of the list of birds
        String[] birdList = {"peacock", "sparrow", "falcon", "eagle", "cardinal"};
        //Looking for the id of the list view we created in activity_main.xml
        final ListView birdListView = (ListView) findViewById(R.id.bird_list_view);

        //Creating an adapter for the array and giving it parameters (it is a constructor)
        ArrayAdapter<String> birdListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, birdList);

        //Setting the adapter to the List View we created
        birdListView.setAdapter(birdListAdapter);

        //Creating an onClickListener for the List View
        ListView.OnItemClickListener birdListViewItemClickListener = new ListView.OnItemClickListener() {
            @Override
            //Invoking method called onItemClick with parameters
            //I believe that this is allow the item to be clicked on
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;

                String itemValue = (String) birdListView.getItemAtPosition(itemPosition);

            }

        };
        //Setting onItemClickListener to birdList View
        birdListView.setOnItemClickListener(birdListViewItemClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
