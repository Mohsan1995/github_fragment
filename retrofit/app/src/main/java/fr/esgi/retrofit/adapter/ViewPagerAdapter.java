package fr.esgi.retrofit.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.retrofit.fragment.ProfileFragment;
import fr.esgi.retrofit.fragment.ViewPagerTab;
import fr.esgi.retrofit.model.User;

/**
 * Created by mohsan on 02/06/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private User user;


    public ViewPagerAdapter(FragmentManager manager, User user) {
        super(manager);
        this.user=user;

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment= new Fragment();

        if(position==0){
           fragment=  ViewPagerTab.newInstance(user.getPublicRepos());
        }else if(position==1){
            fragment =ViewPagerTab.newInstance(user.getFollowers());
        }else if(position==2){
            fragment= ViewPagerTab.newInstance(user.getFollowing());
        }

        return fragment;
    }


    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String name="";
        if(position==0){
            name ="Repository public public";
        }else if(position==1){
            name= "Nombre de follower";
        }else if(position==2){
            name= "followed";
        }

        return name;

    }
}

