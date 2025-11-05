package com.example.lab2.recadapters

import com.example.lab2.R

data class state(val title:String, val text_state:String, val image_state: Int)
class MyState{
    val state_list = arrayListOf(state("Заголовок статьи", "Карткое описание", R.mipmap.state))
}
