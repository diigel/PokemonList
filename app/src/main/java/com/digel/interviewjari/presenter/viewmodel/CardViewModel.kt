package com.digel.interviewjari.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.digel.interviewjari.data.remote.CardRemoteDataSource
import com.digel.interviewjari.data.response.CardListResponse
import kotlinx.coroutines.flow.Flow

class CardViewModel(private val cardDataSource: CardRemoteDataSource) : ViewModel() {

    fun getMovies(query: String): Flow<PagingData<CardListResponse.Data>> {
        return cardDataSource.getCard(query).cachedIn(viewModelScope)
    }
}