package com.github.fire.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.fire.api.RetroUser
import com.github.fire.data.model.DetUserRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetUsrViewModel : ViewModel(){
    val user = MutableLiveData<DetUserRes>()

    fun setUserDetail(username: String){
        RetroUser.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetUserRes> {
                override fun onFailure(call: Call<DetUserRes>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

                override fun onResponse(
                    call: Call<DetUserRes>,
                    response: Response<DetUserRes>
                ) {
                    if(response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

            })
    }

    fun getUserDetail() : LiveData<DetUserRes> {
        return user
    }

}