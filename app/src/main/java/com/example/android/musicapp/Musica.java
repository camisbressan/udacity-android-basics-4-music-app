package com.example.android.musicapp;

public class Musica {

    /** Dados do Artista */
    private String mArtista;

    /** Dados da Música */
    private String mMusica;

    /** Imagem */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Sem imagem*/
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Criação de um novo objeto Musica
     *
     *  @param musica Nome do Artista
     */
    public Musica(String musica) {
        mMusica = musica;
    }

    /**
     * Criação de um novo objeto Musica
     *
     * @param artista Nome do Artista
     * @param musica Nome da Música
     */
    public Musica(String artista, String musica) {
        mArtista = artista;
        mMusica = musica;
    }

    /**
     * Cria um novo objeto Musica.
     *
     * @param artista Nome do Artista
     * @param musica Nome da Música
     * @param imageResourceId Imagem
     */
    public Musica(String artista, String musica, int imageResourceId) {
        mArtista = artista;
        mMusica = musica;
        mImageResourceId = imageResourceId;
    }
    /**
     * Get - Dados do Artista.
     */
    public String getArtista() {
        return mArtista;
    }

    /**
     * Get - Dados da Música.
     */
    public String getMusica() {
        return mMusica;
    }

    /**
     * Get - ID da Imagem
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


    /**
     * Retorna se tem imagem da Musica.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}