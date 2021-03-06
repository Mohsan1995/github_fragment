package fr.esgi.retrofit.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.R;
import fr.esgi.retrofit.fragment.ListRepoFragment;
import fr.esgi.retrofit.fragment.ProfileFragment;
import fr.esgi.retrofit.fragment.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    final static String USER_KEY = "USERNAME";

    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.fab) FloatingActionButton fab;

    ActionBarDrawerToggle toggle;
    String name;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //Permet d'ajouter les bars pour ouvrir la navigation view
        toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("USERNAME");
        }

        sharedPreferences = this.getPreferences(MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.userProfile) {
            //fm.beginTransaction().replace(R.id.content_frame, new ImportFragment()).commit();
            fragment = ProfileFragment.newInstance(name);
        } else if (id == R.id.listRepoMenu) {
            fragment = ListRepoFragment.newInstance(name);
        } else if (id == R.id.menuViewPager) {
            fragment = ViewPagerFragment.newInstance(name);
        } else if (id == R.id.menuLogout) {
            sharedPreferences.edit().remove(USER_KEY).apply();

            Intent intent = new Intent(this, ConnectionActivity.class);
            startActivity(intent);
        }

        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}