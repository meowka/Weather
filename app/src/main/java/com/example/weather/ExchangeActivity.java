package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.weather.pojo.USD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExchangeActivity extends AppCompatActivity {

    TextView usdName;
    TextView usdPrevValue;
    TextView usdValue;
    TextView eurName;
    TextView eurPrevValue;
    TextView eurValue;
    TextView exchangeTitle;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        init();

        apiInterface = APIClient.getService();
        Call<ApiResponse> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<ApiResponse>() {
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

    private void init() {
        usdName = findViewById(R.id.usdName);
        usdPrevValue = findViewById(R.id.preUsdValue);
        usdValue = findViewById(R.id.usdValue);
        eurName = findViewById(R.id.eurName);
        eurPrevValue = findViewById(R.id.preEurValue);
        eurValue = findViewById(R.id.eurValue);
        exchangeTitle = findViewById(R.id.title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.exchange_rate:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }


}
