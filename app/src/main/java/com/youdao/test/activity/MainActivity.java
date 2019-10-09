package com.youdao.test.activity;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.youdao.baselibrary.ui.dataBinding.mvp.MvpActivity;
import com.youdao.test.R;
import com.youdao.test.databinding.ActivityMainBinding;
import com.youdao.test.presenter.MainPresenter;
import com.youdao.test.view.MainView;

public class MainActivity extends MvpActivity<MainPresenter, ActivityMainBinding> implements MainView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewDataBinding().dictRecyclerview.setLayoutManager(new GridLayoutManager(this, 4));
        getViewDataBinding().dictRecyclerview.setAdapter(getMvpPresenter().getRecyclerViewAdapter());
        getMvpPresenter().initRecyclerViewData();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showResult() {

    }
}
