package com.example.championslist.viewPager.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.championslist.R
import com.example.championslist.dummy.ChampionsContent
import kotlinx.android.synthetic.main.fragment_skins.view.*

class Skins : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val skins =  ChampionsContent.contentMap[ChampionsContent.currentChampion]?.skins!!
        val view =  inflater.inflate(R.layout.fragment_skins, container, false)
        view.skin1.setImageResource(skins[0])
        view.skin2.setImageResource(skins[1])
        view.skin3.setImageResource(skins[2])

        return view

    }

}