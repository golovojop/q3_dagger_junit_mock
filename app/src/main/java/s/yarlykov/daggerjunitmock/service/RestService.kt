package s.yarlykov.daggerjunitmock.service

open class RestService {
    open fun getContent(id : Int) : String? =
        if(id in 1..5) {
            "HELLO"
        } else {
            null
        }
}