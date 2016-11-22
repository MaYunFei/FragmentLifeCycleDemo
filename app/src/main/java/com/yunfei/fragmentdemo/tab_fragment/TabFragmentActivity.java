package com.yunfei.fragmentdemo.tab_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseActivity;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment01;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment02;
import com.yunfei.fragmentdemo.dynamic.Dynamic_Fragment03;

/**
 * Created by yunfei on 16/11/15.
 */

public class TabFragmentActivity extends BaseActivity implements View.OnClickListener {
  private Dynamic_Fragment01 dynamic_fragment01;
  private Dynamic_Fragment02 dynamic_fragment02;
  private Dynamic_Fragment03 dynamic_fragment03;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tab_fragment_activity);
    initView();
  }

  private void initView() {
    findViewById(R.id.tv_01).setOnClickListener(this);
    findViewById(R.id.tv_02).setOnClickListener(this);
    findViewById(R.id.tv_03).setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    switch (v.getId()) {
      case R.id.tv_01:
        if (dynamic_fragment01 == null) {
          dynamic_fragment01 = Dynamic_Fragment01.getInstance();
        }
        transaction.replace(R.id.fl_content, dynamic_fragment01);
        break;
      case R.id.tv_02:
        if (dynamic_fragment02 == null) {
          dynamic_fragment02 = Dynamic_Fragment02.getInstance();
        }
        transaction.replace(R.id.fl_content, dynamic_fragment02);
        break;
      case R.id.tv_03:
        if (dynamic_fragment03 == null) {
          dynamic_fragment03 = Dynamic_Fragment03.getInstance();
        }
        transaction.replace(R.id.fl_content, dynamic_fragment03);
        break;
    }
    transaction.commit();
  }
}
