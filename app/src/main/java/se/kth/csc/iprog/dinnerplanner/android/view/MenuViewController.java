package se.kth.csc.iprog.dinnerplanner.android.view;

import android.text.Editable;
import android.text.TextWatcher;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

    public class MenuViewController implements TextWatcher {
        MenuView view;
        DinnerModel model;

        public MenuViewController(DinnerModel model, MenuView view) {
            this.model = model;
            this.view = view;

            //listeners
            this.view.guests.addTextChangedListener(this);
        }

        @Override
        public void afterTextChanged(Editable s) {
            int guests = 0;
            try {
                guests = Integer.parseInt(String.valueOf(s));
                model.setNumberOfGuests(guests);
                view.update(model, view.guests);
            } catch (NumberFormatException e) {
                return;
            } finally{

            }

        }



        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    }
