package s.yarlykov.daggerjunitmock

import s.yarlykov.daggerjunitmock.application.EducationApp
import s.yarlykov.daggerjunitmock.di.module.NetworkModule


class EducationAppTest : EducationApp() {

    companion object {
        const val baseUrl = "http://localhost:8080/"
    }

    override val netModule: NetworkModule by lazy (LazyThreadSafetyMode.NONE) {
        NetworkModule(baseUrl)
    }

    override fun onCreate() {
        super.onCreate()
        logIt("${this.javaClass.simpleName}::onCreate()")
    }


}