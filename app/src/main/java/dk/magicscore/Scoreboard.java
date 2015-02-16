package dk.magicscore;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class Scoreboard extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "dk.magicscore.MESSAGE";
    public final static String COLOR_MESSAGE = "dk.magicscore.COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        EditText health = (EditText) findViewById(R.id.health);
        health.setText(message);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoreboard, menu);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent background = getIntent();
            Intent intent = new Intent(this, MainActivity.class);
            EditText edit = (EditText) findViewById(R.id.health);
            String message = edit.getText().toString();
            String color = background.getStringExtra(MainActivity.COLOR_MESSAGE);
            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(COLOR_MESSAGE, color);
            startActivity(intent);
        }

    }
}
