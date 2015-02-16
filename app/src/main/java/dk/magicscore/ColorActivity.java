package dk.magicscore;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Queue;


public class ColorActivity extends ActionBarActivity {

    /** TODO
     * check which color boxes have been checked
     * only allow up to 2 colors to be selected (disabling the others)
     * change background to color choice
     * add button to navigate back to main activity
     * @param savedInstanceState
     */

    public final static String EXTRA_MESSAGE = "dk.magicscore.MESSAGE";
    public final static String COLOR_MESSAGE = "dk.magicscore.COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
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

    public void onColorSelect(View view){
        Intent score = getIntent();
        Intent intent = new Intent(this, MainActivity.class);

        String background = new String();
        String extra = score.getStringExtra(MainActivity.EXTRA_MESSAGE);

        CheckBox white = (CheckBox)findViewById(R.id.whiteBox);
        CheckBox blue = (CheckBox)findViewById(R.id.blueBox);
        CheckBox black = (CheckBox)findViewById(R.id.blackBox);
        CheckBox red = (CheckBox)findViewById(R.id.redBox);
        CheckBox green = (CheckBox)findViewById(R.id.greenBox);

        CheckBox[] colors = {white, blue, black, red, green};

        int i = 0;
        while(i < 5){
            CheckBox color = colors[i++];
            if(color.isChecked())
                background += color.getText();
        }

        TextView text = (TextView)findViewById(R.id.color);
        text.setText(background);
        intent.putExtra(COLOR_MESSAGE, background);
        intent.putExtra(EXTRA_MESSAGE, extra);

        startActivity(intent);
    }
}
