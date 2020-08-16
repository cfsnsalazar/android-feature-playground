package br.com.odete.commonstest.test.util

import androidx.paging.PagedList
import java.util.concurrent.Executors

object PageListMock {

    private const val PAGE_SIZE = 10

    fun <T> list(list: List<T>): PagedList<T> {
        return PagedList.Builder(DataSourceFactoryMock(list).create(), PAGE_SIZE)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}
