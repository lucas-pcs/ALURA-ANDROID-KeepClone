package br.com.alura.ceep.webclient

import br.com.alura.ceep.webclient.services.NotaServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInicializador {

    private val client: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.225.8.98:9185/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val notaService: NotaServices = retrofit.create(NotaServices::class.java)
}