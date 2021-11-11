package mr.adkhambek.dagger.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mr.adkhambek.dagger.di.vm.ViewModelKey
import mr.adkhambek.dagger.ui.main.MainViewModel


@Module
interface BindModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(bind: MainViewModel): ViewModel
}
