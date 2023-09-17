package com.digel.interviewjari.data.remote

import androidx.paging.PagingData
import com.digel.interviewjari.data.response.CardListResponse
import kotlinx.coroutines.flow.Flow

interface CardRemoteDataSource {

    fun getCard(query : String? = null): Flow<PagingData<CardListResponse.Data>>
}