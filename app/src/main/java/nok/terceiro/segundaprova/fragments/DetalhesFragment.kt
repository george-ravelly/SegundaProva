package nok.terceiro.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
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
        return binding.root
    }
}