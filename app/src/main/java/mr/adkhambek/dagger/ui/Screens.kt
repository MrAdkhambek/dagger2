@file:Suppress("FunctionName")

package mr.adkhambek.dagger.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import mr.adkhambek.dagger.ui.main.MainFragment

object Screens {

    @JvmStatic
    fun Main() = FragmentScreen {
        MainFragment()
    }
}