package s.yarlykov.daggerjunitmock.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import s.yarlykov.daggerjunitmock.data.GitHelper
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules=[AppModule::class, NetworkModule::class])

interface AppComponent {
    fun getContext() : Context
    fun getApplication() : Application
    fun getGitHelper() : GitHelper
}