package ir.kaaveh.shopbascket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ShopCardListItem(
    item: Item = Item(
        1, "260,000", "تومان", "#2CC84D", "کیف", ""
    )
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(7f)) {
            Text(
                text = item.productName,
                style = TextStyle(textAlign = TextAlign.End),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        contentDescription = "",
                        tint = Color(android.graphics.Color.parseColor("#FFA830")),
                    )
                    Text(
                        text = item.quantity.toString(),
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "",
                        tint = Color(android.graphics.Color.parseColor("#FFA830")),
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = item.currencyPrice,
                    color = Color(android.graphics.Color.parseColor(item.colorPrice)),
                    modifier = Modifier.padding(end = 3.dp),
                )
                Text(
                    text = item.price,
                    color = Color(android.graphics.Color.parseColor(item.colorPrice))
                )
            }
        }
        Column(modifier = Modifier.weight(3f)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "description of the image",
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        }
    }
}