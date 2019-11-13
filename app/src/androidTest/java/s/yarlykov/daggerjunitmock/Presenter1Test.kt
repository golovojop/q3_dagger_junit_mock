package s.yarlykov.daggerjunitmock

import androidx.test.runner.AndroidJUnit4
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import s.yarlykov.daggerjunitmock.ui.Activity1

@RunWith(AndroidJUnit4::class)
//@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class Presenter1Test {

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

    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}