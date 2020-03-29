package com.phelat.tedu.functional

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

@OptIn(ExperimentalCoroutinesApi::class)
inline fun <T, R> Flow<List<T>>.mapForEach(crossinline transform: (value: T) -> R): Flow<List<R>> = transform { value ->
    val mappedList = value.map { transform(it) }
    return@transform emit(mappedList)
}