package com.dou361.jjdxm_demomvp.home.ui;

import android.os.Bundle;
import android.view.View;

import com.dou361.jjdxm_demomvp.R;
import com.dou361.jjdxm_demomvp.base.BaseActivity;
import com.dou361.jjdxm_demomvp.history.ui.HistoryActivity;
import com.dou361.jjdxm_demomvp.joke.ui.JokeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_history, R.id.btn_joke})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_history:
                startActivity(HistoryActivity.class);
                break;
            case R.id.btn_joke:
                startActivity(JokeActivity.class);
                break;
        }
    }

}
