package com.yunfei.fragmentdemo.static_create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseFragment;

/**
 * Created by yunfei on 16/11/6.
 */

public class Static_Fragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        //TODO 为什么是false ，分析inflater
        return inflater.inflate(R.layout.common_fragment,container,false);
    }
}
