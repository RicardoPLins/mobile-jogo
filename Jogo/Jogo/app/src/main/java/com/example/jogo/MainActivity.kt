package com.example.jogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Jogo
    private lateinit var btchute: Button
    private lateinit var menor: TextView
    private lateinit var maior: TextView
    private lateinit var numero: EditText
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jogo = Jogo(1,100)
        this.btchute = findViewById(R.id.btchute)
        this.menor = findViewById(R.id.menor)
        this.maior = findViewById(R.id.maior)
        this.numero = findViewById(R.id.numero)
        this.status = findViewById(R.id.status)


        this.btchute.setOnClickListener{
            val chutetext = numero.text.toString()
            val chute = chutetext.toInt()
            jogo.chute(chute)
            this.status.text = jogo.getStatus()
            this.menor.text = this.jogo.getMenor()
            this.maior.text = this.jogo.getMaior()
        }

        btchute.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                var menornum:Int = Random.nextInt(1, 100)
                jogo = Jogo(menornum, menornum + 100)
                jogo.sortear(menornum)
                status.text = "Novo jogo, escolha um número"
                menor.text = jogo.getMenor()
                maior.text = jogo.getMaior()
                numero.text.clear()
                return true
            }

    })
    }
}
