package com.secondary.must;

public class startAnimationTrash {


//
//    //TODO : Way to go
//    private void startAnimation(FlipCardAnimation animation, final View llyt_item, final TextView tv_item, final TextView tv_price_item, final ImageView iv_pro, int degree) {
//        if (animation != null) {
//            animation.setCanContentChange();
//            llyt_item.startAnimation(animation);
//        } else {
//            int width = llyt_item.getWidth() / 2;
//            int height = llyt_item.getHeight() / 2;
//            animation = new FlipCardAnimation(0, degree, width, height);
//            animation.setInterpolator(new AnticipateOvershootInterpolator());
//            animation.setDuration(1000);
//            animation.setFillAfter(false);
//            animation.setRepeatCount(0);
//            animation.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//                }
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                }
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//                    ((FlipCardAnimation)animation).setCanContentChange();
//                }
//            });
//            animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
//                @Override
//                public void contentChange() {
//                    if (iv_pro == null) {
//                        return;
//                    }
//                    if (num >= 3) {
//                        num = 0;
//                    }
//                    iv_pro.setBackgroundResource(DRAWABLE[num]);
//                    tv_item.setText("￥" + new Random().nextInt(500));
//
//                    if (num == 0) {
//                        tv_price_item.setText("Discount");
//                    } else if (num == 1) {
//                        tv_price_item.setText("Price");
//                    } else if (num == 2) {
//                        tv_price_item.setText("Cost");
//                    }
//                    num++;
//
//                    ViewGroup.LayoutParams params = llyt_item.getLayoutParams();
//                    if (params.height == 160){
//                        Log.d("DaTuM", "contentChange: true currect" + params.height);
//                        params.height = 300;
//                        llyt_item.setLayoutParams(params);
//                    }else{
//                        Log.d("DaTuM", "contentChange: false currect" + params.height);
//                        params.height = 160;
//                        llyt_item.setLayoutParams(params);
//                    }
//
//                }
//            });
//            llyt_item.startAnimation(animation);
//        }
//    }
}
