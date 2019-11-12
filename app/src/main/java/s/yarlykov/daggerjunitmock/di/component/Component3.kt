package s.yarlykov.daggerjunitmock.di.component

import dagger.BindsInstance
import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope3
import s.yarlykov.daggerjunitmock.ui.Activity2
import s.yarlykov.daggerjunitmock.ui.Activity3

@Scope3
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component3 {
    fun inject(activity: Activity3)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindActivity(activity: Activity3): Builder
        fun addDependency(appComponent: AppComponent): Builder
        fun appModule(module: AppModule): Builder
        fun build(): Component3
    }
}