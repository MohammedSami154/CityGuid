package com.example.cityguide.Users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.cityguide.R;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView_features;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        recyclerView_features = findViewById(R.id.features_recycler);
        recyclerView_features();
    }

    private void recyclerView_features() {
        recyclerView_features.setHasFixedSize(true);
        recyclerView_features.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false));
    }
}