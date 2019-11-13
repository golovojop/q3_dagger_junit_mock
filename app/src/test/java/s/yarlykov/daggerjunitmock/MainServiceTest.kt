package s.yarlykov.daggerjunitmock

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import s.yarlykov.daggerjunitmock.service.MainService
import s.yarlykov.daggerjunitmock.service.PrintService
import s.yarlykov.daggerjunitmock.service.RestService

@RunWith(MockitoJUnitRunner::class)
class MainServiceTest {

    lateinit var mockRestService: RestService
    lateinit var mockPrintService: PrintService
    lateinit var mainService: MainService

    @Before
    fun mockDependecies() {
        mockRestService = mock(RestService::class.java)
        mockPrintService = mock(PrintService::class.java)
        mainService = MainService(mockRestService, mockPrintService)
    }

    @Test
    fun test_RestService_getContent_parameter() {
        val param = 1
        `when`(mockRestService.getContent(anyInt())).thenReturn("")

        mainService.handleRequest(param)
        verify(mockRestService).getContent(param)
    }

    @Test
    fun test_PrintService_printContent_parameter() {
        val param = 5
        val result = "hello".toUpperCase()

        `when`(mockRestService.getContent(param)).thenReturn(result)

        mainService.handleRequest(param)
        verify(mockPrintService).printContent(result)
    }

    @Test(expected = IllegalStateException::class)
    fun test_InvalidArgument() {
        `when`(mockRestService.getContent(anyInt())).thenReturn(null)
        mainService.handleRequest(0)
    }
}