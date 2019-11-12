package s.yarlykov.daggerjunitmock.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import s.yarlykov.daggerjunitmock.R
import s.yarlykov.daggerjunitmock.application.EducationApp
import s.yarlykov.daggerjunitmock.di.component.DaggerComponent3
import s.yarlykov.daggerjunitmock.logIt
import s.yarlykov.daggerjunitmock.presenter.IActivity
import s.yarlykov.daggerjunitmock.presenter.Presenter3
import javax.inject.Inject

class Activity3 : AppCompatActivity(), IActivity {

    @Inject
    lateinit var presenter : Presenter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerComponent3
            .builder()
            .appModule((application as EducationApp).appModule)
            .addDependency((application as EducationApp).appComponent)
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
        btnBack.setOnClickListener {
            finish()
        }
        btnNext.isEnabled = false
    }
}