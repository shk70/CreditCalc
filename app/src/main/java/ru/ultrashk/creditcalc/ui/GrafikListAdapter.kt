package ru.ultrashk.creditcalc.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ultrashk.creditcalc.databinding.GrafikViewItemBinding
import ru.ultrashk.creditcalc.model.Grafik

class GrafikListAdapter : ListAdapter<Grafik, GrafikListAdapter.GrafikViewHolder>(DiffCallBack) {

    class GrafikViewHolder(var binding: GrafikViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(Grafik: Grafik) {
            binding.grafik = Grafik
            binding.executePendingBindings()
        }

    }
    companion object DiffCallBack : DiffUtil.ItemCallback<Grafik>() {
        override fun areItemsTheSame(oldItem: Grafik, newItem: Grafik): Boolean {
            return oldItem.month == newItem.month
              }

        override fun areContentsTheSame(oldItem: Grafik, newItem: Grafik): Boolean {
            return oldItem.ostatok == newItem.ostatok
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrafikListAdapter.GrafikViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GrafikViewHolder(GrafikViewItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: GrafikViewHolder, position: Int) {
        val grafik = getItem(position)
        holder.bind(grafik)
    }
}