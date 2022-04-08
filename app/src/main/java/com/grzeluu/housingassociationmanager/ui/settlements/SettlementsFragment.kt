package com.grzeluu.housingassociationmanager.ui.settlements

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.grzeluu.housingassociationmanager.data.model.BillingResponse
import com.grzeluu.housingassociationmanager.data.model.FakeData.Companion.fakeBillings
import com.grzeluu.housingassociationmanager.data.model.FakeData.Companion.fakeFlats
import com.grzeluu.housingassociationmanager.data.model.FlatResponse
import com.grzeluu.housingassociationmanager.databinding.FragmentSettlementsBinding
import com.grzeluu.housingassociationmanager.ui.settlements.adapter.BillingAdapter
import com.grzeluu.housingassociationmanager.ui.settlements.adapter.FlatsAdapter
import com.grzeluu.housingassociationmanager.ui.utils.snap.Behavior
import com.grzeluu.housingassociationmanager.ui.utils.snap.OnSnapPositionChangeListener
import com.grzeluu.housingassociationmanager.ui.utils.snap.SnapOnScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettlementsFragment : Fragment() {

    private val viewModel: SettlementsViewModel by viewModels()

    private var _binding: FragmentSettlementsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private lateinit var billingAdapter: BillingAdapter
    private lateinit var flatsAdapter: FlatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
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
        initRecyclers()
    }

    private fun initRecyclers() {
        initBillingsRecycler()
        initFlatsRecycler()
    }

    private fun initFlatsRecycler() {
        flatsAdapter = FlatsAdapter()
        flatsAdapter.submitList(fakeFlats)

        val flatsLinearLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        with(binding.rvFlats) {
            adapter = flatsAdapter
            layoutManager = flatsLinearLayoutManager

            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(this)

            addOnScrollListener(
                SnapOnScrollListener(snapHelper = snapHelper,
                    onSnapPositionChangeListener = object : OnSnapPositionChangeListener {
                        override fun onSnapPositionChange(position: Int) {
                            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                        }
                    })
            )
        }
    }

    private fun initBillingsRecycler() {
        billingAdapter = BillingAdapter()
        billingAdapter.submitList(fakeBillings)
        val billingsLinearLayoutManager = LinearLayoutManager(context)

        with(binding.rvBillings) {
            adapter = billingAdapter
            layoutManager = billingsLinearLayoutManager
        }
    }
}