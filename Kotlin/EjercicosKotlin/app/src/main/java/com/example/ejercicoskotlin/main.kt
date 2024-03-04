package com.example.ejercicoskotlin

interface Payable {
    fun processPayment(amount: Double){
        println("El pago ha sido procesado con éxito")
    }
}

interface Refundable {
    fun processRefund(amount: Double){
        println("La cantidad de $amount ha sido reembolsada con éxito")
    }
}

class CreditCard: Payable, Refundable{
    override fun processPayment(amount: Double){
        println("El pago con tarjeta de crédito por $amount € ha sido un éxito")
    }

    override fun processRefund(amount: Double){
        println("El reembolso a tarjeta de crédito por $amount € ha sido un éxito")
    }
}

class BankTransfer: Payable{
    override fun processPayment(amount: Double){
        println("La transferencia bancaria por $amount € ha sido un éxito")
    }
}

class CashPayment: Payable{
    override fun processPayment(amount: Double){
        println("El pago en efectivo por $amount € ha sido un éxito")
    }
}

fun main(){
    println("Ingrese un método de Pago (Tarjeta de Crédito/Trasferencia/Efectivo):")
    val metodoPago = readLine()

    println("Ingrese cantidad:")
    val cantidad = readLine()?.toDoubleOrNull()

    if(cantidad!=null){
        when(metodoPago){
            "Tarjeta de Credito"-> CreditCard().processPayment(cantidad)
            "Transferencia"-> BankTransfer().processPayment(cantidad)
            "Efectivo"-> CashPayment().processPayment(cantidad)
            else-> println("Metodo de pago no válido")
        }
    }else{
        println("Cantidad no válida")
    }

}