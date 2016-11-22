package com.yunfei.fragmentdemo.backstack;

import com.yunfei.fragmentdemo.R;

/**
 * Created by yunfei on 16/11/15.
 */

public class BackStackFragment01 extends BaseBackStackFragment {

  @Override protected String getName() {
    return "01";
  }

  // 不建议直接操作 fragment
  @Override protected void onButtonClick() {
    getFragmentManager().beginTransaction()
        .replace(R.id.fl_content, new BackStackFragment02(),"02")
        .addToBackStack("01")
        .commit();
  }
}
