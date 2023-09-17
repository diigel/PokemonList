package com.digel.interviewjari.di

import com.digel.interviewjari.data.remote.CardPagingSource
import com.digel.interviewjari.data.remote.CardRemoteDataSource
import com.digel.interviewjari.data.remote.CardRemoteDataSourceImpl
import com.digel.interviewjari.data.remote.Service
import com.digel.interviewjari.data.repository.Repository
import com.digel.interviewjari.data.repository.RepositoryImpl
import com.digel.interviewjari.presenter.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val service = module {
    single { Service.create() }
}

val pagingModule = module {
    single { CardPagingSource(get(),get()) }
}

val dataSourceModule = module {
    single<CardRemoteDataSource> { CardRemoteDataSourceImpl(get()) }
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { CardViewModel(get()) }
}