package com.landicorp.android.test;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.landicorp.android.uistep.UIStepFactory;
import com.landicorp.android.uistep.UIStepView;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.textView1) TextView textView11;
    @BindView(R.id.textView2) TextView textView22;
    @BindString(R.string.text1) String text1;
    @BindString(R.string.text2) String text2;
    @BindColor(R.color.red) int red;
    @BindColor(R.color.blue) int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        UIStepView step1 = UIStepFactory.createSingleStep();
        textView11.setText(text1);
        textView11.setTextColor(red);
        textView22.setTextColor(blue);
        textView22.setText(text2);
    }

    @OnClick({R.id.button1, R.id.button2})
    void buttonClick(Button button) {
        switch (button.getId()) {
            case R.id.button1:
                ButterKnife.apply(button, DISABLE);
                toast("this is a button1");
                break;
            case R.id.button2:
                ButterKnife.apply(button, ENABLE, true);
                toast("this is a button2");
                break;
            default:
                break;
        }
    }

    @OnTextChanged(value = R.id.ed_input, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.e(TAG, "beforeTextChanged:" + s);
    }

    @OnTextChanged(value = R.id.ed_input, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.e(TAG, "onTextChanged:" + s);
    }

    @OnTextChanged(value = R.id.ed_input, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {
        Log.e(TAG, "afterTextChanged:" + s);
    }

}
