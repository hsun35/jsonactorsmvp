package com.example.hefen.jsonactorsmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hefen.jsonactorsmvp.adapter.MyAdapter;
import com.example.hefen.jsonactorsmvp.model.Actor;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    IPresenter iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        iPresenter = new Presenter(MainActivity.this);
        iPresenter.sendCall();
    }

    @Override
    public void setData(List<Actor> actorList) {
        myAdapter = new MyAdapter(actorList, MainActivity.this);//set adapter
        recyclerView.setAdapter(myAdapter);
    }
}
