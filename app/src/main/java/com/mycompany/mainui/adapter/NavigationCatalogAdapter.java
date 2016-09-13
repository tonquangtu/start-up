package com.mycompany.mainui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.mycompany.mainui.fragment.FragmentNavigationCatalog;
import com.mycompany.mainui.R;
import com.mycompany.mainui.model.NavigationCatalogData;

/**
 * Created by Dell on 4/28/2016.
 */
public class NavigationCatalogAdapter extends ArrayAdapter<Integer> {

    Context context;
    int res;
    Integer [] icons;
    FragmentNavigationCatalog fragment;
    boolean isSelectedInit = true;
    Integer [] iconsChange = NavigationCatalogData.ICON_CATALOG_NO_OTHER;
    public NavigationCatalogAdapter(Context context, FragmentNavigationCatalog fragment,
                                    int resource, Integer[] icons) {

        super(context, resource, icons);

        this.context = context;
        this.icons = icons;
        this.res = resource;
        this.fragment = fragment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        Holder holder;
        if(convertView != null) {
            view = convertView;
            holder = (Holder) view.getTag();
            if(position != fragment.currentPos) {
                view.setBackgroundColor(context.getResources().getColor(R.color.grey_50));
                holder.loadIcon(icons[position]);
            }else {
                view.setBackgroundColor(context.getResources().getColor(R.color.blue_100));
                holder.loadIcon(iconsChange[position]);
            }
        }else {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(res, parent, false);
            holder = new Holder(view);
            holder.loadIcon(icons[position]);
            view.setTag(holder);
        }

        if(isSelectedInit && position == fragment.initPos) {
            view.setBackgroundColor(context.getResources().getColor(R.color.grey_50));
            holder.loadIcon(icons[position]);
            isSelectedInit = false;
        }
//        else if(position == fragment.oldPos) {
//            view.setBackgroundColor(context.getResources().getColor(R.color.blue_grey_200));
//        }


        return view;
    }

    public class Holder {

        ImageView imageIcon;
        public Holder(View v) {
            imageIcon = (ImageView)v.findViewById(R.id.navigation_catalog_image_view);
        }

        public void loadIcon(int idRes) {
//            LoadImageFromUrl.loadImageFromResourse(idRes, imageIcon, context);
            imageIcon.setImageResource(idRes);
        }
    }
}
