package nok.terceiro.segundaprova.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.CadastraFragmentBinding
import nok.terceiro.segundaprova.databinding.FragmentHomeBinding

class CadastraFragment : Fragment() {
    private lateinit var viewModel: CadastraViewModel
    private lateinit var binding: CadastraFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        return binding.root
    }

}