package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Cria uma lista de Musicas
        final ArrayList<Musica> musicas = new ArrayList<Musica>();
        musicas.add(new Musica("Chico Buarque", "A Banda"));
        musicas.add(new Musica("Marisa Monte", "Ainda Bem"));
        musicas.add(new Musica("Zé Ramalho", "Chão de Giz"));
        musicas.add(new Musica("Elis Regina", "Como Nossos Pais"));
        musicas.add(new Musica("Djavan", "Eu Te Devoro"));
        musicas.add(new Musica("Adriana Calcanhoto", "Fico Assim Sem Você"));
        musicas.add(new Musica("Tim Maia", "Gostava Tanto de Você"));
        musicas.add(new Musica("Ana Carolina", "Quem de Nós Dois"));
        musicas.add(new Musica("Caetano Veloso", "Sozinho"));
        musicas.add(new Musica("Tribalistas", "Velha Infância"));

        MusicaAdapter adapter = new MusicaAdapter(this, musicas);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Musica musica = musicas.get(position);

                Intent playingIntent = new Intent(MusicaActivity.this, PlayActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("tocando", musica.getMusica());
                playingIntent.putExtras(bundle);

                startActivity(playingIntent);

                Toast.makeText(getApplicationContext(), "Tocando " + musica.getMusica(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}