package com.example.bookstore.data

import com.example.bookstore.R
import com.example.bookstore.model.Books

class DataSource {

    fun loadData(): List<Books> {
        return listOf(
            Books(R.string.animal_farm, R.string.animal_farm_price, R.drawable.animal_farm),
            Books(R.string.blackcoffee, R.string.blackcoffee_price, R.drawable.blackcoffee),
            Books(R.string.gotbook, R.string.gotbook_price, R.drawable.gotbook),
            Books(R.string.murder, R.string.murder_price, R.drawable.murder),
            Books(R.string.sciences, R.string.sciences_price, R.drawable.sciences)
        )
    }
}