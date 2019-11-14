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

    override val appModule: AppModule by lazy (LazyThreadSafetyMode.NONE) {
        AppModule(this)
    }
    override val appComponent : AppComponent by lazy (LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .builder()
            .appModule(appModule)
            .networkModule(netModule)
            .build()
    }
    override val netModule: NetworkModule by lazy (LazyThreadSafetyMode.NONE) {
        NetworkModule(baseUrl)
    }

    override fun onCreate() {
        super.onCreate()
        logIt("${this.javaClass.simpleName}::onCreate()")
    }
}