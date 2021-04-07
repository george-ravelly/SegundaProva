package nok.terceiro.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var homeViewModel : HomeViewModel
    lateinit var binding:FragmentHomeBinding
    var listAdapter = AnimeAdapter()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.list.observe(viewLifecycleOwner, {
            listAdapter.animes = it
            Log.i("BANCO", it.toString())
            listAdapter.notifyDataSetChanged()
        })


        recyclerViewUp(listAdapter)
        return binding.root
    }

    fun recyclerViewUp(adapter:AnimeAdapter){
        binding.recyclerviewhome.adapter = adapter
        binding.recyclerviewhome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
    }
}