package fr.esgi.retrofit.network;

import java.util.List;

import fr.esgi.retrofit.model.Repo;
import fr.esgi.retrofit.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by mohsan on 10/05/16.
 */
public interface GitHubService {

    String END_POINT = "https://api.github.com";
    String TOKEN = "";

    @Headers("Authorization: token "+TOKEN)
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

    @Headers("Authorization: token "+TOKEN)
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


}
