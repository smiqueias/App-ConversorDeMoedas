package com.imagine.conversordemoedas.general.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.imagine.conversordemoedas.R
import com.imagine.conversordemoedas.general.model.PriceDolarAndEuro
import com.imagine.conversordemoedas.general.service.PriceDolarAndEuroService
import com.imagine.conversordemoedas.general.service.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val dec = DecimalFormat("#0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPriceDolarAndEuro()
    }

    fun getPriceDolarAndEuro() {

        val destinationService = ServiceBuilder.builderService(PriceDolarAndEuroService::class.java)
        val requestCall = destinationService.getPriceDolarAndEuro()

        requestCall.enqueue(object : Callback<PriceDolarAndEuro> {
            override fun onResponse(
                call: Call<PriceDolarAndEuro>,
                response: Response<PriceDolarAndEuro>
            ) {

                if (response.code() == 200) {

                        bt_dolar.setOnClickListener {
                            val priceDolar = et_valorEmReal.text.toString().toDouble()

                            val currentDollarPrice = response.body()?.uSD?.ask

                            tv_textoParConversao.text = "VALOR CONVERTIDO EM DÓLAR"

                            val calculoDeConversao = (priceDolar / currentDollarPrice!!)

                            tv_exibirValorConvertido.text = dec.format(calculoDeConversao)
                        }

                        bt_euro.setOnClickListener {
                            val priceEuro = et_valorEmReal.text.toString().toDouble()

                            val currentDollarPrice = response.body()?.eUR?.ask

                            tv_textoParConversao.text = "VALOR CONVERTIDO EM EURO"

                            val calculoDeConversao = (priceEuro / currentDollarPrice!!)

                            tv_exibirValorConvertido.text = dec.format(calculoDeConversao)

                        }
                }
            }

            override fun onFailure(call: Call<PriceDolarAndEuro>, t: Throwable) {
                Toast.makeText(
                    baseContext,
                    "VERIFIQUE SUA CONEXÃO COM A INTERNET",
                    Toast.LENGTH_LONG
                )
                    .show()
            }

        })


    }
}