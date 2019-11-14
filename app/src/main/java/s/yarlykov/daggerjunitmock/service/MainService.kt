package s.yarlykov.daggerjunitmock.service

import javax.inject.Inject

class MainService @Inject constructor(
    val restService: RestService,
    val printService: PrintService) {

    open fun handleRequest(itemId : Int) {

        restService.also {rs ->
            rs.getContent(itemId)?.let {content ->
                printService.printContent(content)
                return
            }
            throw IllegalStateException("Content with id $itemId not found")
        }
    }
}


