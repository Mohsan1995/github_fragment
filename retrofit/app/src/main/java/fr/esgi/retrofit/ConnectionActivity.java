package fr.esgi.retrofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.esgi.retrofit.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohsan on 14/06/16.
 */
public class ConnectionActivity extends AppCompatActivity{


    String USER_KEY ="USERNAME";

    @BindView(R.id.username)
    EditText userEditText;


    GitHubService service;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        ButterKnife.bind(this);
        service = GithubWebService.get();

        sharedPreferences = this.getPreferences(MODE_PRIVATE);




        if(sharedPreferences.contains(USER_KEY)){
            Toast.makeText(ConnectionActivity.this, "ALREAD CONNECTED", Toast.LENGTH_SHORT).show();
            String value=sharedPreferences.getString(USER_KEY, "");
            userEditText.setText(value);

        }



    }

    protected void loadUser(String name){
        service.getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user = response.body();
                    Log.e("ConnectionActivity", user.getLogin());

                    editor = sharedPreferences.edit();
                    editor.putString(USER_KEY, user.getLogin());
                    editor.apply();

                    Intent intent = new Intent(ConnectionActivity.this, MainActivity.class);
                    intent.putExtra(USER_KEY, sharedPreferences.getString(USER_KEY, ""));
                    startActivity(intent);
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("retrofit", "failure" + t);
            }
        });
    }

    public void save(View view) {

        String username= userEditText.getEditableText().toString();
        loadUser(username);


    }
}
