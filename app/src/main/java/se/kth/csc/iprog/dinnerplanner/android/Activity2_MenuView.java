package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.MenuViewClickController;
import se.kth.csc.iprog.dinnerplanner.android.view.MenuViewController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class Activity2_MenuView extends Activity {

    DinnerModel model;

    public Activity2_MenuView(){

    }

    MenuView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_menu);
        model = ((DinnerPlannerApplication) this.getApplication()).getModel();
        mainView = new MenuView(findViewById(R.id.activity2_menu_id), model);

        MenuViewClickController clickController = new MenuViewClickController(model, mainView);
        MenuViewController menuController = new MenuViewController(model, mainView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity2_menu, menu);
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

    public void sendMessage(View view) {
        if ((model.getNumberOfGuests() > 0) && !model.getFullMenu().isEmpty()) {
            Intent intent = new Intent(this, PageFinal.class);
            startActivity(intent);
            finish();
        }

    }

}
