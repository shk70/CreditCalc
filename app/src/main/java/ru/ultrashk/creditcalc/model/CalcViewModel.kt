package ru.ultrashk.creditcalc.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData

//import androidx.lifecycle.ViewModel


class CalcViewModel: ViewModel() {
    private var monthRate: Double = 0.00
    private val _monthPay = MutableLiveData<Double>(0.00)
    val monthPay: LiveData<Double> = _monthPay
    private val _grafiks = MutableLiveData<List<Grafik>>()
    val grafiks: LiveData<List<Grafik>> = _grafiks
    private val _month = MutableLiveData<Int>(12)
    val month: LiveData<Int> = _month
    private val _sum = MutableLiveData<Double>(100000.00)
    val sum: LiveData<Double> = _sum
    private val _percent = MutableLiveData<Double>(10.10)
    val percent: LiveData<Double> = _percent
    fun setMonth(month: Int?) {
        _month.value = month ?: 0
    }
    fun setPercent(percent: Double?) {
        _percent.value = percent ?: 0.00
        monthRate = (_percent.value!!/12.00/100.00).toDouble()
    }
    fun setSum(sum: Double?) {
        _sum.value = sum ?: 0.00
    }

    fun getPaymentPerMonth()  {
        var topPart = _sum.value!! * monthRate
        var bottomPart: Double = (1 - (1/Math.pow(monthRate+1, _month.value!!.toDouble()))).toDouble()
        _monthPay.value = String.format("%.02f",topPart/bottomPart).toDouble()
    }

    fun getGrafik() {
        var arr = ArrayList<Grafik>()
        val mm = _monthPay.value!!
        var dolg = _sum.value;

        for(i in 1.rangeTo(_month.value!!)) {
            var graf = Grafik()
            graf.month = i
            graf.payPerMonth = mm
            graf.sumPercent = String.format("%.02f", dolg!!*monthRate).toDouble()
            graf.sumDolg = String.format("%.02f", mm-dolg!!*monthRate).toDouble()
            dolg = String.format("%.02f", dolg!! - (mm-dolg!!*monthRate)).toDouble()
            if(dolg<0.00) dolg=0.00
            graf.ostatok = dolg;
            arr.add(graf)
        }
        _grafiks.value = arr
    }
}
