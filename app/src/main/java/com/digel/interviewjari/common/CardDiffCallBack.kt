package com.digel.interviewjari.common

import androidx.recyclerview.widget.DiffUtil
import com.digel.interviewjari.data.response.CardListResponse

class CardDiffCallBack : DiffUtil.ItemCallback<CardListResponse.Data>() {
    override fun areItemsTheSame(
        oldItem: CardListResponse.Data,
        newItem: CardListResponse.Data
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CardListResponse.Data,
        newItem: CardListResponse.Data
    ): Boolean {
        return oldItem == newItem
    }

}

