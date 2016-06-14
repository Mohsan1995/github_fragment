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
    String TOKEN = "04301e3f5ef0106e891cb8dfe81a9a489fef80d1";

    @Headers("Authorization: token "+TOKEN)
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);


}
