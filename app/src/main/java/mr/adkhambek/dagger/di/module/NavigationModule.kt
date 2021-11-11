package mr.adkhambek.dagger.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import mr.adkhambek.dagger.di.AppScope


@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @AppScope
    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @AppScope
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}