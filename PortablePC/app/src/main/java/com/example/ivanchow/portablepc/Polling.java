package com.example.ivanchow.portablepc;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.view.View.OnClickListener;




/**
 * Created by Tyler on 2018-01-04.
 */

public class Polling extends FragmentActivity{
    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polls);
        mLayout = (LinearLayout) findViewById(R.id.linearlayout);
        mEditText = (EditText) findViewById(R.id.pollText);
        mButton = (Button) findViewById(R.id.Button);
        mButton.setOnClickListener(onClick());
        EditText textView = new EditText(this);
        textView.setText("New text");

    }

    private OnClickListener onClick() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayout.addView(createNewTextView(mEditText.getText().toString()));
            }
        };
    }

    private TextView createNewTextView(String text) {
        final LayoutParams lparams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        final EditText textView = new EditText(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    }

}
