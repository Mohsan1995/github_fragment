package fr.esgi.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name) TextView name;
    @BindView(R.id.pseudo) TextView pseudo;
    @BindView(R.id.followers) TextView followers;
    @BindView(R.id.image) ImageView avatar;

    GitHubService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        service = GithubWebService.get();
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadUser("florent37");
    }

    protected void loadUser(String name){
        service.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                displayUser(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("retrofit", "failure" + t);
            }
        });
    }

    protected void displayUser(User user){
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