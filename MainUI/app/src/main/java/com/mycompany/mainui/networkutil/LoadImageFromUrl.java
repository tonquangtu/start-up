package com.mycompany.mainui.networkutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.mycompany.mainui.R;
import com.squareup.picasso.Picasso;

import java.util.Random;

/**
 * Created by Dell on 4/10/2016.
 */
public class LoadImageFromUrl {

    public static final int [] IMAGE_PLACE_HODLER = {

            R.drawable.blue, R.drawable.blue1,
            R.drawable.green, R.drawable.brow,
            R.drawable.red, R.drawable.red3,
            R.drawable.blue3, R.drawable.green3,
    };

    public static final int[] IMAGE_PLACE_HOLDER2 = {
            R.drawable.place_holder,
            R.drawable.place_holder2,
            R.drawable.place_holder3
    };

    public static Random rand = new Random();
    public static void loadImageFromURL(String url,
                                        ImageView imageView, Context context) {

        int index = rand.nextInt(IMAGE_PLACE_HOLDER2.length);
        Picasso.with(context)
                .load(url)
                .placeholder(IMAGE_PLACE_HOLDER2[index])
                .into(imageView);
        System.out.println("url : " + url);

    }

    public static void loadImageFromResourse(int idRes,ImageView imageView, Context context) {
        Picasso.with(context)
                .load(idRes)
                .into(imageView);
    }

    public static void loadImageFromURLMulti(String url, ImageView imageView, Context context) {

        int index = rand.nextInt(IMAGE_PLACE_HODLER.length);

        Drawable d = context.getResources().getDrawable(IMAGE_PLACE_HODLER[index]);
        int h = d.getIntrinsicHeight();
        int w = d.getIntrinsicWidth();

        Picasso.with(context)
                .load(url)
                .resize(w,h)
                .centerCrop()
                .placeholder(IMAGE_PLACE_HODLER[index])
                .into(imageView);
        System.out.println("url : " + url);
    }


}
