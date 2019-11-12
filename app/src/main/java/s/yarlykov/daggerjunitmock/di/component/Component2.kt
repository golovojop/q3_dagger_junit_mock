package s.yarlykov.daggerjunitmock.di.component

import dagger.BindsInstance
import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope2
import s.yarlykov.daggerjunitmock.ui.Activity1
import s.yarlykov.daggerjunitmock.ui.Activity2

@Scope2
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component2 {
    fun inject(activity: Activity2)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindActivity(activity: Activity2): Builder
        fun addDependency(appComponent: AppComponent): Builder
        fun appModule(module: AppModule): Builder
        fun build(): Component2
    }
}