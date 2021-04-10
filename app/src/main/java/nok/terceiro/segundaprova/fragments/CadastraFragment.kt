package nok.terceiro.segundaprova.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.CadastraFragmentBinding
import nok.terceiro.segundaprova.fragments.viewmodel.CadastraViewModel

class CadastraFragment : Fragment() {
    private lateinit var viewModel: CadastraViewModel
    private lateinit var binding: CadastraFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.saveAnime.setOnClickListener {
            viewModel.save()
            val action = CadastraFragmentDirections.actionFragmentCadastraToHome()
            Navigation.findNavController(requireView()).navigate(action)
        }
        binding.cancelAnime.setOnClickListener {
            val action = CadastraFragmentDirections.actionFragmentCadastraToHome()
            Navigation.findNavController(requireView()).navigate(action)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu_button){
            var dialog = DialogFragment(R.layout.cadastra_ajuda)
            dialog.show(requireActivity().supportFragmentManager, "cadastra ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}