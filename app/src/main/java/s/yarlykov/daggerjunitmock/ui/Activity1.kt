package s.yarlykov.daggerjunitmock.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import s.yarlykov.daggerjunitmock.R
import s.yarlykov.daggerjunitmock.application.BaseApp
import s.yarlykov.daggerjunitmock.di.component.DaggerComponent1
import s.yarlykov.daggerjunitmock.logIt
import s.yarlykov.daggerjunitmock.presenter.IActivity
import s.yarlykov.daggerjunitmock.presenter.Presenter1
import javax.inject.Inject

class Activity1 : AppCompatActivity(), IActivity {

    @Inject
    lateinit var presenter : Presenter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComponent1
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

    private fun initView() {
        btnBack.isEnabled = false

        btnNext.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }
}
