package mr.adkhambek.dagger.di.sub.activity.component

import dagger.BindsInstance
import dagger.Subcomponent
import mr.adkhambek.dagger.di.sub.activity.module.ActivityModule
import mr.adkhambek.dagger.di.sub.activity.module.StringModule
import mr.adkhambek.dagger.di.sub.activity.scope.ActivityScope
import mr.adkhambek.dagger.di.sub.fragment.component.FragmentComponent
import mr.adkhambek.dagger.ui.MainActivity
import mr.adkhambek.dagger.di.module.BindModule


@[ActivityScope Subcomponent(
    modules = [
        ActivityModule::class,
        StringModule::class,
        BindModule::class
    ],
)]
interface ActivityComponent {

    val fragmentComponent: FragmentComponent.Builder

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ActivityComponent

        // @BindsInstance replaces Builder appModule(AppModule appModule)
        // And removes Constructor with Application AppModule(Application)
        @BindsInstance
        fun activity(activity: MainActivity): Builder
    }
}