package com.project.dailyaccounting;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.dailyaccounting.view.adapter.MainViewPagerAdapter;


public class DailyAccountingMainActivity extends AppCompatActivity {

    private TextView tvHeaderCenter;

    private ViewPager vpMainCenter;

    private TextView tvBottomDailyAccounting;
    private TextView tvBottomFingerPrints;
    private TextView tvBottomPersonalCenter;

    private MainViewPagerAdapter mAdapter;
    private String[] headerCenterText = {"日常记账","今日指纹","个人中心"};
    private int[] tvButtomID = {R.id.tv_buttom_daily_accounting, R.id.tv_buttom_finger_prints, R.id.tv_buttom_personal_center};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_accounting_main);

        initView();
        bindListener();
    }

    private void initView(){

        // 头部；
        this.tvHeaderCenter = (TextView) findViewById(R.id.tv_header_center);
        this.tvHeaderCenter.setText(headerCenterText[0]);

        // 底部按钮；
        this.tvBottomDailyAccounting = (TextView) findViewById(R.id.tv_buttom_daily_accounting);
        this.tvBottomFingerPrints = (TextView) findViewById(R.id.tv_buttom_finger_prints);
        this.tvBottomPersonalCenter = (TextView) findViewById(R.id.tv_buttom_personal_center);
        this.tvBottomDailyAccounting.setOnClickListener(myClickListener);
        this.tvBottomFingerPrints.setOnClickListener(myClickListener);
        this.tvBottomPersonalCenter.setOnClickListener(myClickListener);

        // 中间部分；
        this.vpMainCenter = (ViewPager) findViewById(R.id.vp_main_content);
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        this.vpMainCenter.setAdapter(mAdapter);
        this.vpMainCenter.setOffscreenPageLimit(3);
        this.vpMainCenter.setCurrentItem(0);
        showViewFromID(tvButtomID[0]);
    }

    private void bindListener(){

        this.vpMainCenter.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showViewFromID(tvButtomID[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showViewFromID(v.getId());
        }
    };

    private void showViewFromID(int viewID){

        clearSelection();

        switch (viewID){
            case R.id.tv_buttom_daily_accounting:
                tvHeaderCenter.setText(headerCenterText[0]);
                vpMainCenter.setCurrentItem(0);
                tvBottomDailyAccounting.setBackgroundColor(getResources().getColor(R.color.main_btn_select));
                tvBottomDailyAccounting.setTextColor(getResources().getColor(R.color.text_white));
                break;
            case R.id.tv_buttom_finger_prints:
                tvHeaderCenter.setText(headerCenterText[1]);
                vpMainCenter.setCurrentItem(1);
                tvBottomFingerPrints.setBackgroundColor(getResources().getColor(R.color.main_btn_select));
                tvBottomFingerPrints.setTextColor(getResources().getColor(R.color.text_white));
                break;
            case R.id.tv_buttom_personal_center:
                tvHeaderCenter.setText(headerCenterText[2]);
                vpMainCenter.setCurrentItem(2);
                tvBottomPersonalCenter.setBackgroundColor(getResources().getColor(R.color.main_btn_select));
                tvBottomPersonalCenter.setTextColor(getResources().getColor(R.color.text_white));
                break;
            default:

        }
    }

    private void clearSelection(){

        this.tvBottomDailyAccounting.setBackgroundColor(getResources().getColor(R.color.main_btn_unselect));
        this.tvBottomFingerPrints.setBackgroundColor(getResources().getColor(R.color.main_btn_unselect));
        this.tvBottomPersonalCenter.setBackgroundColor(getResources().getColor(R.color.main_btn_unselect));

        this.tvBottomDailyAccounting.setTextColor(getResources().getColor(R.color.text_gray));
        this.tvBottomFingerPrints.setTextColor(getResources().getColor(R.color.text_gray));
        this.tvBottomPersonalCenter.setTextColor(getResources().getColor(R.color.text_gray));
    }

}
