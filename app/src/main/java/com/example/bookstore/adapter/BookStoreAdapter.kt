package com.example.bookstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.model.Books
import com.example.bookstore.ui.BooksListFragmentDirections

class BookStoreAdapter (private val content: Context, private val dataset: List<Books>):
RecyclerView.Adapter<BookStoreAdapter.BookViewHolder>(){

class BookViewHolder(val view : View): RecyclerView.ViewHolder(view){
    val bookName:TextView = view.findViewById(R.id.tvname)
    val bookPrice:TextView =view.findViewById(R.id.tvprice)
    val bookImage:ImageView = view.findViewById(R.id.imagev)
    val bookItem: CardView = view.findViewById(R.id.card_view)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return BookViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = dataset[position]

        holder.bookName.text = content.resources.getString(item.name)
        holder.bookPrice.text = content.resources.getString(item.price)
        holder.bookImage.setImageResource(item.image)
        holder.bookItem.setOnClickListener{
            val action = BooksListFragmentDirections.actionBooksListFragmentToBooksDetailsFragment(holder.bookName.text.toString(),holder.bookPrice.text.toString(),item.image)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = dataset.size

}