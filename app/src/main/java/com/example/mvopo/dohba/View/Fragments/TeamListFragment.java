package com.example.mvopo.dohba.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvopo.dohba.Helper.ListAdapter;
import com.example.mvopo.dohba.Interface.TeamListContract;
import com.example.mvopo.dohba.Model.Constants;
import com.example.mvopo.dohba.Model.Player;
import com.example.mvopo.dohba.Presenter.TeamListPresenter;
import com.example.mvopo.dohba.R;

import java.util.List;

/**
 * Created by mvopo on 2/28/2018.
 */

public class TeamListFragment extends Fragment implements TeamListContract.teamListView{

    private View mView;
    private ListView mLvHome, mLvGuest;
    private ListAdapter mHomeAdapter, mGuestAdapter;
    private TeamListContract.teamListAction mPresenter;

    private LinearLayout mHomeListLayout, mGuestListLayout;
    private ImageView mProceedBtnHome, mProceedBtnGuest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_team_list, container, false);

        mLvHome = mView.findViewById(R.id.home_lv);
        mLvGuest = mView.findViewById(R.id.guest_lv);

        mHomeListLayout = mView.findViewById(R.id.home_list_layout);
        mGuestListLayout = mView.findViewById(R.id.guest_list_layout);
        mProceedBtnHome = mView.findViewById(R.id.proceed_btn_home);
        mProceedBtnGuest = mView.findViewById(R.id.proceed_btn_guest);

        mPresenter = new TeamListPresenter(this);


        mPresenter.setListClickListener(mLvHome);
        mPresenter.setListClickListener(mLvGuest);

        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadTeam(Constants.TeamListRequest.BOTH);
    }

    @Override
    public void showHomeTeam(List<Player> homePlayers) {
        mHomeAdapter = new ListAdapter(getContext(), R.layout.team_list_item, homePlayers);
        mLvHome.setAdapter(mHomeAdapter);
        mHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showGuestTeam(List<Player> guestPlayers) {
        mGuestAdapter = new ListAdapter(getContext(), R.layout.team_list_item, guestPlayers);
        mLvGuest.setAdapter(mGuestAdapter);
        mGuestAdapter.notifyDataSetChanged();
    }

    @Override
    public void showHomeTeamList() {
        mHomeListLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showGuestTeamList() {
        mGuestListLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideHomeTeamList() {
        mHomeListLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideGuestTeamList() {
        mGuestListLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLimitMessage() {
        Toast.makeText(getContext(), "Maximum of 5 members per quarter.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProceedButton() {
        mProceedBtnHome.setVisibility(View.VISIBLE);
        mProceedBtnGuest.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProceedButton() {
        mProceedBtnHome.setVisibility(View.GONE);
        mProceedBtnGuest.setVisibility(View.GONE);
    }
}
