package com.example.mvopo.dohba.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

//    private LinearLayout mHomeListLayout, mGuestListLayout;
    private ImageView mHomeDisable, mGuestDisable, mProceedBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_team_list, container, false);

        mLvHome = mView.findViewById(R.id.home_lv);
        mLvGuest = mView.findViewById(R.id.guest_lv);

//        mHomeListLayout = mView.findViewById(R.id.home_list_layout);
//        mGuestListLayout = mView.findViewById(R.id.guest_list_layout);
        mHomeDisable = mView.findViewById(R.id.home_disable);
        mGuestDisable = mView.findViewById(R.id.guest_disable);
        mProceedBtn = mView.findViewById(R.id.proceed_btn);

        mPresenter = new TeamListPresenter(this);

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

        mPresenter.setListClickListener(mLvHome);
    }

    @Override
    public void showGuestTeam(List<Player> guestPlayers) {
        mGuestAdapter = new ListAdapter(getContext(), R.layout.team_list_item, guestPlayers);
        mLvGuest.setAdapter(mGuestAdapter);
        mGuestAdapter.notifyDataSetChanged();

        mPresenter.setListClickListener(mLvGuest);
    }

    @Override
    public void showHomeTeamList() {
//        mHomeListLayout.setVisibility(View.VISIBLE);
        mHomeDisable.setVisibility(View.GONE);
    }

    @Override
    public void showGuestTeamList() {
//        mGuestListLayout.setVisibility(View.VISIBLE);
        mGuestDisable.setVisibility(View.GONE);
    }

    @Override
    public void hideHomeTeamList() {
//        mHomeListLayout.setVisibility(View.INVISIBLE);
        mHomeDisable.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideGuestTeamList() {
//        mGuestListLayout.setVisibility(View.INVISIBLE);
        mGuestDisable.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLimitMessage() {
        Toast.makeText(getContext(), "Maximum of 5 members per quarter.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProceedButton() {
        mProceedBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProceedButton() {
        mProceedBtn.setVisibility(View.GONE);
    }
}
