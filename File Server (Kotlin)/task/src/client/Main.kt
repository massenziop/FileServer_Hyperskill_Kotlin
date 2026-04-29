package client

import server.SERVER_HOST
import server.SERVER_PORT
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

fun main() {
    println("Client started!")

    val socket = Socket(SERVER_HOST, SERVER_PORT)
    socket.use {
        val output = DataOutputStream(socket.getOutputStream())
        val input = DataInputStream(socket.getInputStream())

        val outputMessage = "Give me everything you have!"
        output.writeUTF(outputMessage)
        println("Sent: $outputMessage")

        val inputMessage = input.readUTF()
        println("Received: $inputMessage")
    }
}
