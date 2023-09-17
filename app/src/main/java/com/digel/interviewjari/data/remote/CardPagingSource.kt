package com.digel.interviewjari.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.digel.interviewjari.data.response.CardListResponse
import java.io.IOException

class CardPagingSource(
    private val service: Service,
    private val query: String
) : PagingSource<Int, CardListResponse.Data>() {

    private val page = 1

    override fun getRefreshKey(state: PagingState<Int, CardListResponse.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CardListResponse.Data> {
        return try {
            val currentPage = params.key ?: page

            val response = service.getCard(query, currentPage,20)
            val result = response.data
            val nextKey =
                if (result.isEmpty()) {
                    null
                } else {
                    currentPage + (params.loadSize / 20)
                }
            LoadResult.Page(data = result, prevKey = if (currentPage == page) null else currentPage, nextKey = nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}