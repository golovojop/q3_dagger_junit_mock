package s.yarlykov.daggerjunitmock

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.gson.Gson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import s.yarlykov.daggerjunitmock.domain.UserGit
import s.yarlykov.daggerjunitmock.ui.Activity1

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule =
        ActivityTestRule<Activity1>(Activity1::class.java,false,false)

    private val response = MockResponse().apply {

        val json = Gson().toJson(arrayOf(
            UserGit(1, "mars", "", ""),
            UserGit(2, "venera", "", "")))

        addHeader("Content-Type", "application/json; charset=utf-8")
        addHeader("Cache-Control", "no-cache")
        setBody(json)
    }

    private var mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.enqueue(response)
        mockWebServer.start(8080)
    }

    @Test
    fun someTest() {
        activityRule.launchActivity(Intent())

    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

}