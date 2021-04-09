package nok.terceiro.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
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
            listAdapter.notifyDataSetChanged()
        })
        val navController = Navigation.findNavController((activity as AppCompatActivity),R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController((activity as AppCompatActivity), navController,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        recyclerViewUp(listAdapter)
        binding.recyclerviewhome.addOnItemTouchListener(RecyclerViewClickListener(requireContext(), binding.recyclerviewhome,
            object: RecyclerViewClickListener.OnItemClickListener{
                override fun onItemClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionFragmentHomeToDetalhes(position+1)
                    Navigation.findNavController(binding.recyclerviewhome).navigate(action)
                }
                override fun onItemLongClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionFragmentHomeToAltera(position+1)
                    Navigation.findNavController(binding.recyclerviewhome).navigate(action)
                }
        }))

        setHasOptionsMenu(true)
        return binding.root
    }

    fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController((activity as AppCompatActivity), R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }

    fun recyclerViewUp(adapter:AnimeAdapter){
        binding.recyclerviewhome.adapter = adapter
        binding.recyclerviewhome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
    }
}