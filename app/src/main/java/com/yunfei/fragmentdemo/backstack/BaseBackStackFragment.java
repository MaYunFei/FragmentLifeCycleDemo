package com.yunfei.fragmentdemo.backstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yunfei.fragmentdemo.R;
import com.yunfei.fragmentdemo.base.BaseFragment;

/**
 * Created by yunfei on 16/11/15.
 */

public abstract class BaseBackStackFragment extends BaseFragment implements View.OnClickListener {


  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    log("onCreateView");
    View rootView = inflater.inflate(R.layout.back_stack_fragment, container, false);

    return rootView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.button).setOnClickListener(this);
    ((TextView) view.findViewById(R.id.textview)).setText(getName());
  }

  protected abstract String getName();

  @Override public void onClick(View v) {
    onButtonClick();
  }

  protected abstract void onButtonClick();
}
