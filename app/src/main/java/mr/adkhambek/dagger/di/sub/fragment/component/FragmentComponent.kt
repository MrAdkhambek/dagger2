package mr.adkhambek.dagger.di.sub.fragment.component

import dagger.Subcomponent
import mr.adkhambek.dagger.di.sub.fragment.scope.FragmentScope
import mr.adkhambek.dagger.ui.main.MainFragment


@[FragmentScope Subcomponent(
    modules = [],
)]
interface FragmentComponent {

    fun inject(mainFragment: MainFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentComponent
    }
}