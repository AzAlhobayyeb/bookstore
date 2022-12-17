package com.example.bookstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.adapter.BookStoreAdapter
import com.example.bookstore.data.DataSource
import com.example.bookstore.databinding.FragmentBooksListBinding


class BooksListFragment : Fragment() {
private var _binding: FragmentBooksListBinding? = null
    private val  binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBooksListBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val datset = DataSource().loadData()
        recyclerView.adapter = BookStoreAdapter(this.requireContext(),datset)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}