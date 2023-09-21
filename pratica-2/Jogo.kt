package com.example.jogo

import kotlin.random.Random

class Jogo(private var numeroMenor: Int, private var numeroMaior: Int) {

    private var numeroEscolhido:Int = Random.nextInt(1, 100)

    private var status: String ="Novo jogo, escolha um número"

    fun sortear(menor: Int): Int{
        numeroEscolhido = Random.nextInt(menor, menor + 100)
        return numeroEscolhido
    }

    fun getMenor(): String {
        return this.numeroMenor.toString()
    }
    fun getMaior(): String{
        return this.numeroMaior.toString()
    }

    fun getStatus(): String{
        return status
    }

    fun chute(numero: Int){
        if ((numero <= numeroMenor) || (numero >= numeroMaior) ) {
            status = "Game Over"
            }
            else if (numero > numeroEscolhido) {
                numeroMaior = numero
                status = "O número que você chutou é maior do que o número sorteado, tente novamente!"
            } else if (numero < numeroEscolhido) {
                numeroMenor = numero
                status = "O número que você chutou é menor que o número sorteado, tente novamente!"
            } else {
                status = "You Win!"
            }
        }
    }
