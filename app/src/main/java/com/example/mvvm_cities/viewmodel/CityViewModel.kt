package com.example.mvvm_cities.viewmodel

import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_cities.model.City
import com.example.mvvm_cities.model.CityDataProvider
import java.lang.invoke.MethodHandles.loop
import java.util.logging.Handler


@RequiresApi(33)
class CityViewModel: ViewModel() {
    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
    }
    fun getCityData(): LiveData<City> = cityData
    private fun loop(){
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            updateCity()
        }, delay)
    }
   private fun updateCity() {
       currentIndex++
       currentIndex %= cities.size

       cityData.value = cities[currentIndex]

       loop()
   }
}