package com.digel.interviewjari.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digel.interviewjari.databinding.FooterLoadStateBinding

class CardLoadStateAdapter(val retry: () -> Unit) :
    LoadStateAdapter<CardLoadStateAdapter.CardLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: CardLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState, retry)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): CardLoadStateViewHolder {
        return CardLoadStateViewHolder(
            FooterLoadStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class CardLoadStateViewHolder(private val viewBinding: FooterLoadStateBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(loadState: LoadState, retry: () -> Unit) {
            viewBinding.run {
                if (loadState is LoadState.Error) {
                    txtDesc.text = loadState.error.localizedMessage
                }

                progressLoadMore.isVisible = loadState is LoadState.Loading
                btnRetry.isVisible = loadState is LoadState.Error
                txtDesc.isVisible = loadState is LoadState.Error

                viewBinding.btnRetry.setOnClickListener { retry.invoke() }

            }
        }
    }
}