package s.yarlykov.daggerjunitmock.presenter

class Presenter1(private val activity: IActivity, id : Int) : BasePresenter(id) {
    override fun onActivityCreated() {
        activity.showInfo("${this::class.java.simpleName}::id $id")
    }

    override fun onActivityDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}