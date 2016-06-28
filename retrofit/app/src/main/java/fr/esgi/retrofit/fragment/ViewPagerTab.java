package fr.esgi.retrofit.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.R;

/**
 * Created by mohsan on 14/06/16.
 */
public class ViewPagerTab extends Fragment {

    private static final String VALUE = "value";
    @BindView(R.id.viewPagerValue)
    TextView textView;
    String value;
    SharedPreferences sharedPreferences;

    public static Fragment newInstance(String value) {
        ViewPagerTab mainFragment = new ViewPagerTab();
        Bundle arguments = new Bundle();
        arguments.putString(VALUE, value);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        ButterKnife.bind(this, view);
        sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);

        Bundle arguments = getArguments();
        if (arguments != null) {
            value = arguments.getString(VALUE);
        }

        Log.e("TEST", value);

        textView.setText(value);

        return view;
    }

}
