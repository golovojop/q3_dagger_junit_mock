package s.yarlykov.daggerjunitmock.di.component

import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope2
import s.yarlykov.daggerjunitmock.ui.Activity2

@Scope2
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component2 {
    fun inject(activity: Activity2)
}