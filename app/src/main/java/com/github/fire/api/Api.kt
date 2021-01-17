package com.github.fire.api

import com.github.fire.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 136065ca6c3ee890166b9918a704816ce3eb26a4")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UsrResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 136065ca6c3ee890166b9918a704816ce3eb26a4")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetUserRes>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 136065ca6c3ee890166b9918a704816ce3eb26a4")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 136065ca6c3ee890166b9918a704816ce3eb26a4")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}