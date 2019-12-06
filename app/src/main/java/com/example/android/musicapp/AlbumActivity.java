package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of Musicas
        final ArrayList<Musica> musicas = new ArrayList<Musica>();
        musicas.add(new Musica("Adriana Calcanhoto", "Adriana Partimpim", R.drawable.ic_partimpim));
        musicas.add(new Musica("Ana Carolina", "Ana Rita Joana Iracema e Carolina", R.drawable.ic_ana));
        musicas.add(new Musica("Djavan", "Bicho Solto", R.drawable.ic_bicho_solto));
        musicas.add(new Musica("Chico Buarque", "Chico Buarque de Hollanda", R.drawable.ic_chico));
        musicas.add(new Musica("Elis Regina", "Falso Brilhante", R.drawable.ic_falso_brilhante));
        musicas.add(new Musica("Marisa Monte", "O Que Você Quer Saber de Verdade", R.drawable.ic_marisa));
        musicas.add(new Musica("Caetano Veloso", "Prenda Minha", R.drawable.ic_caetano));
        musicas.add(new Musica("Tim Maia", "Tim Maia ao Vivo II", R.drawable.ic_tim_maia));
        musicas.add(new Musica("Tribalistas", "Tribalistas", R.drawable.ic_tribalistas));
        musicas.add(new Musica("Zé Ramalho", "Zé Ramalho 2", R.drawable.ic_ze_ramalho));

        MusicaAdapter adapter = new MusicaAdapter(this, musicas);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Musica musica = musicas.get(position);

                Intent playingIntent = new Intent(AlbumActivity.this, PlayActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("tocando", musica.getMusica());
                bundle.putInt("album", musica.getImageResourceId());
                playingIntent.putExtras(bundle);

                startActivity(playingIntent);

                Toast.makeText(getApplicationContext(), "Tocando " + musica.getMusica() + " de " + musica.getArtista(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}