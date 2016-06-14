package fr.esgi.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by mohsan on 10/05/16.
 */
public interface GitHubService {

    String END_POINT = "https://api.github.com";
    String TOKEN = "METTRE ICI";

    @Headers("Authorization: token "+TOKEN)
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);


}
