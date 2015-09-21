package my.example.mayank.alphabets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by mayank on 13/9/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence title[];
    int numOfTabs;
    public ViewPagerAdapter(FragmentManager fm,CharSequence mtitle[], int mnumOfTabs) {
        super(fm);
        this.title=mtitle;
        this.numOfTabs=mnumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            Tab1 t1=new Tab1();
            return t1;
        }else{
            Tab2 t2=new Tab2();
            return t2;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
