package s.yarlykov.daggerjunitmock.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import s.yarlykov.daggerjunitmock.R
import s.yarlykov.daggerjunitmock.application.BaseApp
import s.yarlykov.daggerjunitmock.application.EducationApp
import s.yarlykov.daggerjunitmock.di.component.DaggerComponent2
import s.yarlykov.daggerjunitmock.logIt
import s.yarlykov.daggerjunitmock.presenter.IActivity
import s.yarlykov.daggerjunitmock.presenter.Presenter2
import javax.inject.Inject

class Activity2  : AppCompatActivity(), IActivity {

    @Inject
    lateinit var presenter : Presenter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComponent2
            .builder()
            .appModule((application as BaseApp).appModule)
            .addDependency((application as BaseApp).appComponent)
            .bindActivity(this)
            .build()

        component.inject(this)

        presenter.onActivityCreated()

        initView()
    }

    override fun showInfo(info: String) {
        val message = "${this::class.java.simpleName}::showInfo - $info"
        tvInfo.text = message
        logIt(message)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun initView() {
        btnBack.setOnClickListener {
            finish()
        }
        btnNext.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }
    }
}