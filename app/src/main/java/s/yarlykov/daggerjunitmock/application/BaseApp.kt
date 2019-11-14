package s.yarlykov.daggerjunitmock.application

import s.yarlykov.daggerjunitmock.di.component.AppComponent
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.module.NetworkModule

interface BaseApp {
    val appComponent: AppComponent
    val appModule: AppModule
    val netModule: NetworkModule
}