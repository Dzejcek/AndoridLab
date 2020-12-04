package com.example.championslist.content

import com.example.championslist.R
import java.util.ArrayList

object ChampionsContent {

    var ITEMS: MutableList<Champion>
    var itemsCopy : MutableList<Champion>
    var categoriesSelected = ArrayList<String>()
    val contentMap = generateChampionsContent()
    var currentChampion = ""
    private val COUNT = 25

    init {
        ITEMS = generateList()
        itemsCopy = ITEMS.toMutableList()

    }

    private fun generateList(): MutableList<Champion> {
        val list = ArrayList<Champion>()
        list.add(Champion("Lee sin", "Bruiser" , R.drawable.lee, false))
        list.add(Champion("Braum", "Bruiser" , R.drawable.braum, false))
        list.add(Champion("Jayce", "Bruiser" , R.drawable.jayce, false))
        list.add(Champion("Syndra", "Mage" , R.drawable.syndra, false))
        list.add(Champion("Jhin", "Marksman" , R.drawable.jhin, false))
        list.add(Champion("Zed", "Mage" , R.drawable.zed, false))
        list.add(Champion("Xayah", "Marksman" , R.drawable.xayah, false))
        list.add(Champion("Vladimir", "Mage" , R.drawable.vlad,false))
        return list.toMutableList()
    }

    private fun generateChampionsContent(): Map<String, Content> {
        return mapOf(
            "Lee sin" to Content(arrayListOf(R.drawable.lee_nightbringer, R.drawable.lee_god, R.drawable.lee_thai, R.drawable.lee_traditional),
                arrayListOf(R.drawable.lee_passive, R.drawable.lee_q, R.drawable.lee_w, R.drawable.lee_e, R.drawable.lee_r),
                R.array.lee_abilities, R.string.lee_hisotry),
            "Braum" to Content(arrayListOf(R.drawable.braum_dragonslayer, R.drawable.braum_gold, R.drawable.braum_tiger),
                arrayListOf(R.drawable.braum_passive, R.drawable.braum_q, R.drawable.braum_w, R.drawable.braum_e, R.drawable.braum_r),
                R.array.braum_abilities, R.string.braum_hisotry),
            "Syndra" to Content(arrayListOf(R.drawable.syndra_gold, R.drawable.syndra_ocean, R.drawable.syndra_star),
                arrayListOf(R.drawable.syndra_passive, R.drawable.syndra_q, R.drawable.syndra_w, R.drawable.syndra_e, R.drawable.syndra_r),
                R.array.syndra_abilities, R.string.syndra_history),
            "Jayce" to Content(arrayListOf(R.drawable.jayce_battle, R.drawable.jayce_forsaken, R.drawable.jayce_metal),
                arrayListOf(R.drawable.jayce_passive, R.drawable.jayce_q,  R.drawable.jayce_w, R.drawable.jayce_e, R.drawable.jayce_r),
                R.array.jayce_abilities, R.string.jayce_history),
            "Xayah" to Content(arrayListOf(R.drawable.xayah_star, R.drawable.xayah_original, R.drawable.xayah_cosmic),
                arrayListOf(R.drawable.xayah_passive, R.drawable.xayah_q,  R.drawable.xayah_w,  R.drawable.xayah_e,  R.drawable.xayah_r),
                R.array.xayah_abilities, R.string.xayah_history),
            "Jhin" to Content(arrayListOf(R.drawable.jhin_blood, R.drawable.jhin_dark, R.drawable.jhin_noon),
                arrayListOf(R.drawable.jhin_passive, R.drawable.jhin_q, R.drawable.jhin_w, R.drawable.jhin_e, R.drawable.jhin_r),
                R.array.jhin_abilities, R.string.jhin_history),
            "Vladimir" to Content(arrayListOf(R.drawable.vlad_cosmic, R.drawable.vlad_sould, R.drawable.vlad_tango),
                arrayListOf(R.drawable.vlad_passive, R.drawable.vlad_q, R.drawable.vlad_w, R.drawable.vlad_e, R.drawable.vlad_r),
                R.array.vlad_abilities, R.string.vlad_hisotry),
            "Zed" to Content(arrayListOf(R.drawable.zed_blade, R.drawable.zed_galaxy, R.drawable.zed_project),
                arrayListOf(R.drawable.zed_passive, R.drawable.zed_q, R.drawable.zed_w, R.drawable.zed_e, R.drawable.zed_r),
                R.array.zed_abilities, R.string.zed_hisotry)
        )

    }


    data class Champion(val name: String, val category: String, val iconId: Int, var isFav: Boolean) {
        override fun toString(): String = name
    }

    data class Content(val skins: ArrayList<Int>, val skillSImages: ArrayList<Int>, val skillDescriptions: Int, val champHistoryId: Int)
}