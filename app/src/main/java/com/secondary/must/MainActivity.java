package com.secondary.must;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FlipCardAnimation animation_item1;

    CustomAdapter ca;
    List<Object> list = new ArrayList<>();
    RecyclerView rv;

    ImageView iv_pro,iv_pro_item1;

    public static final int[] DRAWABLE = {R.drawable.ic_card_giftcard_white_48dp,R.drawable.ic_card_membership_white_48dp,R.drawable.ic_markunread_white_48dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_layout);

        list.add(new Object("Name1","Number1"));
        list.add(new Object("Name2","Number2"));
        list.add(new Object("Name3","Number3"));
        list.add(new Object("Name4","Number4"));
        list.add(new Object("Name5","Number5"));

        ca = new CustomAdapter(MainActivity.this,list,animation_item1);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setAdapter(ca);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        iv_pro = findViewById(R.id.iv_pro);
        iv_pro_item1 = findViewById(R.id.iv_pro_item1);
    }
}


class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ObjectViewHolder>{

    private Context mContext;
    private List<Object> list;
    private FlipCardAnimation animation_item1;
    private int num= 0;

    CustomAdapter(Context mContext, List<Object> list,
                  FlipCardAnimation animation_item1) {
        this.mContext = mContext;
        this.list = list;
        this.animation_item1 = animation_item1;
    }

    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.checkout_element,parent,false);
        return new ObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ObjectViewHolder holder, int position) {
        holder.tv_item1.setText(list.get(position).getName());
        holder.tv_price_item1.setText(list.get(position).getNumber());

        final ViewGroup.LayoutParams params = holder.llyt_item1.getLayoutParams();
        holder.llyt_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (params.height == 160){
                    startAnimation(animation_item1, holder.llyt_item1, holder.tv_item1, holder.tv_price_item1, holder.iv_pro_item1, -180);
                }else{
                    startAnimation(animation_item1, holder.llyt_item1, holder.tv_item1, holder.tv_price_item1, holder.iv_pro_item1,180);
                }
            }
        });
    }

    private void startAnimation(FlipCardAnimation animation, final View llyt_item, final TextView tv_item, final TextView tv_price_item, final ImageView iv_pro, int degree) {
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
                    iv_pro.setBackgroundResource(MainActivity.DRAWABLE[num]);
                    tv_item.setText("￥" + new Random().nextInt(500));

                    if (num == 0) {
                        tv_price_item.setText("Discount");
                    } else if (num == 1) {
                        tv_price_item.setText("Price");
                    } else if (num == 2) {
                        tv_price_item.setText("Cost");
                    }
                    num++;

                    ViewGroup.LayoutParams params = llyt_item.getLayoutParams();
                    if (params.height == 160){
                        Log.d("DaTuM", "contentChange: true currect" + params.height);
                        params.height = 300;
                        llyt_item.setLayoutParams(params);
                    }else{
                        Log.d("DaTuM", "contentChange: false currect" + params.height);
                        params.height = 160;
                        llyt_item.setLayoutParams(params);
                    }

                }
            });
            llyt_item.startAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ObjectViewHolder extends RecyclerView.ViewHolder{

        TextView tv_item1,tv_price_item1;
        LinearLayout llyt_item1;
        ImageView iv_pro_item1;

        ObjectViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_item1 = itemView.findViewById(R.id.tv_price_item1);
            tv_price_item1 = itemView.findViewById(R.id.tv_item1);
            iv_pro_item1 = itemView.findViewById(R.id.iv_pro_item1);
            llyt_item1 = itemView.findViewById(R.id.llyt_item1);
        }
    }
}

class Object{
    private String name;
    private String number;

    Object(String name, String number) {
        this.name = name;
        this.number = number;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
