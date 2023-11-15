package com.example.navigate

import androidx.lifecycle.ViewModel
import com.example.navigate.Data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUiState())
    val stateUI: StateFlow<OrderUiState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo:Int){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)) }
    }
    fun setRasa(rasaPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan) }
    }
    fun resetOrder(){
        _stateUI.value = OrderUiState()
    }
    fun setContact(listContact: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                namaPelanggan= listContact[0],
                nomorTelepon = listContact[1],
                alamat = listContact[2],
            )
        }
    }
    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String{
        val kalkulasiharga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiharga)
    }
}
