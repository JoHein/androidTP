package com.example.fox.fragment_hero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fox on 06/02/2016.
 */
public class HeroFrag extends Fragment{
    private String heroName;

    public void setHeroName(String heroName){
        this.heroName=heroName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.herofrag_layout, container,false);
        if(heroName != null) {
            ImageView imgview =(ImageView)view.findViewById(R.id.imageView1);
            TextView changeType = (TextView)view.findViewById(R.id.changetype);
            if (heroName == "EarthShaker") {
                imgview.setImageResource(R.drawable.earthshaker);
                changeType.setText(R.string.type_support);
            } else if (heroName == "Crystal Maiden") {
                imgview.setImageResource(R.drawable.crystalmaiden);
                changeType.setText(R.string.type_support);

            } else if (heroName == "AM") {
                imgview.setImageResource(R.drawable.am);
                changeType.setText(R.string.type_carry);
            }
        }
        return view;
    }


}
