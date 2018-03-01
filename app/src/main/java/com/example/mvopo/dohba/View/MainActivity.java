package com.example.mvopo.dohba.View;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.mvopo.dohba.R;
import com.example.mvopo.dohba.View.Fragments.TeamListFragment;

public class MainActivity extends AppCompatActivity{

    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new TeamListFragment()).commit();
    }
}
