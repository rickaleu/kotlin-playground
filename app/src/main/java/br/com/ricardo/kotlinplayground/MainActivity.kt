package br.com.ricardo.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcular(view: View){

        val valor1 : String = edit_valor1.text.toString()
        val valor2 : String = edit_valor2.text.toString()

        var resultado : Double = 0.0

        if(TextUtils.isEmpty(valor1)){
            edit_valor1.error = "Campo obrigatório!"

        } else if (TextUtils.isEmpty(valor2)){
            edit_valor2.error = "Campo obrigatório!"

        } else {
            resultado = (valor1.toDouble() + valor2.toDouble())
            text_resultado.text = resultado.toString()

        }

    }
}
