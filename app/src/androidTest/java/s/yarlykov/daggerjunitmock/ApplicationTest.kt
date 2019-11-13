package s.yarlykov.daggerjunitmock

import s.yarlykov.daggerjunitmock.application.EducationApp

class ApplicationTest : EducationApp() {

    companion object {
        const val baseUrl = "http://127.0.0.1:8080"
    }

    override fun onCreate() {
        super.onCreate()
        logIt("${this.javaClass.simpleName}::onCreate()")
    }
}