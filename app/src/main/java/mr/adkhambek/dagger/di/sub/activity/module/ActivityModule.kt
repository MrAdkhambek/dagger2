package mr.adkhambek.dagger.di.sub.activity.module

import dagger.Module
import mr.adkhambek.dagger.di.sub.activity.component.ActivityComponent
import mr.adkhambek.dagger.di.sub.fragment.component.FragmentComponent


@Module(subcomponents = [FragmentComponent::class])
class ActivityModule