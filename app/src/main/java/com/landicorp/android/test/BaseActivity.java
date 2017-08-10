package com.landicorp.android.test;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by GdSun on 2017/8/10.
 */

public class BaseActivity extends Activity{

    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setEnabled(false);
        }
    };

    static final ButterKnife.Setter<View, Boolean> ENABLE = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(@NonNull View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
