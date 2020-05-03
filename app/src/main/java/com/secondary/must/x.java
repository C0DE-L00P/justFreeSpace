package com.secondary.must;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import androidx.annotation.Nullable;

public class x extends Activity {

    FlipCardAnimation animation1;
    FlipCardAnimation animation;
    int num= 0;
    ImageView iv_pro;

    private static final int[] DRAWABLE = {R.drawable.ic_card_giftcard_white_48dp,R.drawable.ic_card_membership_white_48dp,R.drawable.ic_markunread_white_48dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_rest_blocks);

        final LinearLayout llyt = findViewById(R.id.llyt);
        final View view_bg =  findViewById(R.id.view_bg);

        iv_pro = findViewById(R.id.iv_pro);

        llyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startAnimation(animation,llyt,iv_pro,180);
                startAnimation(animation1,view_bg,null,-180);
            }
        });
    }

    private void startAnimation(FlipCardAnimation animation, View llyt_item, final ImageView iv_pro, int degree) {
        if (animation != null) {
            animation.setCanContentChange();
            llyt_item.startAnimation(animation);
        } else {
            int width = llyt_item.getWidth() / 2;
            int height = llyt_item.getHeight() / 2;
            animation = new FlipCardAnimation(0, degree, width, height);
            animation.setInterpolator(new AnticipateOvershootInterpolator());
            animation.setDuration(1000);
            animation.setFillAfter(false);
            animation.setRepeatCount(0);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                    ((FlipCardAnimation)animation).setCanContentChange();
                }
            });
            animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
                @Override
                public void contentChange() {
                    if (iv_pro == null) {
                        return;
                    }
                    if (num >= 3) {
                        num = 0;
                    }
                    iv_pro.setBackgroundResource(DRAWABLE[num]);
//                    tv_item.setText("￥" + new Random().nextInt(500));

                    if (num == 0) {
//                        tv_price_item.setText("Discount");
                    } else if (num == 1) {
//                        tv_price_item.setText("Price");
                    } else if (num == 2) {
//                        tv_price_item.setText("Cost");
                    }
                    num++;
                }
            });
            llyt_item.startAnimation(animation);
        }
    }
}
