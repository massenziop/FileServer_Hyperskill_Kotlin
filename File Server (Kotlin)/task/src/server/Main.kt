package server

import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.InetAddress
import java.net.ServerSocket

const val SERVER_HOST = "127.0.0.1"
const val SERVER_PORT = 8080

private const val CONNECTIONS_BACKLOG = 50

fun main() {
    println("Server started!")

    val server = ServerSocket(SERVER_PORT, CONNECTIONS_BACKLOG, InetAddress.getByName(SERVER_HOST))
    val socket = server.accept()
    socket.use {
        val input = DataInputStream(socket.getInputStream())
        val output = DataOutputStream(socket.getOutputStream())

        val inputMessage = input.readUTF()
        println("Received: $inputMessage")

        val outputMessage = "All files were sent!"
        output.writeUTF(outputMessage)
        println("Sent: $outputMessage")
    }
}
