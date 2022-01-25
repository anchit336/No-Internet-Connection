package com.example.nointernet25jan22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nointernet25jan22.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (isConnected())
        {
            binding.noInternet.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "No Internet Access", Toast.LENGTH_SHORT).show();

        } else {
                
            Toast.makeText(MainActivity.this, "Welcome to our app", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}