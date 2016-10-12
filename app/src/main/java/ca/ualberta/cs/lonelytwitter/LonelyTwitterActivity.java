/*
Copyright (c) 2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved.
You may use, distribute, and copy all or parts of this code uner the terms of conditions of
University of Alberta and the Code of Student Behaviour.
You can find the ocpy of the licence at http://www.github.com/Team20/...
For further information please contact...
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of LonelyTwitter project. <p>It handles all user
 * interactions as well as file manipulations </p>
 * <pre> All the files are stored in the format of json </pre>
 * <code> pseudo code sample:
 * open some fil...attach some text... close the file.</code>
 *
 * @since 1.0
 * @see NormalTweet
 * @author Kieter
 */
public class LonelyTwitterActivity extends Activity {
    public static Tweet selectedTweet;

    /**
     * This is the file name that is being saved / loaded and contains all the tweets in json
     * @see #loadFromFile()
     * @see #saveInFile()
     */
	private static final String FILENAME = "file.sav";

    /**
     * This is the text of the body
     */
	private EditText bodyText;

    /**
     * This ListView displays previous tweets
     */
	private ListView oldTweetsList;

    /**
     * tweetList contaiins all of the Tweets
     */
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

    /**
     * adapter adsapts the tweetList to the oldTweetsList ListView
     */
	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}

		});

        Button clearButton = (Button)findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                // call functions to clear screen and then data
                clearEverything();
            }
        });

        oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //selectedTweet = (Tweet) oldTweetsList.getItemAtPosition(position);
                Intent intent = new Intent(LonelyTwitterActivity.this, EditTweetActivity.class);
                intent.putExtra("tweet", ((Tweet)oldTweetsList.getItemAtPosition(position)).getMessage());
                startActivity(intent);
            }
        });
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * This methods loads the tweets from FILENAME and...
     * @throws FileNotFoundException
     * @exception FileNotFoundException
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

    /**
     * This methods save tweets to FILENAME
     * @exception FileNotFoundException
     * @exception IOException
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

    /**
     * This method clears the screen and erases the file.
     */
    private void clearEverything() {
        adapter.clear();
        tweetList.clear();
        adapter.notifyDataSetChanged();
        saveInFile();
        bodyText.setText("");
        bodyText.clearAnimation();
    }

}