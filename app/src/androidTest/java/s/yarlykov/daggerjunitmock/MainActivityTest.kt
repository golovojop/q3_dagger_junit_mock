package s.yarlykov.daggerjunitmock

import android.content.Intent
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.gson.Gson
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.*
import org.junit.*
import org.junit.runner.RunWith
import s.yarlykov.daggerjunitmock.domain.UserGit
import s.yarlykov.daggerjunitmock.ui.Activity1
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule<Activity1>(Activity1::class.java,false,false)

    private val response = MockResponse().apply {

        val json = Gson().toJson(arrayOf(
            UserGit(1, "mars", "", ""),
            UserGit(2, "venus", "", "")))

        throttleBody(32, 1, TimeUnit.SECONDS)

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
    fun shouldBeCorrectIntent() {
        activityRule.launchActivity(
            Intent(Intent.ACTION_MAIN).apply {
                putExtra("KEY_HELLO", "MESSAGE_HELLO")
            }
        )

        val activity = activityRule.activity
        val tv = activity.findViewById<TextView>(R.id.tvInfo)
        assertThat(tv, notNullValue())
        assertThat(tv.text.toString(), `is`("MESSAGE_HELLO"))
    }

    @Test
    fun shouldHideProgressBarAfterDataLoaded() {
        activityRule.launchActivity(Intent())
        Espresso.onView(withId(R.id.pbLoading)).check(matches(not(isDisplayed())))
        Espresso.onView(withId(R.id.tvInfo)).check(matches(isDisplayed()))
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

}