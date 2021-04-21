package utils

import utils.Constants.OPEN_GOOGLE
import utils.Constants.OPEN_SEARCH
import java.lang.Exception

object BotResponse {

    fun basicResponse(_message: String) : String {
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when {

            message.contains("hello") -> {
                when (random) {
                    0 -> "Olááá"
                    1 -> "Sup"
                    2 -> "Buongiorno"
                    else -> "error"
                }
            }

            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks for asking!"
                    1 -> "I'm hungry"
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            message.contains("Cara ou Coroa") && message.contains("moeda") -> {
                var r = (0..1).random()
                val result = if (r == 0 ) "cara " else "coroa"

                "Eu joguei a moeda  e ela caiu como $result "
            }


            message.contains("solve") -> {
                val equation: String? = message.substringAfter("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()

                } catch (e: Exception) {
                    "Sorry, I can't solve that"
                }
            }

            message.contains("time") && message.contains("?") -> {
                Time.timeStamp()
            }


            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            message.contains("search")  -> {
                OPEN_SEARCH
            }




            else ->   when (random) {
                0 -> "I don't understand..."
                1 -> "Idk"
                2 -> "Try asking me something different"
                else -> "error"
            }
        }
    }

}