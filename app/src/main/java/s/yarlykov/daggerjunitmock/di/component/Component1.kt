/**
 * https://proandroiddev.com/dagger-2-component-builder-1f2b91237856
 */

package s.yarlykov.daggerjunitmock.di.component

import dagger.BindsInstance
import dagger.Component
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.scope.Scope1
import s.yarlykov.daggerjunitmock.ui.Activity1

@Scope1
@Component(modules = [AppModule::class], dependencies = [AppComponent::class])
interface Component1 {

    fun inject(activity: Activity1)

    /**
     * Правила написания кастомного билдера компонента
     * https://dagger.dev/api/latest/dagger/Component.Builder.html
     */
    @Component.Builder
    interface Builder {

        // "Setter" method инжектит инстанс в данный компонент.
        // Теперь его можно использовать, например, передавая в методы модуля.
        @BindsInstance
        fun bindActivity(activity: Activity1): Builder

        // "Setter" method for each component dependency
        fun addDependency(appComponent: AppComponent): Builder

        // Привязка модуля - фабрики инстансов
        fun appModule(module: AppModule): Builder
        fun build(): Component1
    }
}