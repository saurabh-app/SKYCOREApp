package com.example.skycoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.skycoreapp.adapter.ListItemAdapter;
import com.example.skycoreapp.model.Business;
import com.example.skycoreapp.model.MasterResponseModel;
import com.example.skycoreapp.network.ApiClient;
import com.example.skycoreapp.network.ApiService;

import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ListItemAdapter mAdapter;
    @BindView(R.id.seekBar)
     SeekBar seekBar;
    @BindView(R.id.progress_circular)
     ProgressBar progress_circular;
    @BindView(R.id.list_item)
    RecyclerView list_item;
    private MasterResponseModel masterResponseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       String term="restaurants";
        String location="NYC";
       int radius=500;
        initilizeId();
        apiService = ApiClient.getClient().create(ApiService.class);

        fetchAllNotes(term,location,radius);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int radius,
                                          boolean fromUser) {
                fetchAllNotes(term,location,radius);
//                Toast.makeText(getApplicationContext(), "seekbar progress: " + radius, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initilizeId() {
        seekBar = findViewById(R.id.seekBar);
        list_item = findViewById(R.id.list_item);
        progress_circular = findViewById(R.id.progress_circular);
    }


    @Override
    public void onClick(View view) {
//        Switch(View.getId)
    }

    private void fetchAllNotes(String term, String location, int radius) {
        ProgressDialog progressBar = new ProgressDialog(MainActivity.this);
        progressBar.setCancelable(true);//you can cancel it by pressing back button
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(2);//initially progress is 0
        progressBar.setMax(150);//sets the maximum value 100
        progressBar.show();//displays the progress bar
        Call<MasterResponseModel> call = apiService.getAlllists(term,location,radius);

        call.enqueue(new Callback<MasterResponseModel>() {
            @Override
            public void onResponse(Call<MasterResponseModel> call, Response<MasterResponseModel> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    masterResponseModel=response.body();
                    progressBar.dismiss();
                    List<Business> business = masterResponseModel.getBusinesses();

                    Log.d(TAG,"Onresponce"+business);


                    mAdapter = new ListItemAdapter(MainActivity.this,business);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    list_item.setLayoutManager(mLayoutManager);
                    list_item.setItemAnimator(new DefaultItemAnimator());
                    list_item.setAdapter(mAdapter);

                }
                else {
                    Toast.makeText(MainActivity.this, "Error! Please try again!"+response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MasterResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.dismiss();

            }
        });
    }
}