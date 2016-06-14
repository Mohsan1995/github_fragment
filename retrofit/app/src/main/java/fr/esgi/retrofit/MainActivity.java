package fr.esgi.retrofit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohsan on 14/06/16.
 */
public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        super.onCreate(savedInstanceState);
    }
}
