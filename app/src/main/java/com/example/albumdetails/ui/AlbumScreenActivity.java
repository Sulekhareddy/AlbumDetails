package com.example.albumdetails.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.albumdetails.R;
import com.example.albumdetails.AlbumApp;
import com.example.albumdetails.di.component.DaggerAlbumActivityComponent;
import com.example.albumdetails.di.module.AlbumActivityModule;
import com.example.albumdetails.model.Album;
import com.example.albumdetails.ui.mvp.AlbumMvpContract;
import com.example.albumdetails.ui.mvp.AlbumPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumScreenActivity extends AppCompatActivity implements AlbumMvpContract.View {

    @Inject
    AlbumPresenter presenter;
    @Inject
    AlbumAdapter albumAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.users_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerAlbumActivityComponent.builder()
                .applicationComponent(AlbumApp.getInstance(this).getApplicationComponent())
                .albumActivityModule(new AlbumActivityModule(this))
                .build().inject(this);

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getAlbumList();
    }

    private void initViews() {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(albumAdapter);
    }

    @Override
    public void setAlbums(List<Album> albums) {
        albumAdapter.setItems(albums);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }
}
