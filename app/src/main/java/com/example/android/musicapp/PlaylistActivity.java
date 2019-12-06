package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Cria uma lista de Musicas
        final ArrayList<Musica> musicas = new ArrayList<Musica>();
        musicas.add(new Musica("Mais tocadas 2018"));
        musicas.add(new Musica("Internacionais"));
        musicas.add(new Musica("Música Popular Brasileira"));
        musicas.add(new Musica("O melhor do Brasil"));
        musicas.add(new Musica("Rock Internacional"));
        musicas.add(new Musica("Funk 2018"));
        musicas.add(new Musica("Só no pagodinho"));
        musicas.add(new Musica("Samba"));

        MusicaAdapter adapter = new MusicaAdapter(this, musicas);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Musica musica = musicas.get(position);

                Intent playingIntent = new Intent(PlaylistActivity.this, PlayActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("tocando", musica.getMusica());
                playingIntent.putExtras(bundle);

                startActivity(playingIntent);

                Toast.makeText(getApplicationContext(), "Tocando " + musica.getMusica(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}