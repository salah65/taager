package com.Tagger.taager.data.network


data class Resource<out T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val title: String? = null
) {

    companion object {

        fun <T> success(data: T?): Resource<T>? {
            return Resource(
                Status.SUCCESS,
                data
            )
        }

        fun <T> error(title: String, message: String?): Resource<T> {
            return Resource(
                Status.ERROR,
                message = message,
                title = title
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource(
                Status.LOADING
            )
        }

    }

}


enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}