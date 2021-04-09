package nok.terceiro.segundaprova.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
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

        return binding.root
    }
}