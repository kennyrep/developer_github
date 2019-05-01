package com.example.githubdeveloper.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.githubdeveloper.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    TextView Username, Link;
    CircleImageView imageView;
    Toolbar mActionBarToolbar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.user_image_header);
        Username = findViewById(R.id.username);
        //repository = findViewById(R.id.repository);
        Link = findViewById(R.id.link);


        String username = getIntent().getExtras().getString("login");
        String avatarurl = getIntent().getExtras().getString("avatar_url");
       // String repos = getIntent().getExtras().getString("repos_url");
        String link = getIntent().getExtras().getString("html_url");

        Link.setText(link);
        //repository.setText(repos);
        Linkify.addLinks(Link, Linkify.WEB_URLS);
        Username.setText(username);
        Glide.with(this)
                .load(avatarurl)
                .placeholder(R.drawable.progress)
                .into(imageView);

        getSupportActionBar().setTitle("Details Activity");


    }

    private Intent createShareForcastIntent() {
        String username = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("link");

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("Text/Plain")
                .setText("Check This Out @ " + username + ", " + link)
                .getIntent();
        return shareIntent;
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcastIntent());
        return  true;
    }
}



