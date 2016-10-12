package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView tweetView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        tweetView.setText(intent.getStringExtra("tweet"));
    }
}
