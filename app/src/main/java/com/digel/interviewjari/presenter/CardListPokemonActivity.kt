package com.digel.interviewjari.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.digel.interviewjari.databinding.ActivityCardListPokemonBinding
import com.digel.interviewjari.presenter.viewmodel.CardViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardListPokemonActivity : AppCompatActivity() {

    private val viewModel by viewModel<CardViewModel>()
    private lateinit var viewBinding: ActivityCardListPokemonBinding

    private val cardAdapter by lazy {
        CardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCardListPokemonBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        initView()
        collectUiState()
    }

    private fun initView() = viewBinding.run {
        rvCard.apply {
            layoutManager = LinearLayoutManager(this@CardListPokemonActivity)
            adapter = cardAdapter.withLoadStateHeaderAndFooter(
                header = CardLoadStateAdapter { cardAdapter.retry() },
                footer = CardLoadStateAdapter { cardAdapter.retry() }
            )
        }

        cardAdapter.addLoadStateListener { renderUi(it) }
        btnRetry.setOnClickListener { cardAdapter.retry() }
        etSearch.addTextChangedListener {
            lifecycleScope.launch {
                delay(800)
                collectUiState("name:${it.toString()}")
            }
        }
    }

    private fun collectUiState(query : String? = null) {
        lifecycleScope.launch {
            viewModel.getMovies(query.orEmpty()).collectLatest { data ->
                cardAdapter.submitData(data)
            }
        }
    }


    private fun renderUi(loadState: CombinedLoadStates) {
        val isListEmpty = loadState.refresh is LoadState.NotLoading && cardAdapter.itemCount == 0

        viewBinding.run {
            rvCard.isVisible = !isListEmpty
            rvCard.isVisible = loadState.source.refresh is LoadState.NotLoading
            progressBar.isVisible = loadState.source.refresh is LoadState.Loading
            btnRetry.isVisible = loadState.source.refresh is LoadState.Error
        }
    }
}