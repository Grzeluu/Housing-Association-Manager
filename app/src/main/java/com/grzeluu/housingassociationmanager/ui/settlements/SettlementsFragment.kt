package com.grzeluu.housingassociationmanager.ui.settlements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grzeluu.housingassociationmanager.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettlementsFragment : Fragment() {

    companion object {
        fun newInstance() = SettlementsFragment()
    }

    private lateinit var viewModel: SettlementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settlements, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // viewModel = ViewModelProvider(this).get(SettlementsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}