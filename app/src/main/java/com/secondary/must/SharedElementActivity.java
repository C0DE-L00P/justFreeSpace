package com.secondary.must;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SharedElementActivity extends Activity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        Glide.with(this).load(R.drawable.suit).into((ImageView) findViewById(R.id.shared_img));

        ImageButton orderBtn,admireBtn,commentsBtn,writeBtn;

        orderBtn = findViewById(R.id.orderBtn);
        admireBtn = findViewById(R.id.admireBtn);
        commentsBtn = findViewById(R.id.commentsBtn);
        writeBtn = findViewById(R.id.writeCommentBtn);

        LinearLayout ll = findViewById(R.id.bottomSheetLayout);
        bottomSheetBehavior = BottomSheetBehavior.from(ll);


        orderBtn.setOnClickListener(this);
        admireBtn.setOnClickListener(this);
        commentsBtn.setOnClickListener(this);
        writeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admireBtn:
                break;
            case R.id.orderBtn:
                clearBackground(v);
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    v.setBackgroundColor(getResources().getColor(R.color.gray_Gray));

                    v.getRootView().findViewById(R.id.comment_card).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.text_comment).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.comment_edit_text).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.order_layout).setVisibility(View.VISIBLE);
                    v.getRootView().findViewById(R.id.submitBtn).setVisibility(View.VISIBLE);
                }

                break;
            case R.id.commentsBtn:
                clearBackground(v);
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.gray_Gray));
                    v.getRootView().findViewById(R.id.comment_card).setVisibility(View.VISIBLE);
                    v.getRootView().findViewById(R.id.text_comment).setVisibility(View.VISIBLE);
                    v.getRootView().findViewById(R.id.comment_edit_text).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.order_layout).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.submitBtn).setVisibility(View.GONE);

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.writeCommentBtn:
                clearBackground(v);

                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    v.setBackgroundColor(getResources().getColor(R.color.gray_Gray));

                    v.getRootView().findViewById(R.id.comment_card).setVisibility(View.VISIBLE);
                    v.getRootView().findViewById(R.id.text_comment).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.comment_edit_text).setVisibility(View.VISIBLE);
                    v.getRootView().findViewById(R.id.order_layout).setVisibility(View.GONE);
                    v.getRootView().findViewById(R.id.submitBtn).setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void clearBackground(View v){
        v.getRootView().findViewById(R.id.writeCommentBtn).setBackgroundColor(getResources().getColor(R.color.White_Gray));
        v.getRootView().findViewById(R.id.commentsBtn).setBackgroundColor(getResources().getColor(R.color.White_Gray));
        v.getRootView().findViewById(R.id.orderBtn).setBackgroundColor(getResources().getColor(R.color.White_Gray));
        v.getRootView().findViewById(R.id.admireBtn).setBackgroundColor(getResources().getColor(R.color.White_Gray));
    }


}
