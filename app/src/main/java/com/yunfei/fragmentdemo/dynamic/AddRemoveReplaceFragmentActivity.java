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

public class AddRemoveReplaceFragmentActivity extends BaseActivity {
  private FragmentManager fragmentManager;
  private Dynamic_Fragment01 fragment01;
  private Dynamic_Fragment02 fragment02;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_remove_replace_fragment_activity);
    fragmentManager = getSupportFragmentManager();
    fragment01 = Dynamic_Fragment01.getInstance();
    fragment02 = Dynamic_Fragment02.getInstance();

    setButtonListener(R.id.btn_add, new View.OnClickListener() {
      @Override public void onClick(View v) {

        fragmentManager.beginTransaction().add(R.id.fl_content, fragment01).commit();
      }
    });

    setButtonListener(R.id.btn_remove, new View.OnClickListener() {
      @Override public void onClick(View v) {
        fragmentManager.beginTransaction().remove(fragment01).commit();
      }
    });
    setButtonListener(R.id.btn_replace, new View.OnClickListener() {
      @Override public void onClick(View v) {
        fragmentManager.beginTransaction().replace(R.id.fl_content, fragment02).commit();
      }
    });

    setButtonListener(R.id.btn_gc, new View.OnClickListener() {
      @Override public void onClick(View v) {
        System.gc();
      }
    });
  }

  private void setButtonListener(int btn_add_1, View.OnClickListener listener) {
    findViewById(btn_add_1).setOnClickListener(listener);
  }
}
