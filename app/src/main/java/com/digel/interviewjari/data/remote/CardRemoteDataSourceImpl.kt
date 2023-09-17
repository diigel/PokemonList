package com.digel.interviewjari.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.digel.interviewjari.data.response.CardListResponse
import kotlinx.coroutines.flow.Flow

class CardRemoteDataSourceImpl(private val service: Service)  : CardRemoteDataSource {

    override fun getCard(query: String?): Flow<PagingData<CardListResponse.Data>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CardPagingSource(service = service, query = query.orEmpty())
            }
        ).flow
    }
}