package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of Musicas
        final ArrayList<Musica> musicas = new ArrayList<Musica>();
        musicas.add(new Musica("Adriana Calcanhoto"));
        musicas.add(new Musica("Ana Carolina"));
        musicas.add(new Musica("Caetano Veloso"));
        musicas.add(new Musica("Chico Buarque"));
        musicas.add(new Musica("Djavan"));
        musicas.add(new Musica("Elis Regina"));
        musicas.add(new Musica("Marisa Monte"));
        musicas.add(new Musica("Tim Maia "));
        musicas.add(new Musica("Tribalistas"));
        musicas.add(new Musica("Zé Ramalho"));

        MusicaAdapter adapter = new MusicaAdapter(this, musicas);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Musica musica = musicas.get(position);

                Intent playingIntent = new Intent(ArtistaActivity.this, PlayActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("tocando", musica.getMusica());
                playingIntent.putExtras(bundle);

                startActivity(playingIntent);

                Toast.makeText(getApplicationContext(), "Tocando "  + musica.getMusica(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}