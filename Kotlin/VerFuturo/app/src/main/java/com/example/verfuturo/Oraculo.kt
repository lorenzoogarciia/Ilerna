package com.example.verfuturo

import java.util.Calendar

class Oraculo(val dia: Int, val mes: Int) {
    //Signos del Zodiaco
    private val signosZodiaco = arrayOf("aries","tauro","geminis","cancer","leo","virgo",
                                        "libra","escorpio","sagitario","capricornio","acuario","piscis")

    //Atributo con el signo para poder acceder desde fuera
    val signo = getSignoZodiaco(dia,mes)

    //Arrays por signos del zodiaco
    private var ariesFutures = arrayOf(
        "Domingo: Aries, una noticia sorpresa llegara a ti",
        "Lunes: Aries, el inicio de la semana trae nuevas oportunidades",
        "Martes: Un encuentro inesperado cambiará tu perspectiva, Aries",
        "Miercoles: Aries, es un buen dia para enfocarte en tus finanzas.",
        "Jueves: La salud debe ser tu prioridad hoy, Aries.",
        "Viernes: Aries, la diversion y la aventura te esperan en la noche.",
        "Sábado: Un día tranquilo y pacífico para Aries."
    )

    private var taurusFutures = arrayOf(
        "Domingo: Un día de descanso y reflexión para Tauro.",
        "Lunes: Tauro, enfrentarás desafíos que requerirán tu paciencia.",
        "Martes: Un día favorable para asuntos amorosos, Tauro.",
        "Miércoles: Tauro, cuidado con las decisiones impulsivas hoy.",
        "Jueves: Un viejo amigo te buscará, Tauro.",
        "Viernes: Tauro, es un buen día para relajarte y cuidarte.",
        "Sábado: La familia será importante para Tauro hoy."
    )

    private var geminisFutures = arrayOf(
        "Domingo: Géminis, la reflexión te traerá claridad.",
        "Lunes: Géminis, la comunicación será clave hoy.",
        "Martes: Un pequeño viaje podría estar en tu futuro, Géminis.",
        "Miércoles: Géminis, cuidado con los malentendidos hoy.",
        "Jueves: Un día para explorar nuevas oportunidades, Géminis.",
        "Viernes: Géminis, la noche trae encuentros emocionantes.",
        "Sábado: Un día para relajarte y disfrutar, Géminis."
    )

    private var cancerFutures = arrayOf(
        "Domingo: Cáncer, la reflexión te brindará paz.",
        "Lunes: Cáncer, un nuevo proyecto te emocionará.",
        "Martes: La empatía te abrirá puertas, Cáncer.",
        "Miércoles: Cáncer, un desafío te permitirá crecer.",
        "Jueves: Un día para cuidarte y mimarte, Cáncer.",
        "Viernes: Cáncer, la diversión te espera en cada esquina.",
        "Sábado: Un día para conectar con tus seres queridos, Cáncer."
    )

    private var leoFutures = arrayOf(
        "Domingo: Leo, un mensaje importante llegará a ti.",
        "Lunes: Leo, tu liderazgo será crucial hoy.",
        "Martes: Un día para explorar y aprender, Leo.",
        "Miércoles: Leo, cuidado con las tensiones en el trabajo.",
        "Jueves: Un día para celebrar pequeños logros, Leo.",
        "Viernes: Leo, la aventura te llama.",
        "Sábado: Un día para descansar y rejuvenecer, Leo."
    )

    private var virgoFutures = arrayOf(
        "Domingo: Virgo, la planificación del futuro te beneficiará.",
        "Lunes: Virgo, la organización será tu mejor amiga.",
        "Martes: Un día para cuidar de tu bienestar, Virgo.",
        "Miércoles: Virgo, un encuentro casual será significativo.",
        "Jueves: Un día para enfocarte en tus pasiones, Virgo.",
        "Viernes: Virgo, la noche trae sorpresas emocionantes.",
        "Sábado: Un día para disfrutar de la naturaleza, Virgo."
    )
    private var libraFutures = arrayOf(
        "Domingo: Libra, la reflexión te brindará respuestas.",
        "Lunes: Libra, busca el equilibrio en tus decisiones.",
        "Martes: La armonía en las relaciones será vital hoy, Libra.",
        "Miércoles: Libra, un viejo amigo te traerá noticias.",
        "Jueves: Un día para explorar tu creatividad, Libra.",
        "Viernes: Libra, la noche te reserva una sorpresa especial.",
        "Sábado: Un día para relajarte y disfrutar de la paz, Libra."
    )

    private var scorpioFutures = arrayOf(
        "Domingo: Escorpio, la meditación te traerá serenidad.",
        "Lunes: Escorpio, enfrentarás un desafío emocional.",
        "Martes: Un día para explorar lo desconocido, Escorpio.",
        "Miércoles: Escorpio, un secreto será revelado.",
        "Jueves: Un día para conectarte con tu yo interior, Escorpio.",
        "Viernes: Escorpio, la pasión y el romance están en el aire.",
        "Sábado: Un día para aventurarte fuera de tu zona de confort, Escorpio."
    )

    private var sagittariusFutures = arrayOf(
        "Domingo: Sagitario, la reflexión te brindará nuevas perspectivas.",
        "Lunes: Sagitario, un viaje está en tu horizonte.",
        "Martes: La verdad será tu guía hoy, Sagitario.",
        "Miércoles: Sagitario, un desafío te espera.",
        "Jueves: Un día para aprender algo nuevo, Sagitario.",
        "Viernes: Sagitario, la diversión te espera en cada esquina.",
        "Sábado: Un día para explorar y aventurarte, Sagitario."
    )

    private var capricornFutures = arrayOf(
        "Domingo: Capricornio, la reflexión te brindará claridad.",
        "Lunes: Capricornio, tu determinación te llevará lejos.",
        "Martes: Un día para planificar el futuro, Capricornio.",
        "Miércoles: Capricornio, un obstáculo requerirá tu atención.",
        "Jueves: Un día para enfocarte en tus metas, Capricornio.",
        "Viernes: Capricornio, relájate y disfruta de las pequeñas cosas.",
        "Sábado: Un día para conectar con la naturaleza, Capricornio."
    )

    private var aquariusFutures = arrayOf(
        "Domingo: Acuario, la reflexión te abrirá nuevas puertas.",
        "Lunes: Acuario, tu creatividad brillará hoy.",
        "Martes: Un día para innovar y soñar, Acuario.",
        "Miércoles: Acuario, un amigo necesitará tu apoyo.",
        "Jueves: Un día para explorar nuevas ideas, Acuario.",
        "Viernes: Acuario, la noche te traerá inspiración.",
        "Sábado: Un día para disfrutar de la libertad y la aventura, Acuario."
    )

    private var piscesFutures = arrayOf(
        "Domingo: Piscis, la meditación te conectará con tu yo superior.",
        "Lunes: Piscis, tu intuición te guiará.",
        "Martes: Un día para cuidar de ti y de los demás, Piscis.",
        "Miércoles: Piscis, un sueño te traerá un mensaje importante.",
        "Jueves: Un día para explorar tu lado espiritual, Piscis.",
        "Viernes: Piscis, la noche te traerá magia y misterio.",
        "Sábado: Un día para relajarte cerca del agua, Piscis."
    )

    //Método para obtener el signo del zodiaco
    private fun getSignoZodiaco(dia: Int,mes: Int): String {
        var signo = ""
        when(mes){
            1 -> signo = if(dia < 20) signosZodiaco.get(9) else signosZodiaco.get(10)
            2 -> signo = if(dia < 19) signosZodiaco.get(10) else signosZodiaco.get(11)
            3 -> signo = if (dia < 21) signosZodiaco.get(11) else signosZodiaco.get(0)
            4 -> signo = if (dia < 20) signosZodiaco.get(0) else signosZodiaco.get(1)
            5 -> signo = if (dia < 21) signosZodiaco.get(1) else signosZodiaco.get(2)
            6 -> signo = if (dia < 21) signosZodiaco.get(2) else signosZodiaco.get(3)
            7 -> signo = if (dia < 23) signosZodiaco.get(3) else signosZodiaco.get(4)
            8 -> signo = if (dia < 23) signosZodiaco.get(4) else signosZodiaco.get(5)
            9 -> signo = if (dia < 23) signosZodiaco.get(5) else signosZodiaco.get(6)
            10 -> signo = if (dia < 23) signosZodiaco.get(6) else signosZodiaco.get(7)
            11 -> signo = if (dia < 22) signosZodiaco.get(7) else signosZodiaco.get(8)
            12 -> signo = if (dia < 22) signosZodiaco.get(8) else signosZodiaco.get(9)
        }
        return signo
    }

    //Funcion para obtener el dia de la semana
    private fun obtenerDiaDeLaSemana(): Int{
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    //Funcion para obtener la posicion del signo del zodiaco
    private fun getIntSignoZodiaco(signo: String?): Int{
        return signosZodiaco.indexOf(signo)
    }

    fun obtenerPrediccion(nombre: String?): String{
        var prediccion: String = "Hola $nombre "
        val numDiaSemana = obtenerDiaDeLaSemana() - 1 //Recordar restar 1

        when(signo){
            "aries" -> prediccion = "$prediccion\n${ariesFutures.get(numDiaSemana)}"
            "tauro" -> prediccion = "$prediccion\n${taurusFutures.get(numDiaSemana)}"
            "geminis" -> prediccion = "$prediccion\n${geminisFutures.get(numDiaSemana)}"
            "cancer" -> prediccion = "$prediccion\n${cancerFutures.get(numDiaSemana)}"
            "leo" -> prediccion = "$prediccion\n${leoFutures.get(numDiaSemana)}"
            "virgo" -> prediccion = "$prediccion\n${virgoFutures.get(numDiaSemana)}"
            "libra" -> prediccion = "$prediccion\n${libraFutures.get(numDiaSemana)}"
            "escorpio" -> prediccion = "$prediccion\n${scorpioFutures.get(numDiaSemana)}"
            "sagitario" -> prediccion = "$prediccion\n${sagittariusFutures.get(numDiaSemana)}"
            "capricornio" -> prediccion = "$prediccion\n${capricornFutures.get(numDiaSemana)}"
            "acuario" -> prediccion = "$prediccion\n${aquariusFutures.get(numDiaSemana)}"
            "piscis" -> prediccion = "$prediccion\n${piscesFutures.get(numDiaSemana)}"
        }
        return prediccion
    }
}