package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weather.pojo.USD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExchangeActivity extends AppCompatActivity {

    TextView changeText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        changeText = findViewById(R.id.textView);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<USD> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<USD>() {
            @Override
            public void onResponse(Call<USD> call, Response<USD> response) {
                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                USD resource = response.body();

                    displayResponse += "name: " + resource.getName()+ " " + "value: " + resource.getValue() + "\n";


                changeText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<USD> call, Throwable t) {
                call.cancel();
            }
        });

    }
}
