package nok.terceiro.segundaprova.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nok.terceiro.segundaprova.R

class CadastraFragment : Fragment() {

    companion object {
        fun newInstance() = CadastraFragment()
    }

    private lateinit var viewModel: CadastraViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cadastra_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        // TODO: Use the ViewModel
    }

}