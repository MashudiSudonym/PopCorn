package c.m.popcorn.presentation.core.custom

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.popcorn.R
import c.m.popcorn.presentation.core.ui.theme.PopCornTheme

@Composable
fun DefaultAppBar(title: String?, icon: ImageVector) {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.height(64.dp),
    ) {
        Row {
            Spacer(modifier = Modifier.width(16.dp))

            Icon(imageVector = icon, contentDescription = null)

            Spacer(modifier = Modifier.width(16.dp))

            AppBarTitleText(
                title = title ?: stringResource(id = R.string.app_name),
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Composable
@Preview(name = "App Bar")
fun AppBarPreview() {
    PopCornTheme {
        DefaultAppBar(title = stringResource(id = R.string.app_name), icon = Icons.Filled.Movie)
    }
}