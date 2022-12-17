package com.example.bookstore.ui

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.bookstore.R



class BooksDetailsFragment : Fragment() {
    companion object {
        var name = "name"
        var bookName = "Name"
        var price = "price"
        var bookPrice = "bookPrice"
        var image = "image"
        var imagepath = 0
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            bookName = it.getString(name).toString()
            bookPrice = it.getString(price).toString()
            imagepath = it.getInt(image)
        }

        var bName :TextView=view.findViewById(R.id.ndname)
        var bPrice :TextView=view.findViewById(R.id.ndprice)
        var bImage: ImageView =view.findViewById(R.id.ndimage)

        bName.text = bookName
        bPrice.text = bookPrice
        bImage.setImageResource(imagepath)

        var searchButton:ImageButton =view.findViewById(R.id.ndbutton)
        searchButton.setOnClickListener{
            var queryUri:Uri=Uri.parse("${SEARCH_PREFIX}${bookName} book")
            var intent = Intent(Intent.ACTION_VIEW, queryUri)
            context?.startActivity(intent)
        }
    }
}