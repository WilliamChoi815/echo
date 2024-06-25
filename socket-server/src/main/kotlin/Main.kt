import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    val serverSocket = ServerSocket(9999)
    println("Server is running on port 9999")
    val clientSocket = serverSocket.accept()
    println("Client connected: ${clientSocket.inetAddress.hostAddress}")
    while (true) {
        val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        val output = PrintWriter(clientSocket.getOutputStream(), true)

        val number1 = input.readLine().toInt()
        val number2 = input.readLine().toInt()
        println("First client: $number1")
        println("Second client: $number2")


        output.println("Echo: ${number2.plus(number1)}")


    }
}