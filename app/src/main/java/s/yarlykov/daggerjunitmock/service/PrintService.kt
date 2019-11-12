package s.yarlykov.daggerjunitmock.service

import s.yarlykov.daggerjunitmock.logIt

class PrintService {
    fun printContent(content : String) = logIt(content)
}