package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class ItemView extends LinearLayout {
    Dish d;

    public ItemView(Context context, Dish dish) {
        super(context);

        this.d = dish;
        //Set item text
        TextView text = new TextView(context);
        text.setText(this.d.getName());


        //TextView dishName = (TextView) this.findViewById(R.id.itemName);
        //dishName.setText(String.valueOf(this.d.getName()));

        //Set item image
        //ImageView dishImage = (ImageView) this.findViewById(R.id.itemImage);
        //dishImage.setImageResource(DinnerPlannerApplication.getImageResId(context, this.d.getImage()));

    }
}
