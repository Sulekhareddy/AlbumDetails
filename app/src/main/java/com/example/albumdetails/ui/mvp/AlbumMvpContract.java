package com.example.albumdetails.ui.mvp;

import com.example.albumdetails.model.Album;

import java.util.List;

public interface AlbumMvpContract {

    interface View {

        void setAlbums(List<Album> albums);

        void showError(String message);

        void showProgressBar(boolean isVisible);
    }
}
