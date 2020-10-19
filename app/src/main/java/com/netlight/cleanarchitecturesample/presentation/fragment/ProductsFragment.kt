package com.netlight.cleanarchitecturesample.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.netlight.cleanarchitecturesample.R
import com.netlight.cleanarchitecturesample.presentation.viewmodel.ProductsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsFragment : Fragment() {
    private val viewModel: ProductsViewModel by viewModel()
    //  private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_products_listing, container, false)

        /* adapter = TasksAdapter(viewModel)
         view.tasks_list.adapter = adapter
 */

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.products.observe(viewLifecycleOwner, Observer {
            //  adapter.submitList(it)
            // no_tasks_group.isVisible = it.isEmpty()
            Log.e("onViewCreated: ", it.toString())
        })

        viewModel.getProducts()


    }

    fun moveToProductDetailsFragment() {
        findNavController().navigate(R.id.action_productsFragment_to_productDetailsFragment)
    }

}