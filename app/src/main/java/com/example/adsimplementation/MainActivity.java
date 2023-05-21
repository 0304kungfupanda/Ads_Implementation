package com.example.adsimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        adView = findViewById(R.id.adView);
//
//        //step1
//
//        MobileAds.initialize(this);
//
//        //step2
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        //step3
//
//        adView.loadAd(adRequest);
//    }



//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//
//
//            }
//        });
//
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                for (String name: initializationStatus.getAdapterStatusMap().keySet()) {
                    String key = name.toString();
                    String value = initializationStatus.getAdapterStatusMap().get(name).getInitializationState().toString();
                    System.out.println(key + " " + value);
                    Log.d("TAG", "onInitializationComplete:"+key + " " + value);
                }


                //Log.d("TAG", "onInitializationComplete:"+initializationStatus.getAdapterStatusMap().toString());
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}