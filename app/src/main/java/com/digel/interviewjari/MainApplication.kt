package com.digel.interviewjari

import android.app.Application
import com.digel.interviewjari.di.dataSourceModule
import com.digel.interviewjari.di.pagingModule
import com.digel.interviewjari.di.repositoryModule
import com.digel.interviewjari.di.service
import com.digel.interviewjari.di.viewModelModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                service,
                pagingModule,
                dataSourceModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}