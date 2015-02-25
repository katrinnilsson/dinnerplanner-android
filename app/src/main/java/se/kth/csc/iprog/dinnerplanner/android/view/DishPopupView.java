package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class DishPopupView extends RelativeLayout {

    Dish dish;
    Context context;
    DinnerModel model;

    public DishPopupView (Context context, Dish longPressed, DinnerModel model){
        super(context);

        this.dish = longPressed;
        this.context = context;
        this.model = model;

        // inflate the layout
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_dish_popup, this, true);

        // set the longPressed dish caption
        TextView dishCaption = (TextView) this.findViewById(R.id.dishName);
        dishCaption.setText(String.valueOf(this.dish.getName()));

        //img
        ImageView img = (ImageView) this.findViewById(R.id.imgPopup);
        img.setImageResource(DinnerPlannerApplication.getImageResId(context, this.dish.getImage()));

        //cost per person
        TextView dishPricePerPerson = (TextView) this.findViewById(R.id.txtCostPerPerson);
        float price = dish.getPrice();
        dishPricePerPerson.setText(String.valueOf(price));

        //total cost
        TextView ttlCost = (TextView) this.findViewById(R.id.txtCost);
        float totalCost = model.getNumberOfGuests() * price;
        ttlCost.setText(String.valueOf(totalCost));


    }


}
