package postal.fisan.com.postal.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import postal.fisan.com.postal.fragment.HomeFragment;
import postal.fisan.com.postal.fragment.PerfilFragment;

public class AdapterFragments extends FragmentStatePagerAdapter{

    int nTabs;

    public AdapterFragments(FragmentManager fm, int nTabs){
        super(fm);
        this.nTabs = nTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                PerfilFragment perfilFragment = new PerfilFragment();
                return perfilFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nTabs;
    }
}
