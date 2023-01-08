package dev.prabhatpandey.instacompose.core.utils.errors

sealed class AppError @JvmOverloads constructor(
    override val message: String,
    override val cause: Throwable? = null
): Exception(message, cause) {
    data class AuthError constructor(
        override val message: String = "Authentication error.",
        override val cause: Throwable? = null
    ) : AppError(message, cause)

    data class ServerError constructor(
        override val message: String = "Server error.",
        override val cause: Throwable? = null
    ) : AppError(message, cause)

    data class ApiError constructor(
        override val message: String = "Something went wrong",
        override val cause: Throwable? = null,
        val response: Any? = null
    ) : AppError(message, cause)

    data class ConnectionError constructor(
        override val message: String = "Connection error.",
        override val cause: Throwable? = null
    ) : AppError(message, cause)

    data class UnknownError constructor(
        override val message: String = "Unknown error.",
        override val cause: Throwable? = null
    ) : AppError(message, cause)
}


