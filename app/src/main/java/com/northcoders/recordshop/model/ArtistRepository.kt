package com.northcoders.recordshop.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.northcoders.recordshop.service.ApiService
import com.northcoders.recordshop.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository(val context: Context) {
    private val TAG: String = "ArtistRepository"

    private val dataList: MutableLiveData<List<Artist>> = MutableLiveData()

    fun getAllArtistsData() : MutableLiveData<List<Artist>> {
        val service: ApiService = RetrofitInstance.getService()

        service.allArtists.enqueue(object : Callback<List<Artist>> {
            override fun onResponse(p0: Call<List<Artist>>, p1: Response<List<Artist>>) {
                val artists: List<Artist> = p1.body() ?: emptyList()
                dataList.value = artists
            }

            override fun onFailure(p0: Call<List<Artist>>, p1: Throwable) {
                Log.i(TAG, p1.message ?: "Unable to get all artists")
            }
        })

        return dataList
    }

}