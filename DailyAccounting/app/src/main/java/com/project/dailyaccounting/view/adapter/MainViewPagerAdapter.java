package com.project.dailyaccounting.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.project.dailyaccounting.view.fragment.DailyAccountingFragment;
import com.project.dailyaccounting.view.fragment.FingerPrintsFragment;
import com.project.dailyaccounting.view.fragment.PersonalCenterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/16 0016.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragments;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment(){
        listFragments = new ArrayList<>();
        listFragments.add(DailyAccountingFragment.newInstance());
        listFragments.add(FingerPrintsFragment.newInstance());
        listFragments.add(PersonalCenterFragment.newInstance());
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }
}
