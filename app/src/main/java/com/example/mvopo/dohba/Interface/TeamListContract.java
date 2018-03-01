package com.example.mvopo.dohba.Interface;

import android.widget.ListView;

import com.example.mvopo.dohba.Model.Constants;
import com.example.mvopo.dohba.Model.Player;

import java.util.List;

/**
 * Created by mvopo on 2/28/2018.
 */

public class TeamListContract {

    public interface teamListView{
        void showHomeTeam(List<Player> homePlayers);
        void showGuestTeam(List<Player> guestPlayers);

        void showHomeTeamList();
        void showGuestTeamList();
        void hideHomeTeamList();
        void hideGuestTeamList();

        void showLimitMessage();
        void showProceedButton();
        void hideProceedButton();
    }

    public interface teamListAction{
        void loadTeam(Constants.TeamListRequest request);
        void setListClickListener(ListView listView);
    }
}
