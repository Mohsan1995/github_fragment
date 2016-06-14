package fr.esgi.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohsan on 10/05/16.
 */

public class User {

    public String name;
    public String login;
    @SerializedName("avatar_url")
    public String avatarUrl;
    public String followers;
    public String following;
    @SerializedName("public_repos")
    public String publicRepos;



    public User(String name, String login, String avatarUrl, String followers) {
        this.name = name;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getFollowers() {
        return followers;
    }


    public String getFollowing() {
        return following;
    }

    public String getPublicRepos() {
        return publicRepos;
    }



}
