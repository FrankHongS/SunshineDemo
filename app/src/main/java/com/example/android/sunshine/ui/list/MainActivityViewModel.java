package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.List;

/**
 * Created by Frank_Hon on 4/9/2019.
 * E-mail: v-shhong@microsoft.com
 */
public class MainActivityViewModel extends ViewModel {

    private final LiveData<List<WeatherEntry>> mWeatherList;

    private SunshineRepository mRepository;

    public MainActivityViewModel(SunshineRepository repository) {

        this.mRepository=repository;

        mWeatherList=repository.getCurrentWeatherForecasts();
    }

    public LiveData<List<WeatherEntry>> getWeatherList(){
        return mWeatherList;
    }
}
