package com.example.lab2

data class feel(val image:Int, val name_feel:String)
class MyFeel{val list = arrayListOf(feel(R.mipmap.calm, "Спокойным"),
    feel(R.mipmap.meditation, "Расслабленным"),
    feel(R.mipmap.relax, "Сосредоточеным"),
    feel(R.mipmap.spiral, "Взволнованным")
)}
