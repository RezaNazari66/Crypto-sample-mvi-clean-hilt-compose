package com.rezanazari.feature_crypto_list.presentation.composable

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import collectAsStateWithLifecycle
import collectWithLifecycle
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.rezanazari.feature_crypto_list.R
import com.rezanazari.feature_crypto_list.presentation.ExchangeEvent
import com.rezanazari.feature_crypto_list.presentation.ExchangeIntent
import com.rezanazari.feature_crypto_list.presentation.ExchangeUiState
import com.rezanazari.feature_crypto_list.presentation.ExchangesViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun ExchangesRout(
    viewModel: ExchangesViewModel = hiltViewModel()
) {
    HandleEvents(viewModel.event)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ExchangesScreen(
        uiState = uiState,
        onExchangeClicked = {
            viewModel.acceptIntent(ExchangeIntent.ExchangeClicked(it))
        },
        onExchangesRefresh = {
            viewModel.acceptIntent(ExchangeIntent.GetExchanges)
        }
    )
}

@Composable
fun ExchangesScreen(
    uiState: ExchangeUiState,
    onExchangeClicked: (String) -> Unit,
    onExchangesRefresh: () -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(snackbarHost = { SnackbarHost(snackBarHostState) }) { padding ->

        SwipeRefresh(
            state = rememberSwipeRefreshState(uiState.isLoading),
            onRefresh = onExchangesRefresh,
            modifier = Modifier
                .padding(padding)
        ) {
            if (uiState.exchangeList.isNotEmpty()) {
                ExchangeContent(
                    snackbarHostState = snackBarHostState,
                    uiState = uiState,
                    onExchangeClicked = onExchangeClicked
                )
            } else {
                ExchangeNotFoundContent(
                    uiState = uiState
                )
            }
        }
    }
}

@Composable
fun ExchangeNotFoundContent(uiState: ExchangeUiState) {
    when {
        uiState.isLoading -> ExchangeLoadingPlaceholder()
        uiState.isError -> ExchangeErrorContent()
    }
}

@Composable
fun ExchangeContent(
    snackbarHostState: SnackbarHostState,
    uiState: ExchangeUiState,
    onExchangeClicked: (String) -> Unit
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.exchange_error_refreshing)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    ExchangeListContent(
        exchangeList = uiState.exchangeList,
        onExchangeCLicked = { onExchangeClicked(it) }
    )
}


@Composable
fun HandleEvents(events: Flow<ExchangeEvent>) {
    val context = LocalContext.current
    events.collectWithLifecycle {
        when (it) {
            is ExchangeEvent.ShowToast -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
