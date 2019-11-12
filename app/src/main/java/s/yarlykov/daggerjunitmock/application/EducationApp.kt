package s.yarlykov.daggerjunitmock.application

import android.app.Application
import s.yarlykov.daggerjunitmock.di.component.AppComponent
import s.yarlykov.daggerjunitmock.di.component.DaggerAppComponent
import s.yarlykov.daggerjunitmock.di.module.AppModule

class EducationApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    lateinit var appModule: AppModule
        private set

    override fun onCreate() {
        super.onCreate()

        appModule = AppModule(this)

        appComponent = DaggerAppComponent
            .builder()
            .appModule(appModule)
            .build()
    }
}