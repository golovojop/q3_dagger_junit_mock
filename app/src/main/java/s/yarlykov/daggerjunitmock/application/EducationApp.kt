package s.yarlykov.daggerjunitmock.application

import android.app.Application
import s.yarlykov.daggerjunitmock.di.component.AppComponent
import s.yarlykov.daggerjunitmock.di.component.DaggerAppComponent
import s.yarlykov.daggerjunitmock.di.module.AppModule
import s.yarlykov.daggerjunitmock.di.module.NetworkModule
import s.yarlykov.daggerjunitmock.logIt

open class EducationApp : Application(), BaseApp {

    companion object {
        const val baseUrl = "https://api.github.com/"
    }

    override lateinit var appComponent: AppComponent
    override lateinit var appModule: AppModule
    override lateinit var netModule : NetworkModule

    override fun onCreate() {
        super.onCreate()
        logIt("${this.javaClass.simpleName}::onCreate()")

        appModule = AppModule(this)
        netModule = NetworkModule(baseUrl)

        appComponent = DaggerAppComponent
            .builder()
            .appModule(appModule)
            .networkModule(netModule)
            .build()
    }
}