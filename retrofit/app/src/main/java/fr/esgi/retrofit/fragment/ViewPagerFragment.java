package fr.esgi.retrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.R;
import fr.esgi.retrofit.adapter.ViewPagerAdapter;
import fr.esgi.retrofit.model.User;
import fr.esgi.retrofit.network.GitHubService;
import fr.esgi.retrofit.network.GithubWebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohsan on 14/06/16.
 */
public class ViewPagerFragment extends Fragment {

    private static final String USERNAME = "Username";
    @BindView(R.id.viewPagerTab) ViewPager viewPager;
    @BindView(R.id.sliding_tabs) TabLayout tabLayout;
    String username;
    GitHubService service;

    public static Fragment newInstance(String value) {
        ViewPagerFragment mainFragment = new ViewPagerFragment();
        Bundle arguments = new Bundle();
        arguments.putString(USERNAME, value);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ButterKnife.bind(this, view);
        Bundle arguments = getArguments();
        username = arguments.getString(USERNAME);

        Log.e("TEST", username);
        service = GithubWebService.get();
        loadUser(username);

        return view;
    }

    protected void loadUser(String name) {
        service.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    setupViewPager(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("retrofit", "failure" + t);
            }
        });
    }

    private void setupViewPager(User user) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), user);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
