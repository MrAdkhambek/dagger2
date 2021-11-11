package mr.adkhambek.dagger.di.module

import dagger.Module
import mr.adkhambek.dagger.di.sub.activity.component.ActivityComponent


@Module(subcomponents = [ActivityComponent::class])
class AppModule