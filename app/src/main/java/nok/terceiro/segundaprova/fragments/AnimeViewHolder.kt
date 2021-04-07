package nok.terceiro.segundaprova.fragments

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nok.terceiro.segundaprova.R

class AnimeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var animeName: TextView
    var animeAuthor: TextView
    init {
        animeName = v.findViewById(R.id.animeName)
        animeAuthor = v.findViewById(R.id.animeAuthor)
    }

}
