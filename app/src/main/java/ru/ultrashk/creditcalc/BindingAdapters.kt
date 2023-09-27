package ru.ultrashk.creditcalc

import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.recyclerview.widget.RecyclerView
import ru.ultrashk.creditcalc.model.Grafik
import ru.ultrashk.creditcalc.ui.GrafikListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Grafik>?) {
    val adapter = recyclerView.adapter as GrafikListAdapter
    adapter.submitList(data)
}

@BindingConversion()
fun convertGrafikMonth(data: Grafik): String {
    return data.month.toString()
}