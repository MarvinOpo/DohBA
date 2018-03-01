package com.example.mvopo.dohba.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.mvopo.dohba.Model.Player;
import com.example.mvopo.dohba.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mvopo on 2/28/2018.
 */

public class ListAdapter extends ArrayAdapter {
    Context mContext;
    int layoutId;
    List<Player> players;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        mContext = context;
        layoutId = resource;
        players = objects;
    }

    @Override
    public int getCount() {
        int size = 0;

        if(players!=null) size = players.size();

        return size;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);

        if(layoutId == R.layout.team_list_item) {
            CircleImageView civ = convertView.findViewById(R.id.player_image);
            final CheckBox name = convertView.findViewById(R.id.player_name);

            name.setText(players.get(position).getName());
        }
        return convertView;
    }
}
