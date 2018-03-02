package com.example.mvopo.dohba.Presenter;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.mvopo.dohba.Interface.TeamListContract;
import com.example.mvopo.dohba.Model.Constants;
import com.example.mvopo.dohba.Model.Player;
import com.example.mvopo.dohba.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvopo on 2/28/2018.
 */

public class TeamListPresenter implements TeamListContract.teamListAction{

    private TeamListContract.teamListView mView;
    private int mSelectedItemCount = 0;

    List<Player> homePlayers = new ArrayList<>();
    List<Player> guestPlayers = new ArrayList<>();

    public TeamListPresenter(TeamListContract.teamListView teamListView){
        mView = teamListView;

        //Temp values for testing
        //Should be in TeamListContract.teamListAction methods.
        homePlayers.add(new Player("0", "M. Opo", "00", "SG"));
        homePlayers.add(new Player("1", "J. Lomocso", "01", "SF"));
        homePlayers.add(new Player("2", "A. Pangcatan", "02", "C"));
        homePlayers.add(new Player("3", "R. Tayong", "03", "PG"));
        homePlayers.add(new Player("4", "I. Manugas", "04", "PF"));
        homePlayers.add(new Player("10", "S. Sample", "10", "PF"));

        guestPlayers.add(new Player("5", "C. Von", "05", "SG"));
        guestPlayers.add(new Player("6", "J. Laniba", "06", "SF"));
        guestPlayers.add(new Player("7", "E. Estoque", "07", "C"));
        guestPlayers.add(new Player("8", "J. Gonzales", "08", "PG"));
        guestPlayers.add(new Player("9", "R. Sugabo", "09", "PF"));
        guestPlayers.add(new Player("11", "X. Xample", "11", "PF"));
    }


    @Override
    public void loadTeam(Constants.TeamListRequest request) {
        switch (request){
            case BOTH:
                mView.showHomeTeam(homePlayers);
                mView.showGuestTeam(guestPlayers);
                break;
            case HOME:
                mView.showHomeTeam(homePlayers);
                break;
            case GUEST:
                mView.showGuestTeam(guestPlayers);
                break;
        }
    }

    @Override
    public void setListClickListener(final ListView listView) {
        final int id = listView.getId();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox cbSelector = view.findViewById(R.id.player_name);

                if(mSelectedItemCount < 5 || cbSelector.isChecked()) {
                    cbSelector.setChecked(!cbSelector.isChecked());

                    if (cbSelector.isChecked()) mSelectedItemCount++;
                    else mSelectedItemCount--;

                    mView.hideProceedButton();

                    switch (mSelectedItemCount) {
                        case 0:
                            mView.showHomeTeamList();
                            mView.showGuestTeamList();
                            break;
                        case 1:
                            if (id == R.id.home_lv) mView.hideGuestTeamList();
                            else mView.hideHomeTeamList();
                            break;
                        case 5:
                            mView.showProceedButton();
                            break;
                    }
                }else{
                    mView.showLimitMessage();
                }
            }
        });
    }
}
