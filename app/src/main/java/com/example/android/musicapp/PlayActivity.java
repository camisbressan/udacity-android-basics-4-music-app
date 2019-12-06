package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String tocando = bundle.getString("tocando");
        TextView tocandoTextView = findViewById(R.id.playing_text);
        tocandoTextView.setText(tocando);

        int album = bundle.getInt("album");
        ImageView albumImageView = findViewById(R.id.album_image);
        if(album == 0){
            albumImageView.setImageResource(R.drawable.ic_play_foreground);
        }else{
            albumImageView.setImageResource(album);
        }

        Button pauseButton = findViewById(R.id.button_pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button pauseButton = findViewById(R.id.button_pause);
                pauseButton.setVisibility(View.GONE);

                Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT).show();
                Button playButton = findViewById(R.id.button_play);
                playButton.setVisibility(View.VISIBLE);
            }
        });

        Button playButton = findViewById(R.id.button_play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button pauseButton = findViewById(R.id.button_pause);
                pauseButton.setVisibility(View.VISIBLE);

                Toast.makeText(getApplicationContext(), "Tocando", Toast.LENGTH_SHORT).show();
                Button playButton = findViewById(R.id.button_play);
                playButton.setVisibility(View.GONE);
            }
        });

    }
}
