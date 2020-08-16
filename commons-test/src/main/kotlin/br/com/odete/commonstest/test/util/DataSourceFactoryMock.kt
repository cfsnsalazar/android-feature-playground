package br.com.odete.commonstest.test.util

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource

class DataSourceFactoryMock<T>(private val list: List<T>) : DataSource.Factory<Int, T>() {
    override fun create(): DataSource<Int, T> = DataSourceMock(list)

    internal class DataSourceMock<T>(private val list: List<T>) : PageKeyedDataSource<Int, T>() {
        override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<Int, T>
        ) {

            callback.onResult(list, null, null)
        }

        override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
            // empty
        }

        override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
            // empty
        }
    }
}
