package c.m.popcorn.core.presentation.custom

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import c.m.popcorn.R

@Composable
fun AppBarTitleText(title: String?, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = title ?: stringResource(id = R.string.app_name),
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}