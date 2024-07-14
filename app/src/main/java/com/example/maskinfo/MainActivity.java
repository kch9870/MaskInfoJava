package com.example.maskinfo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maskinfo.adapter.StoreAdapter;
import com.example.maskinfo.model.Store;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Store> items = new ArrayList<Store>();

        Store store = new Store();
        store.setName("우리약국");
        store.setAddr("어디시 어디구 어쩌동 123-456");

        items.add(store);
        items.add(store);
        items.add(store);
        items.add(store);
        items.add(store);
        items.add(store);

        // 리사이클 뷰 매칭
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // 리사이클 뷰 어뎁터 매칭
        StoreAdapter adapter = new StoreAdapter();
        recyclerView.setAdapter(adapter);

        adapter.updateItems(items);
    }
}