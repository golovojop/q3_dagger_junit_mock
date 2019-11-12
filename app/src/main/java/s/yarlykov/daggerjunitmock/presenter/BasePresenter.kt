package s.yarlykov.daggerjunitmock.presenter

import s.yarlykov.daggerjunitmock.logIt

abstract class BasePresenter(val id : Int) : IPresenter {
    override fun whoAmI() {
        logIt("Presenter $id")
    }
}