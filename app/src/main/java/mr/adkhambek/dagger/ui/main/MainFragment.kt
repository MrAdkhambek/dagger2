package mr.adkhambek.dagger.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mr.adkhambek.dagger.R
import mr.adkhambek.dagger.di.ComponentHolder
import mr.adkhambek.dagger.di.sub.activity.component.ActivityComponent
import mr.adkhambek.dagger.di.sub.fragment.component.FragmentComponent
import mr.adkhambek.dagger.di.vm.ViewModelFactory
import javax.inject.Inject

class MainFragment :
    Fragment(R.layout.main_fragment),
    ComponentHolder<FragmentComponent> {

    @Inject
    lateinit var text: String

    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    private lateinit var vm: MainViewModel

    override val component: FragmentComponent by lazy {
        val activityComponent = (requireActivity() as ComponentHolder<ActivityComponent>).component
        activityComponent.fragmentComponent.build()
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
        vm = ViewModelProvider(this, factory = viewModelFactory)[MainViewModel::class.java]
        Toast.makeText(context, vm.text, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.message).text = text
    }
}