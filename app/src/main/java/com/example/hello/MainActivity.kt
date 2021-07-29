package com.example.hello

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val caixaNota1:TextView = caixaNota1
        val caixaNota2:TextView = caixaNota2
        val caixaFaltas:TextView = caixaFaltas

        val botaoConsultar:Button = botaoCalcular

        val caixaSituacao:TextView = caixaSituacao

        botaoConsultar.setOnClickListener {

            var nota1 = caixaNota1.text.toString().toInt()
            var nota2 = caixaNota2.text.toString().toInt()
            var faltas = caixaFaltas.text.toString().toInt()

            var situacaoTexto:String = ""

            if(((nota1+nota2)/2 >= 7) && (faltas <= 18)){
                situacaoTexto = "ALUNO APROVADO! :)\n"
                caixaSituacao.setTextColor(Color.GREEN)
            }else{
                situacaoTexto = "ALUNO REPROVADO! :(\n"
            }

            situacaoTexto += "Média - ${(nota1+nota2)/2}\n" +
                            "Faltas - ${faltas}"

            caixaSituacao.text = situacaoTexto
        }


    }
}