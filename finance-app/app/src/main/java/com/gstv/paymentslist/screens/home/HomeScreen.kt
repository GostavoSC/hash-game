package com.gstv.paymentslist.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MainViewModel = getViewModel()) {
    val state = viewModel.state.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Payments Monthly") })
        },
        bottomBar = {
            BottomAppBar {
                BottomBarContent(
                    currentMonth = state.currentMonth.name,
                    onNextMonth = {},
                    onPreviousMonth = {}
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .consumeWindowInsets(it)
                .padding(it),
        ) {
            HomeList()
        }
    }
}

@Composable
private fun BottomBarContent(
    currentMonth: String,
    onNextMonth: () -> Unit,
    onPreviousMonth: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onPreviousMonth() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier.size(36.dp)
            )
        }
        Text(
            text = "Fevereiro",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        IconButton(onClick = { onNextMonth() }) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Composable
private fun HomeList() {
    Column {
        DateCard(date = "08/11", paymentsTitle = listOf("Cartão 1", "Cartão 2", "Cartão 3"))
        DateCard(date = "10/11", paymentsTitle = listOf("Água", "Luz", "Internet"))
        DateCard(date = "15/11", paymentsTitle = listOf("Caixa", "Entrada do Ap"))
    }
}

@Composable
fun DateCard(date: String, paymentsTitle: List<String>) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(paymentsTitle) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
private fun HomeScreenContent() {

}