package com.secondary.must;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

public class CommentsViewPagerAdapter extends PagerAdapter {
    private String[] commentsList;
    private Context mContext;

    public CommentsViewPagerAdapter(String[] commentsList, Context mContext) {
        this.commentsList = commentsList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return commentsList.length;
    }

    @NonNull
    @Override
    public java.lang.Object instantiateItem(@NonNull ViewGroup container, int position) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.comment_card,container,false);

        CardView cardView = v.findViewById(R.id.commentCardView);
        TextView textView = v.findViewById(R.id.commentText);

        textView.setText(commentsList[position]);

        cardView.setBackgroundColor(Color.parseColor("#ffffff"));

        container.addView(cardView);
        return cardView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull java.lang.Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull java.lang.Object object) {
        container.removeView((RelativeLayout) object);
    }
}
