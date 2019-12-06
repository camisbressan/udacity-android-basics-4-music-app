package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicaAdapter extends ArrayAdapter<Musica> {

    /**
     * Cria um novo {@link MusicaAdapter} objeto.
     */
    public MusicaAdapter(Context context, ArrayList<Musica> Musicas) {
        super(context, 0, Musicas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Musica currentMusica = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.musica_text_view);
        nameTextView.setText(currentMusica.getMusica());

        TextView numberTextView = listItemView.findViewById(R.id.artista_text_view);
        numberTextView.setText(currentMusica.getArtista());

        ImageView imageView = listItemView.findViewById(R.id.album_image_view);
        if (currentMusica.hasImage()) {
            imageView.setImageResource(currentMusica.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }

}