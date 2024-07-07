package com.example.maskinfo;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.maskinfo.model.StoreInfo;
import com.example.maskinfo.repository.MaskService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * Retrofit Unit Test
     *
     * @throws IOException 예외
     */
    @Test
    public void retrofitTest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MaskService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        MaskService service = retrofit.create(MaskService.class);

        Call<StoreInfo> storeInfoCall = service.fetchStoreInfo();

        StoreInfo storeInfo = storeInfoCall.execute().body();

        assertEquals(222, storeInfo.getCount());
        assertEquals(222, storeInfo.getStores().size());
    }
}