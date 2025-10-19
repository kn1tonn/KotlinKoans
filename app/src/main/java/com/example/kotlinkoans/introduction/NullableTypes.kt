package com.example.kotlinkoans.introduction

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email

    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun main() {
    val personalInfo = PersonalInfo("koki@example.com")
    val client = Client(personalInfo)
    val message = "こんにちは!"

    sendMessageToClient(client, message, object: Mailer {
        override fun sendMessage(email: String, message: String) {
            println("送信先: $email\n内容: $message")
        }
    })
}