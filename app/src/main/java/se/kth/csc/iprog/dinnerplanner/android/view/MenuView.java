package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.graphics.Color;
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
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class MenuView implements Observer {

    View view = null;
    DinnerModel model = null;

    ImageButton imgStarter1,imgStarter2,imgStarter3,imgMain1,imgDessert1;
    TextView txtStarter1, txtStarter2, txtStarter3, txtMain1, txtDessert1;

    DishPopupView popupView;
    public PopupWindow dishpopup;

    //total price field
    TextView price;
    //guest field
    EditText guests;

    Context context;

    public MenuView(View view, DinnerModel model) {

        this.view = view;
        this.model = model;
        context = this.view.getContext();

        //total price field
        price = (TextView) view.findViewById(R.id.txtPrice);
        //guest field
        guests = (EditText) view.findViewById(R.id.txtNumberOfGuests);

        //register view to model as observer
        model.addObserver(this);

        //set default guest number
        guests.setText(String.valueOf(model.getNumberOfGuests()));

        //set total price field
        updateCost();

        //load pictures
        //baked brie
        imgStarter1 = (ImageButton) view.findViewById(R.id.imgStarter1);
        int ResId = DinnerPlannerApplication.getDrawable(view.getContext(), "bakedbrie");
        imgStarter1.setImageResource(ResId);


        //sourdough
        imgStarter2 = (ImageButton) view.findViewById(R.id.imgStarter2);
        int ResId2 = DinnerPlannerApplication.getDrawable(view.getContext(), "sourdough");
        imgStarter2.setImageResource(ResId2);

        //toast
        imgStarter3 = (ImageButton) view.findViewById(R.id.imgStarter3);
        int ResId3 = DinnerPlannerApplication.getDrawable(view.getContext(), "toast");
        imgStarter3.setImageResource(ResId3);

        //Meatballs
        imgMain1 = (ImageButton) view.findViewById(R.id.imgMain1);
        int ResId4 = DinnerPlannerApplication.getDrawable(view.getContext(), "meatballs");
        imgMain1.setImageResource(ResId4);

        //Ice Cream
        imgDessert1 = (ImageButton) view.findViewById(R.id.imgDessert1);
        int ResId5 = DinnerPlannerApplication.getDrawable(view.getContext(), "icecream");
        imgDessert1.setImageResource(ResId5);

        //get text fields
        txtStarter1 = (TextView) view.findViewById(R.id.txtStarter1);
        txtStarter2 = (TextView) view.findViewById(R.id.txtStarter2);
        txtStarter3 = (TextView) view.findViewById(R.id.txtStarter3);
        txtMain1 = (TextView) view.findViewById(R.id.txtMain1);
        txtDessert1 = (TextView) view.findViewById(R.id.txtDessert1);

    }
    public void update(Observable o, Object updatedItem) {

            DinnerModel model = (DinnerModel) o;
            //check if dish changed
            if (updatedItem instanceof Dish)
            {
                Dish changedDish = (Dish) updatedItem;
                //change dish in model
                model.selectDish(changedDish);
            }
            //check if guests changed
            else if(updatedItem instanceof TextView)
            {
                //change guests in model
                model.setNumberOfGuests(Integer.parseInt(guests.getText().toString()));
            }

        //update price
        this.updateCost();
    }


    /*public void showPopup(Dish dish){

        popupView = new DishPopupView (context, dish , model);
        popupView.post(new Runnable() {
            public void run() {
                dishpopup = new PopupWindow((View)popupView, 400, 600, true);
                dishpopup.setTouchable(true);
                dishpopup.setBackgroundDrawable(null);
                //pressedDishWindow.setFocusable(true);
                dishpopup.showAsDropDown(guests, -50, 0);    }
        });


    }*/

    public void updateCost() {
    price.setText(String.valueOf(model.getTotalMenuPrice()));
    }

    public void toggleHighlight(boolean toggle, TextView txt){
        if(toggle == true){
            txt.setTextColor(Color.RED);
        }else{
            txt.setTextColor(Color.BLACK);
        }
    }
}