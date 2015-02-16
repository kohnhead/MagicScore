package dk.magicscore;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "dk.magicscore.MESSAGE";
    public final static String COLOR_MESSAGE = "dk.magicscore.COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Scoreboard.EXTRA_MESSAGE);
        EditText health = (EditText) findViewById(R.id.health);
        String color = intent.getStringExtra(ColorActivity.COLOR_MESSAGE);
        if (message == null)
            health.setText("20");
        else
            health.setText(message);

        if (color != null)
            changeColor(color);
    }

    public void clickPlus(View view){
        EditText health = (EditText) findViewById(R.id.health);
        int newHealth = Integer.parseInt(health.getText().toString());
        newHealth++;
        health.setText(Integer.toString(newHealth));
    }

    public void clickMinus(View view){
        EditText health = (EditText) findViewById(R.id.health);
        int newHealth = Integer.parseInt(health.getText().toString());
        newHealth--;
        health.setText(Integer.toString(newHealth));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_colors:
                Intent intent = new Intent(this, ColorActivity.class);
                EditText edit = (EditText) findViewById(R.id.health);
                String message = edit.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Intent intent = new Intent(this, Scoreboard.class);
            EditText edit = (EditText) findViewById(R.id.health);
            String message = edit.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

    }

    public void changeColor(String color){
        LinearLayout view = (LinearLayout)findViewById(R.id.background);
        int id = R.drawable.test;

        if (color.equals("White"))
            id = R.drawable.white;
        else if (color.equals("Blue"))
            id = R.drawable.blue;
        else if (color.equals("Black"))
            id = R.drawable.black;
        else if (color.equals("Red"))
            id = R.drawable.red;
        else if (color.equals("Green"))
            id = R.drawable.green;
        else if (color.equals("WhiteBlack"))
            id = R.drawable.whiteblack;
        else if (color.equals("BlackGreen"))
            id = R.drawable.blackgreen;
        else if (color.equals("BlueBlack"))
            id = R.drawable.blueblack;
        else if (color.equals("RedGreen"))
            id = R.drawable.redgreen;
        else if (color.equals("BlueGreen"))
            id = R.drawable.bluegreen;

        view.setBackground(getResources().getDrawable(id));
    }
}
