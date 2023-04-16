package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

import com.jessecorbett.diskord.bot.*
import com.jessecorbett.diskord.util.*

import dev.kord.core.*
import dev.kord.core.entity.*
import dev.kord.core.event.message.*
import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import kotlinx.coroutines.flow.*

suspend fun main() {

    val client = Kord(readln())

    client.on<MessageCreateEvent> {

        if (message.content == "Siemanko") {
            val response = message.channel.createMessage("Witaj użytkowniku!")
        } else {
            if (!message.author!!.isBot) {
                message.channel.createMessage("Hello, I am bot!")
            }
        }
    }
    client.login {
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}
