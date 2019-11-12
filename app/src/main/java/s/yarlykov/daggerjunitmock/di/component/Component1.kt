package s.yarlykov.daggerjunitmock.di.component

import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope1
import s.yarlykov.daggerjunitmock.ui.Activity1

@Scope1
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component1 {
    fun inject(activity: Activity1)
}