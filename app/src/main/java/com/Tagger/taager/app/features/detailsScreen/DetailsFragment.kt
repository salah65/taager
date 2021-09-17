package com.Tagger.taager.app.features.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Tagger.taager.app.core.PRODUCT
import com.Tagger.taager.databinding.FragmentDetailsBinding
import com.Tagger.taager.domain.Model.Product

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product: Product = arguments?.get(PRODUCT) as Product
        binding.productName.text=product.name
        binding.productPrice.text=product.price.toString()
        binding.productCreatedAt.text=product.createdAt
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}