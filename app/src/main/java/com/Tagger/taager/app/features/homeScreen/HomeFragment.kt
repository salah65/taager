package com.Tagger.taager.app.features.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.Tagger.taager.R
import com.Tagger.taager.app.core.PRODUCT
import com.Tagger.taager.data.network.Status
import com.Tagger.taager.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: ProductsAdapter
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ProductsAdapter() {
            findNavController().navigate(
                R.id.action_homeFragment_to_detailsFragment,
                bundleOf(PRODUCT to it)
            )
        }
        binding.productsRv.adapter = adapter
        lifecycleScope.launchWhenStarted {
            viewModel.productsFlow.collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.loader.visibility = View.GONE
                        adapter.updateData(it.data!!)
                    }
                    Status.ERROR -> Snackbar.make(
                        requireView(),
                        it.message ?: "",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}