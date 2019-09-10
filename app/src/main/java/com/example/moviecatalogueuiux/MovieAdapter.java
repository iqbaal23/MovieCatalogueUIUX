package com.example.moviecatalogueuiux;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;

    public MovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        return  new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {
        final Movie movie = listMovie.get(i);

        Glide.with(listViewHolder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(100,150))
                .into(listViewHolder.imgPhoto);
        listViewHolder.tvName.setText(movie.getName());
        listViewHolder.tvScore.setText(movie.getScore());
        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movies = new Movie();
                movies.setName(listMovie.get(listViewHolder.getAdapterPosition()).getName());
                movies.setScore(listMovie.get(listViewHolder.getAdapterPosition()).getScore());
                movies.setDate(listMovie.get(listViewHolder.getAdapterPosition()).getDate());
                movies.setOverview(listMovie.get(listViewHolder.getAdapterPosition()).getOverview());
                movies.setPhoto(listMovie.get(listViewHolder.getAdapterPosition()).getPhoto());

                Intent intent = new Intent(listViewHolder.itemView.getContext(), MovieDetail.class);
                intent.putExtra(MovieDetail.EXTRA_MOVIE, movies);
                listViewHolder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvScore;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_judul);
            tvScore = itemView.findViewById(R.id.tv_score);
        }
    }
}
