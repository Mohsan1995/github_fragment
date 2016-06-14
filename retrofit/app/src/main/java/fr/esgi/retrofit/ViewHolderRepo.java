package fr.esgi.retrofit;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by mohsan on 14/06/16.
 */
public class ViewHolderRepo extends RecyclerView.ViewHolder {

    private TextView tvRepoName;
    private TextView tvIdRepo;


    public ViewHolderRepo(View itemView) {
        super(itemView);
        tvIdRepo = (TextView) itemView.findViewById(R.id.tvIdRepo);
        tvRepoName= (TextView) itemView.findViewById(R.id.tvIdNameRepo);
    }

    public void bind(final Repo myObject){
        tvRepoName.setText(myObject.getName());
        tvIdRepo.setText(myObject.getId());

    }
}
