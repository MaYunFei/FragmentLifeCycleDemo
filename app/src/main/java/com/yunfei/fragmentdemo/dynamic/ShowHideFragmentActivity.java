package com.yunfei.fragmentdemo.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseActivity;

/**
 * Created by yunfei on 16/11/7.
 */

public class ShowHideFragmentActivity extends BaseActivity {
  private FragmentManager fragmentManager;
  private Dynamic_Fragment01 fragment01;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.show_hide_fragment_activity);
    fragmentManager = getSupportFragmentManager();
    fragment01 = Dynamic_Fragment01.getInstance();

    fragmentManager.beginTransaction().add(R.id.fl_content, fragment01).commit();

    setButtonListener(R.id.btn_show, new View.OnClickListener() {
      @Override public void onClick(View v) {

        fragmentManager.beginTransaction().show(fragment01).commit();
      }
    });

    setButtonListener(R.id.btn_hide, new View.OnClickListener() {
      @Override public void onClick(View v) {
        fragmentManager.beginTransaction().hide(fragment01).commit();
      }
    });
  }

  private void setButtonListener(int btn_add_1, View.OnClickListener listener) {
    findViewById(btn_add_1).setOnClickListener(listener);
  }
}
