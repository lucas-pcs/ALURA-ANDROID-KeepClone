package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaServices
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:8080/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val notaService: NotaServices = retrofit.create(NotaServices::class.java)
}