package de.kularts.bertee.Controller;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

import de.kularts.bertee.R;
import de.kularts.bertee.View.FuelExpensesFragment;
import de.kularts.bertee.View.WorkTimeFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static SectionPagerAdapter instance;
    private Activity activity;
    private List<Fragment> sections = new ArrayList<>();

    private SectionPagerAdapter(FragmentManager fm, Activity act) {
        super(fm);
        this.activity = act;
        this.setSections();
    }

    // ------------------- SINGLETON  -------------------------------------

    public static void initInstance(FragmentManager fm, Activity activity){
        if(instance == null){
            instance = new SectionPagerAdapter(fm, activity);
        }
    }

    public static SectionPagerAdapter getInstance(){
        return instance;
    }

    // --------------------------------------------------------------------

    public void setSections(){

        this.sections.add(new WorkTimeFragment());
        this.sections.add(new FuelExpensesFragment());
    }

    // --------------------------------------------------------------------
    @Override
    public Fragment getItem(int position) {
        return this.sections.get(position);
    }

    @Override
    public int getCount() {
        return this.sections.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return this.activity.getString(R.string.title_section_worktime);
            case 1:
                return this.activity.getString(R.string.title_section_fuelexpenses);
            case 2:
                return this.activity.getString(R.string.title_section_catering);
        }
        return null;
    }
}