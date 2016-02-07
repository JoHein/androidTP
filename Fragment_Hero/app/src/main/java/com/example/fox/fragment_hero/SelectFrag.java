package com.example.fox.fragment_hero;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.NumberPicker;

/**
 * Created by Fox on 06/02/2016.
 */
public class SelectFrag extends Fragment{

    private pickerListenner marcelpickerListenner;
    private int position;
    public interface pickerListenner {
        void onSelectPicker(String nameHero);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            marcelpickerListenner = (pickerListenner)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " you must implement");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.selectfrag_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Spinner
         */
        final String[] values = {"EarthShaker", "Crystal Maiden", "AM"};
        NumberPicker picker = (NumberPicker) view.findViewById(R.id.numberpicker);
        picker.setMinValue(0);
        picker.setMaxValue(values.length - 1);
        picker.setDisplayedValues(values);
        picker.setDescendantFocusability(picker.FOCUS_BLOCK_DESCENDANTS);
        picker.setWrapSelectorWheel(true);

        picker.setValue(position);

        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                position=newVal;

                marcelpickerListenner.onSelectPicker(values[newVal]);
            }
        });
    }
}
