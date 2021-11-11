package mr.adkhambek.dagger.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import mr.adkhambek.dagger.di.module.AppModule
import mr.adkhambek.dagger.di.module.NavigationModule
import mr.adkhambek.dagger.di.sub.activity.component.ActivityComponent


@[AppScope Component(
    modules = [
        AppModule::class,
        NavigationModule::class
    ],
)]
interface ApplicationComponent {

    val activityComponent: ActivityComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): ApplicationComponent

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun application(application: Application): Builder
    }
}