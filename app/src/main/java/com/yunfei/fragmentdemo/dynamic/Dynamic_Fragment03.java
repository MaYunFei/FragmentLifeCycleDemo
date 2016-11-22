package com.yunfei.fragmentdemo.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseFragment;

/**
 * Created by yunfei on 16/11/6.
 */

public class Dynamic_Fragment03 extends BaseFragment {
  public static Dynamic_Fragment03 getInstance() {
    return new Dynamic_Fragment03();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    log("onCreateView");
    EditText tv = (EditText) inflater.inflate(R.layout.common_fragment, container, false);
    tv.setText(getClass().getSimpleName());
    return tv;
  }
}
