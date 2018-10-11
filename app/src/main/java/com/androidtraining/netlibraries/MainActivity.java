package com.androidtraining.netlibraries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_TAG";
    private OkHttpClient okHttpClient;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.resultTV);

        okHttpClient = new OkHttpClient
                .Builder()
                .build();

        Request request = new Request.Builder()
                .url("https://www.google.com")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // retry
                // for retry call.enqueue()
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){ // 200 OK
                    final String result = response.body().string();

                    Log.d(TAG, "onResponse: result " + result);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            resultTV.setText(result);
                        }
                    });

                }else{
                    // error state -> 500, 401, 402, etc...
                    //retry
                    Log.d(TAG, "onResponse: Error" + response.code());
                }
            }
        });

    }
}
