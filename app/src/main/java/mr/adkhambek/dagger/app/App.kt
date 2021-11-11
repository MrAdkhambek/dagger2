package mr.adkhambek.dagger.app

import android.app.Application
import mr.adkhambek.dagger.di.ApplicationComponent
import mr.adkhambek.dagger.di.ComponentHolder
import mr.adkhambek.dagger.di.DaggerApplicationComponent


class App : Application(), ComponentHolder<ApplicationComponent> {

    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }
}

