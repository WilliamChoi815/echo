import java.net.Socket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

fun main() {
    val socket = Socket("localhost", 9999)
    println("Connected to server")

    val input = BufferedReader(InputStreamReader(socket.getInputStream()))
    val output = PrintWriter(socket.getOutputStream(), true)
    while (true) {
        print("Enter message :")
        val number1 = readLine()
        print("Enter message :")
        val number2 = readLine()


        output.println(number1)
        output.println(number2)
        println("Sent to server: $number1 $number2")
        val serverResponse = input.readLine()
        println("Received from server: $serverResponse")


    }
}