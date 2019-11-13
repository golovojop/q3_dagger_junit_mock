package s.yarlykov.daggerjunitmock.service

import s.yarlykov.daggerjunitmock.logIt

open class PrintService {
    open fun printContent(content: String) = logIt(content)
}