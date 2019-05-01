package com.example.githubdeveloper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("login")
    @Expose
    private String login;


    @SerializedName("avatar_url")
    @Expose
    private String avatarurl;

    @SerializedName("html_url")
    @Expose
    private String htmlurl;

    @SerializedName("repos_url")
    @Expose
    private String reposurl;

    //Constructor
    public Item(String login, String avatarurl, String htmlurl, String reposurl) {
        this.login = login;
        this.avatarurl = avatarurl;
        this.htmlurl = htmlurl;
        this.reposurl = reposurl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getHtmlurl() {
        return htmlurl;
    }

    public void setHtmlurl(String htmlurl) {
        this.htmlurl = htmlurl;
    }

    public String getReposurl() {
        return reposurl;
    }

    public void setReposurl(String reposurl) {
        this.reposurl = reposurl;
    }
}
