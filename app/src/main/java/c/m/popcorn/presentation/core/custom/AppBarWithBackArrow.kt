package c.m.popcorn.presentation.core.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import c.m.popcorn.R
import c.m.popcorn.presentation.core.ui.theme.PopCornTheme
import c.m.popcorn.presentation.core.ui.theme.Red500

@Composable
fun AppBarWithArrow(title: String?, pressOnBack: () -> Unit) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = Red500,
        modifier = Modifier.height(64.dp)
    ) {
        Row {
            Spacer(modifier = Modifier.width(16.dp))

            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    Color.White
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable { pressOnBack() }
            )

            Spacer(modifier = Modifier.width(16.dp))

            AppBarTitleText(
                title = title ?: stringResource(id = R.string.content_detail),
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Composable
@Preview(name = "App Bar with Back Arrow")
fun AppBarWithArrowPreview() {
    PopCornTheme {
        AppBarWithArrow(title = stringResource(id = R.string.content_detail)) {}
    }
}