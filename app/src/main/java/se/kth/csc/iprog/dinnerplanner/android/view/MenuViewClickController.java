package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class MenuViewClickController implements View.OnClickListener, View.OnLongClickListener {
    MenuView view;
    DinnerModel model;



    public MenuViewClickController(DinnerModel model, MenuView view) {
        this.model = model;
        this.view = view;

        //listeners
        view.imgStarter1.setOnClickListener(this);
        view.imgStarter2.setOnClickListener(this);
        view.imgStarter3.setOnClickListener(this);
        view.imgMain1.setOnClickListener(this);
        view.imgDessert1.setOnClickListener(this);

        view.imgStarter3.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == view.imgStarter3){
            //add to model
            this.model.selectDish(model.toast);
            view.updateCost();
            //highlight
            view.toggleHighlight(true, view.txtStarter3);

        } else if (v == view.imgMain1){
            //add to model
            this.model.selectDish(model.meatballs);
            view.updateCost();
            //highlight
            view.toggleHighlight(true, view.txtMain1);

        } else if (v == view.imgDessert1){
            //add to model
            this.model.selectDish(model.icecream);
            view.updateCost();
            //highlight
            view.toggleHighlight(true, view.txtDessert1);
        }


    }
    @Override
    public boolean onLongClick(View v) {
/*
        if (v == view.imgStarter3){
            view.showPopup(model.toast);

        } else if (v == view.imgMain1){
            //add to model
            this.model.selectDish(model.meatballs);
            view.updateCost();
            //highlight
            view.toggleHighlight(true, view.txtMain1);

        } else if (v == view.imgDessert1){
            //add to model
            this.model.selectDish(model.icecream);
            view.updateCost();
            //highlight
            view.toggleHighlight(true, view.txtDessert1);

        }

        return true;*/
        return true;
    }



}
