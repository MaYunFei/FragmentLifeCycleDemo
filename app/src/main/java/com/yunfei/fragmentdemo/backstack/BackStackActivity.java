package com.yunfei.fragmentdemo.backstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseActivity;

/**
 * Created by yunfei on 16/11/15.
 */

public class BackStackActivity extends BaseActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.back_stack_activity);

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fl_content, new BackStackFragment01(), "01")
        .commit();
  }
}
