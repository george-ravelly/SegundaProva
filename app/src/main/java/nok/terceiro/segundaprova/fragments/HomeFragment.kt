package nok.terceiro.segundaprova.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.databinding.FragmentHomeBinding
import nok.terceiro.segundaprova.fragments.viewmodel.HomeViewModel


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

        recyclerViewUp(listAdapter)
        binding.recyclerviewhome.addOnItemTouchListener(RecyclerViewClickListener(requireContext(), binding.recyclerviewhome,
            object: RecyclerViewClickListener.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    val action = HomeFragmentDirections.actionFragmentHomeToDetalhes(position+1)
                    Navigation.findNavController(binding.recyclerviewhome).navigate(action)
                }
                override fun onItemLongClick(view: View, position: Int) {
                    val action = HomeFragmentDirections.actionFragmentHomeToAltera(position+1)
                    Navigation.findNavController(binding.recyclerviewhome).navigate(action)
                }
        }))
        setHasOptionsMenu(true)
        return binding.root
    }


    fun recyclerViewUp(adapter:AnimeAdapter){
        binding.recyclerviewhome.adapter = adapter
        binding.recyclerviewhome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu_button){
            var dialog = DialogFragment(R.layout.home_ajuda)
            dialog.show(requireActivity().supportFragmentManager, "home ajuda")
        }

        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView()))||
                super.onOptionsItemSelected(item)
    }
}