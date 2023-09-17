package com.digel.interviewjari.data.remote

import com.digel.interviewjari.data.response.CardListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    companion object {
        const val CARD = "cards"
        fun create() : Service {
            return Network.build().create(Service::class.java)
        }
    }

    @GET(CARD)
    suspend fun getCard(
        @Query("q") query: String? = null,
        @Query("page") page : Int? = null,
        @Query("pageSize") pageSize : Int? = null
    ) : CardListResponse
}