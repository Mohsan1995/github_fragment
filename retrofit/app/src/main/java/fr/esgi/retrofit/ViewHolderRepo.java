package fr.esgi.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mohsan on 14/06/16.
 */
public class ViewHolderRepo extends RecyclerView.ViewHolder {

    private TextView tvRepoName;
    private TextView tvIdRepo;


    public ViewHolderRepo(View itemView) {
        super(itemView);
    }
}
