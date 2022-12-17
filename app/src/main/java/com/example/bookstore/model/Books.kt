package com.example.bookstore.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Books(@StringRes val name:Int,@StringRes val price:Int,@DrawableRes val image: Int)
