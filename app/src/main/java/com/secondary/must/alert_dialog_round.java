package com.secondary.must;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import net.cachapa.expandablelayout.ExpandableLayout;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class alert_dialog_round extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_main);
//
//        Fade fade = new Fade();
//        View decor = getWindow().getDecorView();
//        fade.excludeTarget(android.R.id.statusBarBackground,true);
//        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        final ImageView image = findViewById(R.id.shared_element_img);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alert_dialog_round.this,SharedElementActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(alert_dialog_round.this,image, ViewCompat.getTransitionName(image));
                startActivity(intent,options.toBundle());
            }
        });

        Log.d(TAG, "onCreate: why");

        final String[] comments = {"Amazing suit with good materials I really recommend it for anyone to buy","Don't bother buying too cheap looking","Delivery service is so slow","I had a great experience"};

        Button b = findViewById(R.id.showBtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final View vb =getLayoutInflater().inflate(R.layout.button_dialog_layout,null);

                Dialog d = new Dialog(new ContextThemeWrapper(alert_dialog_round.this, R.style.DialogSlideAnim));
                d.setContentView(R.layout.button_dialog_layout);
                Log.d(TAG, "onClick: should work");
//                d.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                d.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                /*Button b = d.findViewById(R.id.chnageBtn);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });*/
//                CardView cardView = d.findViewById(R.id.commentCardView);
                final ExpandableLayout comments_el = d.findViewById(R.id.comment_el);
                final ExpandableLayout writing_comment_el = d.findViewById(R.id.writeComment_el);
                ImageButton orderBtn = d.findViewById(R.id.orderBtn),
                        admireBtn = d.findViewById(R.id.admireBtn),
                        commentsBtn = d.findViewById(R.id.commentsBtn),
                        writeCommentBtn = d.findViewById(R.id.writeCommentBtn);
                CommentsViewPagerAdapter cvpa = new CommentsViewPagerAdapter(comments,alert_dialog_round.this);
                final ViewPager viewPager = d.findViewById(R.id.comments_view_pager);
                viewPager.setAdapter(cvpa);

                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()){
                            case R.id.orderBtn:
                                Log.d(TAG, "onClick: Order");
                                break;
                            case R.id.admireBtn:
                                Log.d(TAG, "onClick: Admire");
                                break;
                            case R.id.commentsBtn:
                                if (writing_comment_el.isExpanded())writing_comment_el.collapse();

                                if (comments_el.isExpanded()){
                                    comments_el.collapse();
                                }else{
                                    comments_el.expand();
                                }
                                break;
                            case R.id.writeCommentBtn:
                                if (comments_el.isExpanded())comments_el.collapse();

                                if (writing_comment_el.isExpanded()){
                                    writing_comment_el.collapse();
                                }else{
                                    writing_comment_el.expand();
                                }
                                break;
                        }
                    }
                };
                admireBtn.setOnClickListener(listener);
                orderBtn.setOnClickListener(listener);
                commentsBtn.setOnClickListener(listener);
                writeCommentBtn.setOnClickListener(listener);


                d.show();
            }
        });
    }
}
