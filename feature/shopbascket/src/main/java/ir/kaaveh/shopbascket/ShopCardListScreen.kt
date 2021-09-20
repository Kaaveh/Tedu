package ir.kaaveh.shopbascket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ShopCardListScreen(
    viewModel: ShopCardListViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close",
                    tint = Color.Gray
                )
                Text(
                    text = "سبد خرید",
                    style = MaterialTheme.typography.h6,
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = state.shopName,
                    style = MaterialTheme.typography.h6,
                    color = Color(android.graphics.Color.parseColor("#2CC84D")),
                    modifier = Modifier
                        .padding(16.dp),
                )
            }
            Divider()
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(items = state.items) { item ->
                    ShopCardListItem(item = item)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "${state.currency} ${state.allPrice}")
                Text(
                    text = "ادامه فرآیند خرید",
                    modifier = Modifier
                        .background(
                            color = Color(android.graphics.Color.parseColor("#2CC84D")),
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    color = Color.White
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}