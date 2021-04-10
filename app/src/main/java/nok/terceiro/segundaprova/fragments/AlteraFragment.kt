package nok.terceiro.segundaprova.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.AlteraFragmentBinding
import nok.terceiro.segundaprova.fragments.viewmodel.AlteraViewModel

class AlteraFragment : Fragment() {
    private lateinit var viewModel: AlteraViewModel
    private lateinit var binding: AlteraFragmentBinding
    val args:AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(AlteraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.altera_fragment, container, false)
        binding.lifecycleOwner = this
        viewModel.setAnimeValue(args.id)
        binding.viewmodel = viewModel

        binding.saveAnime.setOnClickListener {
            viewModel.atualizar()
            val action = AlteraFragmentDirections.actionFragmentAlteraToHome()
            Navigation.findNavController(requireView()).navigate(action)
        }
        binding.cancelAnime.setOnClickListener {
            val action = AlteraFragmentDirections.actionFragmentAlteraToHome()
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
            var dialog = DialogFragment(R.layout.altera_ajuda)
            dialog.show(requireActivity().supportFragmentManager, "altera ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}