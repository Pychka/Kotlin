package com.example.lab2.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.feel
import com.example.lab2.recadapters.StateRecycler.MyVH2

class StateRecycler(val context: Context, val list:ArrayList<state>) :
    RecyclerView.Adapter<MyVH2>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyVH2 {
        val root = LayoutInflater.from(context).inflate(R.layout.state_adapter, parent, false)
        return MyVH2(root)
    }


    class MyVH2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_state)
        val textView: TextView = itemView.findViewById(R.id.title)
        val textView2: TextView = itemView.findViewById(R.id.description)
    }

    override fun onBindViewHolder(holder: MyVH2, position: Int) {
        holder.image.setImageResource(list[position].image_state)
        holder.textView.setText(list[position].title)
        holder.textView2.setText(list[position].text_state)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}