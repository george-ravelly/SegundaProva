package nok.terceiro.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.FragmentDetalhesBinding
import nok.terceiro.segundaprova.fragments.viewmodel.AnimeViewModel

class DetalhesFragment : Fragment() {
    private lateinit var viewModel: AnimeViewModel
    private lateinit var binding: FragmentDetalhesBinding
    val args:DetalhesFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        viewModel = ViewModelProvider(this).get(AnimeViewModel::class.java)
        viewModel.setAnime(args.id)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu_button){
            var dialog = DialogFragment(R.layout.detalhes_ajuda)
            dialog.show(requireActivity().supportFragmentManager, "detalhes ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}