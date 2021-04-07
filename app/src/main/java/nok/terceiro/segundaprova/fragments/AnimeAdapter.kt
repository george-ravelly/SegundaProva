package nok.terceiro.segundaprova.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nok.terceiro.segundaprova.R
import nok.terceiro.segundaprova.model.Anime

class AnimeAdapter:RecyclerView.Adapter<AnimeViewHolder>(){
    var animes:List<Anime> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_home_inflater, parent, false)
        val holder = AnimeViewHolder(view)
        return holder
    }
    override fun getItemCount(): Int {
        return animes.size
    }
    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        var anime = animes[position]
        holder.animeName.text = anime.name
        holder.animeAuthor.text = anime.author
    }
}