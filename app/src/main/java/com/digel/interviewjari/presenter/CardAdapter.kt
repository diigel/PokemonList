package com.digel.interviewjari.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digel.interviewjari.common.CardDiffCallBack
import com.digel.interviewjari.common.loadImage
import com.digel.interviewjari.data.response.CardListResponse
import com.digel.interviewjari.databinding.ItemCardPokemonBinding

class CardAdapter : PagingDataAdapter<CardListResponse.Data,CardAdapter.CardViewHolder>(CardDiffCallBack()) {

    private var itemClick: ((data: CardListResponse.Data) -> Unit)? = null

    fun onItemClick(itemClick: (data: CardListResponse.Data) -> Unit) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ItemCardPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position), itemClick)
    }

    inner class CardViewHolder(private val viewBinding: ItemCardPokemonBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(data: CardListResponse.Data?, itemClick: ((data: CardListResponse.Data) -> Unit)? = null) =
            viewBinding.run {
                data?.let {
                    imgBackgroundPath.loadImage(it.images.large)
                    imgInfo.loadImage(it.images.small)
                    txtTitle.text = it.name
                    txtRelease.text = it.evolvesFrom
                    txtDescription.text = it.abilities?.firstOrNull()?.text
                    root.setOnClickListener {
                        itemClick?.invoke(data)
                    }
                }
            }
    }
}