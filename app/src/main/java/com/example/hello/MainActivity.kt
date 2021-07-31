package com.example.hello

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(){
            calcularIMC()
        }


    }

    fun calcularIMC(){

        var peso = editTextPeso.text.toString().toFloatOrNull()
        var altura = editTextAltura.text.toString().toFloatOrNull()

        var imc = 0f

        if (peso!=null && altura!=null){
            imc = peso/(altura*altura)
            textViewResultado.setText("IMC - %.2f".format(imc))

            var condicao = ""
            var cor = 0

            when{
                imc < 18.5f -> {condicao = "\nBaixo Peso"; cor=Color.CYAN}
                imc in 18.5f..24.9f -> {condicao = "\nPeso Normal"; cor=Color.GREEN}
                imc in 24.9f..30f -> {condicao = "\nSobrepeso"; cor=Color.MAGENTA}
                imc > 30f -> {condicao = "\nObesidade"; cor=Color.RED}
            }

            textViewResultado.setText(textViewResultado.text.toString()+condicao)
            textViewResultado.setTextColor(cor)
        }else{
            Toast.makeText(this, "Há campos em branco!", Toast.LENGTH_SHORT).show()
        }


    }

    /*fun nada(){
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
    }*/
}