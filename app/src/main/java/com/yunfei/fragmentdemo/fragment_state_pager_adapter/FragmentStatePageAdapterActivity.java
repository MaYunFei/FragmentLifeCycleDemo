package com.yunfei.fragmentdemo.fragment_state_pager_adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseActivity;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment01;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment02;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2016/11/22.
 */

public class FragmentStatePageAdapterActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_adapter_activity);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_content);

        List<Fragment> list = new ArrayList<Fragment>();
        list.add(Dynamic_Fragment01.getInstance());
        list.add(Dynamic_Fragment02.getInstance());
        list.add(Dynamic_Fragment03.getInstance());
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager(), list));


    }

    private static class MyPageAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> list;

        public MyPageAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
