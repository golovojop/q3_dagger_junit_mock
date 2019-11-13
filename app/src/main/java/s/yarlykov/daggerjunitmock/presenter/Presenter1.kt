package s.yarlykov.daggerjunitmock.presenter

import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import s.yarlykov.daggerjunitmock.data.GitHelper
import s.yarlykov.daggerjunitmock.domain.User
import s.yarlykov.daggerjunitmock.logIt

class Presenter1(private val activity: IActivity, private val gitHelper: GitHelper, id : Int) : BasePresenter(id) {
    override fun onActivityCreated() {
        gitHelper
            .getUsers()
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
    }

    override fun onActivityDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val subscriber = object : SingleObserver<List<User>> {

        override fun onSuccess(t: List<User>) {
            activity.showInfo("${t.size} records reseived")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            logIt(e.message.toString())
        }
    }
}