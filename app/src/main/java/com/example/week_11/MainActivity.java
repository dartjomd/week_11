package com.example.week_11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.week_11.adapter.MainPagerAdapter;
import com.example.week_11.data.DataProvider;
import com.example.week_11.model.Match;
import com.example.week_11.model.Player;
import com.example.week_11.model.Team;
import com.example.week_11.repository.Repository;
import com.example.week_11.ui.SoccerListFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // repositories for data management
    private Repository<Team> teamRepo = new Repository<>();
    private Repository<Player> playerRepo = new Repository<>();
    private Repository<Match> matchRepo = new Repository<>();

    // fragments for each tab
    private SoccerListFragment<Team> teamsFragment;
    private SoccerListFragment<Player> playersFragment;
    private SoccerListFragment<Match> matchesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize data from DataProvider
        initData();

        // set up Fragments with initial data
        teamsFragment = new SoccerListFragment<>(teamRepo.getAll());
        playersFragment = new SoccerListFragment<>(playerRepo.getAll());
        matchesFragment = new SoccerListFragment<>(matchRepo.getAll());

        // set up ViewPager2 and Tabs
        setupNavigation();

        // implement search logic
        setupSearch();
    }

    private void initData() {
        // fill repositories using data from assignment PDF
        DataProvider.createSampleTeams().forEach(teamRepo::add);
        DataProvider.createSamplePlayers().forEach(playerRepo::add);
        DataProvider.createSampleMatches().forEach(matchRepo::add);
    }

    private void setupNavigation() {
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // add tabs
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(teamsFragment);
        fragments.add(playersFragment);
        fragments.add(matchesFragment);

        MainPagerAdapter pagerAdapter = new MainPagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);

        // connect tab layout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Teams"); break;
                case 1: tab.setText("Players"); break;
                case 2: tab.setText("Matches"); break;
            }
        }).attach();
    }

    private void setupSearch() {
        EditText searchBar = findViewById(R.id.searchEditText);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase();

                // filter teams
                List<Team> filteredTeams = teamRepo.filter(t -> t.getName().toLowerCase().contains(query));
                teamsFragment.updateList(filteredTeams);

                // filter players
                List<Player> filteredPlayers = playerRepo.filter(p -> p.getName().toLowerCase().contains(query));
                playersFragment.updateList(filteredPlayers);

                // filter matches
                List<Match> filteredMatches = matchRepo.filter(m -> m.getName().toLowerCase().contains(query));
                matchesFragment.updateList(filteredMatches);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}