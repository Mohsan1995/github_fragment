package fr.esgi.retrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.R;
import fr.esgi.retrofit.model.User;
import fr.esgi.retrofit.network.GitHubService;
import fr.esgi.retrofit.network.GithubWebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohsan on 14/06/16.
 */
public class ProfileFragment extends Fragment {

    private static final String USERNAME = "Username";
    @BindView(R.id.name) TextView name;
    @BindView(R.id.pseudo) TextView pseudo;
    @BindView(R.id.followers) TextView followers;
    @BindView(R.id.image) ImageView avatar;
    String username;
    GitHubService service;

    public static Fragment newInstance(String value) {
        ProfileFragment mainFragment = new ProfileFragment();
        Bundle arguments = new Bundle();
        arguments.putString(USERNAME, value);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, v);

        Bundle arguments = getArguments();
        if (arguments != null) {
            username = arguments.getString(USERNAME);
        }

        service = GithubWebService.get();
        loadUser(username);

        return v;
    }

    protected void loadUser(String name) {
        service.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();

                    displayUser(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("retrofit", "failure" + t);
            }
        });
    }

    protected void displayUser(User user) {
        name.setText(user.getName());
        pseudo.setText(user.getLogin());
        followers.setText(user.getFollowers());

        if (user.getAvatarUrl() != null) {
            Glide.with(avatar.getContext())
                .load(user.getAvatarUrl())
                .into(avatar);
        }

    }
}
