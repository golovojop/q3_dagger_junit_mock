package s.yarlykov.daggerjunitmock.di.component

import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope3
import s.yarlykov.daggerjunitmock.ui.Activity3

@Scope3
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component3 {
    fun inject(activity: Activity3)
}