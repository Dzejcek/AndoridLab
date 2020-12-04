package com.example.championslist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.championslist.dummy.ChampionsContent.Champion
import com.example.championslist.dummy.ChampionsContent.ITEMS
import com.example.championslist.dummy.ChampionsContent.currentChampion
import kotlinx.android.synthetic.main.fragment_item.view.*


class MyItemRecyclerViewAdapter(
    private val values: List<Champion>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        view.champion_card.setOnClickListener {
            val msg = view.champ_name.text.toString()
            currentChampion = msg
            val action = ItemFragmentDirections.hostToViewPager(msg)
            view.findNavController().navigate(action)
            }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.championName.text = item.name
        holder.category.text = item.category
        holder.icon.setImageResource(item.iconId)
        holder.favButton.setOnClickListener {item.isFav = !item.isFav; if(item.isFav) holder.favButton.setImageResource(R.drawable.fav_red) else holder.favButton.setImageResource(R.drawable.fav) }
        if(item.isFav)
            holder.favButton.setImageResource(R.drawable.fav_red)
        else
            holder.favButton.setImageResource(R.drawable.fav)

    }

    override fun getItemCount(): Int = values.size

    fun removeItem(view: View, position: Int){
        ITEMS.remove((values as ArrayList)[position])
        values.removeAt(position)
        notifyItemRemoved(position)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val championName: TextView = view.champ_name
        val category: TextView = view.category
        val icon: ImageView = view.champ_icon
        val favButton : ImageButton = view.favButton

        override fun toString(): String {
            return super.toString() + " '" + category.text + "'"
        }
    }
}