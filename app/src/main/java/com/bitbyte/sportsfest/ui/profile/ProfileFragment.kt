package com.bitbyte.sportsfest.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bitbyte.sportsfest.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
}