package ru.gc986.example.routers

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import ru.gc986.example.model.customerStorage

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()){
                call.respond(customerStorage)
            } else {
                call.respondHtml{
                    head {
                        title {
                            +"No customers founded"
                        }
                    }
                    body {
                        h1 {
                            +"No customers founded"
                        }
                        h2 {
                            +"Please specify your request"
                        }
                        form {
                            name = "calculator"
                            input {
                                type = InputType.button
                                value = "1"
                            }
                        }
                    }
                }
            }
        }
        get("{id}") {}
        post { }
        delete("{id}") {}
    }
}