package fr.esgi.retrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.GitHubService;
import fr.esgi.retrofit.GithubWebService;
import fr.esgi.retrofit.R;
import fr.esgi.retrofit.model.Repo;
import fr.esgi.retrofit.adapter.RepoAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohsan on 14/06/16.
 */
public class ListRepoFragment extends Fragment {


    @BindView(R.id.listRepo) RecyclerView recyclerView;
    String username;
    GitHubService service;


    public static Fragment newInstance(String textToDisplay){
        ListRepoFragment mainFragment = new ListRepoFragment();
        Bundle arguments = new Bundle();
        arguments.putString("Username", textToDisplay);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_repo, container, false);

        ButterKnife.bind(this,view);

        Bundle arguments = getArguments();
        username = arguments.getString("Username");
        service = GithubWebService.get();

        loadRepo(username);

        return  view;
    }

    protected void loadRepo(String name){
        service.listRepos(name).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()){
                    List<Repo> userList = response.body();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(new RepoAdapter(userList));
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
