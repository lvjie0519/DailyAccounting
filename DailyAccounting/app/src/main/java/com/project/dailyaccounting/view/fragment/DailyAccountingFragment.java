package com.project.dailyaccounting.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.dailyaccounting.R;


/**
 * 每日记账
 */
public class DailyAccountingFragment extends Fragment {

    public DailyAccountingFragment() {
        // Required empty public constructor
    }

    public static DailyAccountingFragment newInstance() {
        DailyAccountingFragment fragment = new DailyAccountingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_accounting, container, false);
        return view;
    }


}
