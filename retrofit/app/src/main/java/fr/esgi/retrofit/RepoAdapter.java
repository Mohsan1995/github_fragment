package fr.esgi.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.esgi.retrofit.model.Repo;

/**
 * Created by mohsan on 14/06/16.
 */
public class RepoAdapter extends RecyclerView.Adapter<ViewHolderRepo> {

    List<Repo> list;

    //ajouter un constructeur prenant en entrée une liste
    public RepoAdapter(List<Repo> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public ViewHolderRepo onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_repo,viewGroup,false);
        return new ViewHolderRepo(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(ViewHolderRepo myViewHolder, int position) {
        Repo repo = list.get(position);
        myViewHolder.bind(repo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
