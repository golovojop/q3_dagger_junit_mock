package s.yarlykov.daggerjunitmock.presenter

import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import s.yarlykov.daggerjunitmock.data.GitHelper
import s.yarlykov.daggerjunitmock.domain.User
import s.yarlykov.daggerjunitmock.logIt
import java.util.concurrent.TimeUnit

class Presenter1(private val activity: IActivity, private val gitHelper: GitHelper, id : Int) : BasePresenter(id) {
    override fun onActivityCreated() {

        gitHelper
            .getUsers()
//            .delay(5, TimeUnit.SECONDS)             // <-- For test only
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)

        activity.showLoading()
    }

    override fun onActivityDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val subscriber = object : SingleObserver<List<User>> {

        override fun onSuccess(t: List<User>) {
            activity.showInfo("${t.size} records received")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            logIt("Presenter1::onError ${e.message.toString()}")
        }
    }
}