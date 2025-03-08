package com.revmabit.willbuddy.shared


data class Email(val email: String) {

    init {
        require(isValidEmail(email)) { "Invalid email format" }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})$".toRegex()
        return emailRegex.matches(email)
    }
}

data class MobileNumber(val phone: String) {
    init {
        require(isValidEmail(phone)) { "Invalid email format" }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})$".toRegex()
        return emailRegex.matches(email)
    }
}
