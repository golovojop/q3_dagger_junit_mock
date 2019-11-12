package s.yarlykov.daggerjunitmock.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules=[AppModule::class])

interface AppComponent {
    fun getContext() : Context
    fun getApplication() : Application
}