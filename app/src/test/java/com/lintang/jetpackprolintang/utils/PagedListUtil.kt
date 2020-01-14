@file:Suppress("UNCHECKED_CAST")

package com.lintang.jetpackprolintang.utils

import androidx.paging.PagedList
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer


object PagedListUtil {
    fun <T> mockPagedList(list: List<T>): PagedList<T>? {
        val pagedList: PagedList<T> = mock(PagedList::class.java) as PagedList<T>
        val answer = Answer { invocation: InvocationOnMock ->
            val index = invocation.arguments[0] as Int
            list[index]
        }
        `when`(pagedList[anyInt()]).thenAnswer(answer)
        `when`(pagedList.size).thenReturn(list.size)
        return pagedList
    }
}