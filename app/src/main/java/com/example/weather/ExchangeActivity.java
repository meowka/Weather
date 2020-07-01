package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weather.pojo.MultipleResource;

import java.util.List;

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
        Call<List<MultipleResource>> call = apiInterface.doGetListResources(01/07/2020);
        call.enqueue(new Callback<List<MultipleResource>>() {
            @Override
            public void onResponse(Call<List<MultipleResource>> call, Response<List<MultipleResource>> response) {
                if (!response.isSuccessful()){
                    changeText.setText("Code: " + response.code());
                    return;
                }
//                Log.d("TAG", response.code()+"");
                String displayResponse = "";
                List<MultipleResource> resources = response.body();

                for (MultipleResource resource : resources) {
                    displayResponse += "Id: " + resource.getId() + " " + "name: "  + resource.getName() + " value:"  + resource.getValue() + "\n";
                }
                changeText.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<List<MultipleResource>> call, Throwable t) {
                call.cancel();
            }
        });

    }
}
