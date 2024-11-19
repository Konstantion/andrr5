package com.konstantion.lab5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.konstantion.lab5.R
import com.konstantion.lab5.model.DataModel


class RecyclerViewAdapter(private val dataList: List<DataModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textViewDescription: TextView = itemView.findViewById(R.id.textDescription)

        fun bind(dataModel: DataModel) {
            textViewTitle.text = dataModel.title
            textViewDescription.text = dataModel.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(dataList[position])

    override fun getItemCount(): Int = dataList.size
}