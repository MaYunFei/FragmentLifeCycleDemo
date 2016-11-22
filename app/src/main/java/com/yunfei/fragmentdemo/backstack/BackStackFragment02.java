package com.yunfei.fragmentdemo.backstack;

import com.yunfei.fragmentdemo.R;

/**
 * Created by yunfei on 16/11/15.
 */

public class BackStackFragment02 extends BaseBackStackFragment {

  @Override protected String getName() {
    return "02";
  }

  @Override protected void onButtonClick() {
    getFragmentManager().beginTransaction()
        .replace(R.id.fl_content, new BackStackFragment03(),"03")
        .addToBackStack("02")
        .commit();
  }
}
