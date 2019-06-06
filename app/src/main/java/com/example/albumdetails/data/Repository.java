package com.example.albumdetails.data;

import com.example.albumdetails.data.local.AlbumDao;
import com.example.albumdetails.data.remote.AlbumService;
import com.example.albumdetails.model.Album;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class Repository {

    private final AlbumService albumService;
    private final AlbumDao albumDao;

    @Inject
    public Repository(AlbumService albumService, AlbumDao albumDao) {
        this.albumService = albumService;
        this.albumDao = albumDao;
    }

    private Single<List<Album>> getRemoteAlbumList() {
        return albumService.getAlbumList()
                .doOnSuccess(this::insertAlbums);
    }

    public Single<List<Album>> getAlbumList() {
        return albumDao.getAlbumList()
                .flatMap(albums -> {
                    if (albums.isEmpty()) {
                        return getRemoteAlbumList();
                    } else {
                        return getLocalAlbumList();
                    }
                });
    }

    private Single<List<Album>> getLocalAlbumList(){
        return albumDao.getAlbumList();
    }

    private void insertAlbums(List<Album> albums) {
        Completable.fromSingle(completable -> albumDao.insertAlbums(albums))
                .subscribeOn(Schedulers.io()).subscribe();
    }
}
