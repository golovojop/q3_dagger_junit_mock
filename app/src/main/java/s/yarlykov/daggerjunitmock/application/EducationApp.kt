package s.yarlykov.daggerjunitmock.application

import android.app.Application
import s.yarlykov.daggerjunitmock.di.component.AppComponent
import s.yarlykov.daggerjunitmock.di.component.DaggerAppComponent
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.module.NetworkModule

class EducationApp : Application() {

    companion object {
        const val baseUrl = "https://api.github.com/"
    }

    lateinit var appComponent: AppComponent
        private set

    lateinit var appModule: AppModule
        private set

    lateinit var netModule : NetworkModule
        private set

    override fun onCreate() {
        super.onCreate()

        appModule = AppModule(this)
        netModule = NetworkModule(baseUrl)

        appComponent = DaggerAppComponent
            .builder()
            .appModule(appModule)
            .networkModule(netModule)
            .build()
    }
}