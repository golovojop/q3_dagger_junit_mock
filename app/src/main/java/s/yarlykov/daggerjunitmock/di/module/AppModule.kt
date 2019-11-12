package s.yarlykov.daggerjunitmock.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import s.yarlykov.daggerjunitmock.di.scope.Scope1
import s.yarlykov.daggerjunitmock.di.scope.Scope2
import s.yarlykov.daggerjunitmock.di.scope.Scope3
import s.yarlykov.daggerjunitmock.presenter.Presenter1
import s.yarlykov.daggerjunitmock.presenter.Presenter2
import s.yarlykov.daggerjunitmock.presenter.Presenter3
import s.yarlykov.daggerjunitmock.ui.Activity1
import s.yarlykov.daggerjunitmock.ui.Activity2
import s.yarlykov.daggerjunitmock.ui.Activity3
import javax.inject.Singleton

@Module
class AppModule (private val application: Application) {

    private var presenterId = 1

    @Provides
    @Singleton
    fun provideContext() : Context = application

    @Provides
    @Singleton
    fun provideApplication() : Application = application

    @Scope1
    @Provides
    fun providePresenter1(activity : Activity1) : Presenter1 = Presenter1(activity, presenterId++)

    @Scope2
    @Provides
    fun providePresenter2(activity : Activity2) : Presenter2 = Presenter2(activity, presenterId++)

    @Scope3
    @Provides
    fun providePresenter3(activity : Activity3) : Presenter3 = Presenter3(activity, presenterId++)
}