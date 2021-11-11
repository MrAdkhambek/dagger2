package mr.adkhambek.dagger.di.sub.activity.module

import dagger.Module
import dagger.Provides
import mr.adkhambek.dagger.di.sub.activity.scope.ActivityScope
import kotlin.random.Random


@Module
class StringModule {

    @Provides
    @ActivityScope
    fun provideInt(): String {
        return Random.nextInt().toString()
    }
}