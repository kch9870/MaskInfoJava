package com.example.maskinfo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maskinfo.adapter.StoreAdapter;
import com.example.maskinfo.model.Store;
import com.example.maskinfo.model.StoreInfo;
import com.example.maskinfo.repository.MaskService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리사이클 뷰 매칭
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // 리사이클 뷰 어뎁터 매칭
        StoreAdapter adapter = new StoreAdapter();
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MaskService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MaskService service = retrofit.create(MaskService.class);

        Call<StoreInfo> storeInfoCall = service.fetchStoreInfo();
        storeInfoCall.enqueue(new Callback<StoreInfo>() {
            @Override
            public void onResponse(Call<StoreInfo> call, Response<StoreInfo> response) {
                List<Store> items = response.body().getStores();
                adapter.updateItems(items);
                getSupportActionBar().setTitle("마스크 재고 있는 곳 : " + items.size() + "곳");
            }

            @Override
            public void onFailure(Call<StoreInfo> call, Throwable t) {
                Log.d(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.action_refresh) {
            Log.d("test", "getItemId");
            // 리프래쉬 하는 부분
        }

        return true;
    }
}