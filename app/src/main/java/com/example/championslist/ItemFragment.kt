package com.example.championslist

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.championslist.dummy.ChampionsContent
import com.example.championslist.dummy.ChampionsContent.ITEMS
import com.example.championslist.dummy.ChampionsContent.categoriesSelected
import com.example.championslist.viewPager.ViewPagerFragment


class ItemFragment : Fragment() {

    private var columnCount = 1
    private var myAdapter =  MyItemRecyclerViewAdapter(ChampionsContent.itemsCopy)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = myAdapter
                val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(myAdapter));
                itemTouchHelper.attachToRecyclerView(view);
            }
        }
        return view
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_items, menu);
        super.onCreateOptionsMenu(menu, inflater)
        for (i in 0 until menu.size())
            restoreMenuValues(menu.getItem(i))

    }


    private fun actOnItemSelection(item: MenuItem, categoryName: String) {
        item.isChecked =  !item.isChecked
        if(item.isChecked)
            categoriesSelected.add(categoryName)
        else
            categoriesSelected.remove(categoryName)
    }

    private fun restoreMenuValues(item: MenuItem) {
        for(cat in categoriesSelected) {
            if(cat == item.title)
                item.isChecked = true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mage -> {
                actOnItemSelection(item, resources.getString(R.string.mage))
            }
            R.id.marksman -> {
                actOnItemSelection(item, resources.getString(R.string.marksman))
            }
            R.id.bruiser -> {
                actOnItemSelection(item, resources.getString(R.string.bruiser))
            }
            R.id.favourite -> {
                actOnItemSelection(item, resources.getString(R.string.favourite))
            }
            else -> super.onOptionsItemSelected(item)
        }
        chooseByCat(ChampionsContent.itemsCopy)

        return true
    }

    private fun checkCat(champion: ChampionsContent.Champion): Boolean {
        for (cat in categoriesSelected){
            if(champion.category == cat || (champion.isFav && cat == resources.getString(R.string.favourite)))
                return true
        }
        return false
    }


    private fun chooseByCat(champsList: MutableList<ChampionsContent.Champion>){
        Log.e("after delete", ITEMS.toString())
        champsList.clear()
        for(item in ChampionsContent.ITEMS.filter { champion -> checkCat(champion) }) {
            champsList.add(item);
        }
        myAdapter.notifyDataSetChanged()
    }


    inner class SwipeToDeleteCallback(private val adapter: MyItemRecyclerViewAdapter):
        ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP, ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            adapter.removeItem(viewHolder.itemView , position)
        }
    }



    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }


    }