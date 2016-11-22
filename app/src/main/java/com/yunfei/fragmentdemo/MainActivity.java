package com.yunfei.fragmentdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yunfei.fragmentdemo.backstack.BackStackActivity;
import com.yunfei.fragmentdemo.dynamic.AddRemoveReplaceFragmentActivity;
import com.yunfei.fragmentdemo.dynamic.AttachDetachFragmentActivity;
import com.yunfei.fragmentdemo.dynamic.ShowHideFragmentActivity;
import com.yunfei.fragmentdemo.fragment_pager_adapter.FragmentPageAdapterActivity;
import com.yunfei.fragmentdemo.fragment_state_pager_adapter.FragmentStatePageAdapterActivity;
import com.yunfei.fragmentdemo.static_create.Static_Fragment_Activity;
import com.yunfei.fragmentdemo.tab_fragment.TabFragmentActivity;

import java.util.Arrays;

public class MainActivity extends ListActivity {

    private String[] titles = {
            "静态添加",
            "Add Remove Replace",
            "Show Hide",
            "Attach Detach",
            "Tab + Fragment",
            "添加到回退栈",
            "FragmentPageAdapter",
            "FragmentStatePageAdapter"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ArrayAdapter<String> mAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
                        Arrays.asList(titles));
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(Static_Fragment_Activity.class);
                break;
            case 1:
                startActivity(AddRemoveReplaceFragmentActivity.class);
                break;
            case 2:
                startActivity(ShowHideFragmentActivity.class);
                break;
            case 3:
                startActivity(AttachDetachFragmentActivity.class);
                break;
            case 4:
                startActivity(TabFragmentActivity.class);
                break;
            case 5:
                startActivity(BackStackActivity.class);
                break;
            case 6:
                startActivity(FragmentPageAdapterActivity.class);
                break;
            case 7:
                startActivity(FragmentStatePageAdapterActivity.class);
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        this.startActivity(new Intent(this, cls));
    }
}
