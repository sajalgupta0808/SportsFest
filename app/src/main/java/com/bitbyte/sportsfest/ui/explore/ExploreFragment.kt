package com.bitbyte.sportsfest.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitbyte.sportsfest.databinding.FragmentExploreBinding
import com.bitbyte.sportsfest.databinding.LayoutClubslistBinding
import com.bitbyte.sportsfest.utils.ItemCard

class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    private var _binding : FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initializeClubList(binding.clubsList)
        return root
    }

    private fun initializeClubList(clubsList: LayoutClubslistBinding) {
       clubsList.tileBadminton.setOnClickListener{showEventsList(it as ItemCard)}
    }

    private fun showEventsList(itemCard: ItemCard){
        val clubName = itemCard.getText()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}