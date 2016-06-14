package fr.esgi.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mohsan on 14/06/16.
 */
public class ProfileFragment extends Fragment {


    public static Fragment newInstance(String textToDisplay){
        ProfileFragment mainFragment = new ProfileFragment();
        Bundle arguments = new Bundle();
        arguments.putString("textToDisplay", textToDisplay);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Bundle arguments = getArguments();

        return  v;
    }
}
