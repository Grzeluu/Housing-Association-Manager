package com.grzeluu.housingassociationmanager.ui.settlements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.grzeluu.housingassociationmanager.data.model.BillingResponse
import com.grzeluu.housingassociationmanager.data.model.FlatResponse
import com.grzeluu.housingassociationmanager.databinding.FragmentSettlementsBinding
import com.grzeluu.housingassociationmanager.ui.settlements.adapter.BillingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettlementsFragment : Fragment() {

    private val viewModel: SettlementsViewModel by viewModels()
    private lateinit var billingAdapter: BillingAdapter

    private var _binding: FragmentSettlementsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettlementsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        initAdapters()
    }

    private fun initAdapters() {
        billingAdapter = BillingAdapter()
        billingAdapter.submitList(fakeBillings)
        val billingsLinearLayoutManager = LinearLayoutManager(context)

        with(binding.rvBillings) {
            adapter = billingAdapter
            layoutManager = billingsLinearLayoutManager
        }
    }

    private val fakeFlatList = listOf(
        FlatResponse(
            1,
            "Waszczyka",
            "7",
            "67-102",
            "Gogolin",
            "patrykg"
        ),
        FlatResponse(
            1,
            "Borowieckiego",
            "7",
            "67-102",
            "Gogolin",
            "patrykg"
        ),
        FlatResponse(
            1,
            "Hipolita",
            "7",
            "67-102",
            "Gogolin",
            "patrykg"
        )
    )

    private val fakeBillings = listOf(
        BillingResponse(
            1,
            3,
            "Marzec 2021",
            "2021-01-01",
            "2021-01-31",
            34.43,
            23.56,
            77.66,
            342.44,
            true,
            "patrykg"
        ),
        BillingResponse(
            1,
            1,
            "Luty 2021",
            "2021-01-01",
            "2021-01-31",
            34.43,
            23.56,
            77.66,
            342.44,
            false,
            "patrykg"
        ), BillingResponse(
            1,
            2,
            "Styczeń 2021",
            "2021-01-01",
            "2021-01-31",
            34.43,
            23.56,
            77.66,
            342.44,
            true,
            "patrykg"
        )
    )
}