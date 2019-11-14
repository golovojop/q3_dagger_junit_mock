package s.yarlykov.daggerjunitmock

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import s.yarlykov.daggerjunitmock.ui.Activity1

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule =
        ActivityTestRule<Activity1>(Activity1::class.java,false,false)

    private val response = MockResponse().apply {
        addHeader("Content-Type", "application/json; charset=utf-8")
        addHeader("Cache-Control", "no-cache")
        setBody(gitResponce())
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

//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("s.yarlykov.daggerjunitmock", appContext.packageName)
//    }

}