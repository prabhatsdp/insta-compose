package dev.prabhatpandey.instacompose.core.utils.extensions

import dev.prabhatpandey.instacompose.core.utils.errors.AppError
import dev.prabhatpandey.retrofitadapter.NetworkResponse

fun<T: Any> NetworkResponse<Any, T>.toDomainError() : AppError {
    return when(this) {
        is NetworkResponse.ApiError -> {
            AppError.ApiError(message = "Api Error", response = this.body)
        }
        is NetworkResponse.AuthError -> {
            AppError.AuthError(message = "Authentication failed.")
        }
        is NetworkResponse.ServerError -> {
            AppError.ServerError()
        }
        is NetworkResponse.NetworkError -> AppError.ConnectionError()
        else -> AppError.UnknownError()
    }
}
