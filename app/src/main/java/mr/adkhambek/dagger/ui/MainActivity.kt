package mr.adkhambek.dagger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import mr.adkhambek.dagger.R
import mr.adkhambek.dagger.di.ApplicationComponent
import mr.adkhambek.dagger.di.ComponentHolder
import mr.adkhambek.dagger.di.sub.activity.component.ActivityComponent
import javax.inject.Inject


class MainActivity :
    AppCompatActivity(R.layout.main_activity),
    ComponentHolder<ActivityComponent> {

    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder
    private val navigator: Navigator = object : AppNavigator(this, R.id.main_container) {}

    override val component: ActivityComponent by lazy {
        @Suppress("UNCHECKED_CAST")
        val appComponent = (application as ComponentHolder<ApplicationComponent>).component
        appComponent.activityComponent.activity(this).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        if (savedInstanceState == null) {
            router.replaceScreen(Screens.Main())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}