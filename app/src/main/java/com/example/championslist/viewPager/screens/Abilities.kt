package com.example.championslist.viewPager.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.championslist.R
import com.example.championslist.content.ChampionsContent.contentMap
import com.example.championslist.content.ChampionsContent.currentChampion
import kotlinx.android.synthetic.main.fragment_abilities.view.*


class Abilities : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_abilities, container, false)
        val champName = currentChampion
        val skillDesc = resources.getStringArray(contentMap[champName]?.skillDescriptions!!)
        val skillsImages = contentMap[champName]?.skillSImages!!
        view.desc_passive.text = skillDesc[0]
        view.desc_Q.text = skillDesc[1]
        view.desc_W.text = skillDesc[2]
        view.desc_E.text = skillDesc[3]
        view.desc_R.text = skillDesc[4]
        view.img_passive.setImageResource(skillsImages[0])
        view.img_Q.setImageResource(skillsImages[1])
        view.img_W.setImageResource(skillsImages[2])
        view.img_E.setImageResource(skillsImages[3])
        view.img_R.setImageResource(skillsImages[4])
        return view
    }





}