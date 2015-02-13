package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class MenuView {

    View view = null;
    DinnerModel model = null;

    LinearLayout Starter;
    LinearLayout MainCourse;
    LinearLayout Dessert;

    Context context;

    public MenuView(View view, DinnerModel model) {

        this.view = view;
        this.model = model;
        context = this.view.getContext();

        //set default guest number
        EditText guests = (EditText) view.findViewById(R.id.txtNumberOfGuests);
        guests.setText(String.valueOf(model.getNumberOfGuests()));

        //set total price field
        TextView price = (TextView) view.findViewById(R.id.txtPrice);
        price.setText(String.valueOf(model.getTotalMenuPrice()));

        //load pictures
        //bakedbrie
        ImageButton d1 = (ImageButton) view.findViewById(R.id.imgStarter1);
        int ResId = DinnerPlannerApplication.getDrawable(view.getContext(), "bakedbrie");
        d1.setImageResource(ResId);

        //sourdough
        ImageButton d2 = (ImageButton) view.findViewById(R.id.imgStarter2);
        int ResId2 = DinnerPlannerApplication.getDrawable(view.getContext(), "sourdough");
        d2.setImageResource(ResId2);

        //toast
        ImageButton d3 = (ImageButton) view.findViewById(R.id.imgStarter3);
        int ResId3 = DinnerPlannerApplication.getDrawable(view.getContext(), "toast");
        d3.setImageResource(ResId3);

        //Meatballs
        ImageButton d4 = (ImageButton) view.findViewById(R.id.imgMain1);
        int ResId4 = DinnerPlannerApplication.getDrawable(view.getContext(), "meatballs");
        d4.setImageResource(ResId4);

        //Ice Cream
        ImageButton d5 = (ImageButton) view.findViewById(R.id.imgDessert1);
        int ResId5 = DinnerPlannerApplication.getDrawable(view.getContext(), "icecream");
        d5.setImageResource(ResId5);

        // Add dishes to Starter/ Main/ Dessert list accordingly
        //Starter = (LinearLayout) view.findViewById(R.id.Starter);
        //MainCourse = (LinearLayout) view.findViewById(R.id.MainCourse);
        //Dessert = (LinearLayout) view.findViewById(R.id.Dessert);

  /*      Set<Dish> allDishes = model.getDishes();
        for (Dish d : allDishes) {
            if (d.getType() == Dish.STARTER)
            {
                ItemView item = new ItemView(context, d);
                Starter.addView(item);
            }
            else if (d.getType() == Dish.MAIN)
            {
                ItemView item = new ItemView(context, d);
                MainCourse.addView(item);
            }
            else if (d.getType() == Dish.DESERT)
            {
                ItemView item = new ItemView(context, d);
                Dessert.addView(item);
            }



        }*/
    }


}