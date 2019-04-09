package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Frank_Hon on 4/9/2019.
 * E-mail: v-shhong@microsoft.com
 */
@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    @Query("SELECT * FROM weather WHERE date=:date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("SELECT * FROM weather WHERE date>=:date")
    LiveData<List<WeatherEntry>> getCurrentWeatherForecasts(Date date);

    @Query("SELECT COUNT(id) FROM weather WHERE date>=:date")
    int countAllFutureWeather(Date date);

    @Query("DELETE FROM weather WHERE date<:date")
    void deleteOldData(Date date);
}