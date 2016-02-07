package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fox.fragment_hero.HeroFrag;
import com.example.fox.fragment_hero.SelectFrag;

/**
 * Created by Fox on 06/02/2016.
 */
public class PageViewer extends FragmentStatePagerAdapter {

    private int nbTabs;
    private SelectFrag f_SelectFrag;
    private HeroFrag f_HeroFrag;

    public PageViewer(FragmentManager fm) {
        super(fm);
        nbTabs = 2;
        this.f_SelectFrag = new SelectFrag();
        this.f_HeroFrag = new HeroFrag();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return f_SelectFrag;
            case 1:
                return f_HeroFrag;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nbTabs;
    }

    @Override
    public int getItemPosition(Object obj) {
        return POSITION_NONE;
    }
}
