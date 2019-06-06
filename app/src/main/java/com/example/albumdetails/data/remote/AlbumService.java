package com.example.albumdetails.data.remote;

import com.example.albumdetails.model.Album;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AlbumService {

    @GET("albums")
    Single<List<Album>> getAlbumList();
}
