package com.portfolio.flux.example

import com.fasterxml.jackson.annotation.JsonIgnore

class Greeting(
        private var message: String
) {
    public fun setMessage(message: String){
        this.message = message
    }

    public fun getMessage(): String {
        return this.message
    }

    override fun toString(): String {
        return "Greeting(message='$message')"
    }

}