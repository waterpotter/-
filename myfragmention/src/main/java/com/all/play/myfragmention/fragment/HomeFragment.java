package com.all.play.myfragmention.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 聪明一只哈 on 2018/4/26.
 * Time: 2018/4/26  14:55
 */

public class HomeFragment extends Fragment {

    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity= (Activity) context;


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
