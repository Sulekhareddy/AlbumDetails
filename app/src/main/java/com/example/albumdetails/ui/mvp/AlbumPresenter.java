package com.example.albumdetails.ui.mvp;

import com.example.albumdetails.data.Repository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlbumPresenter {

    private final AlbumMvpContract.View view;
    private final Repository repository;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public AlbumPresenter(AlbumMvpContract.View view, Repository repository, CompositeDisposable compositeDisposable) {
        this.view = view;
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
    }

    public void getAlbumList() {
        addDisposable(repository.getAlbumList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.showProgressBar(true))
                .doFinally(() -> view.showProgressBar(false))
                .subscribe(view::setUsers, throwable -> view.showError(throwable.getMessage())));
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }
}
