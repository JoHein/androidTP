package com.example.fox.fragment_hero;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.PageViewer;

public class MainActivity extends AppCompatActivity implements SelectFrag.pickerListenner {
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.home_tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_heroes));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_items));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewpager = (ViewPager) findViewById(R.id.home_viewPager);
        PageViewer adapter = new PageViewer(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.getAdapter().notifyDataSetChanged();

                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onSelectPicker(String nameHero) {
        PageViewer adapter = (PageViewer)viewpager.getAdapter();
        HeroFrag fragment = (HeroFrag) adapter.getItem(1);
        fragment.setHeroName(nameHero);

    }
}
