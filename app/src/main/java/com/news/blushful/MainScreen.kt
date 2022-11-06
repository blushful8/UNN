package com.news.blushful


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.news.blushful.rss.Feed
import com.news.blushful.rss.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.w3c.dom.Text

@Composable
fun MainScreen(navController: NavController) {

    var data by remember { mutableStateOf<Feed?>(null) } //default value

    LaunchedEffect(key1 = null) {
        CoroutineScope(Dispatchers.Main).launch {
            val mFeed = RetrofitInstance.api.getFeedInfo().body()
            mFeed?.let { it: Feed ->
                data = it
            }
        }
    }
    Log.d("TAG", "${data.toString()}")
    if (data != null) {
        if (data!!.items.isNotEmpty()) {
            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 15.dp,
                    vertical = 5.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(count = data!!.items.size) { index ->
                    FeedItem(value = data!!.items[index], navController)
                    Divider(color = Color.Cyan)
                }
            }
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FeedItem(value: Item, navController: NavController) {
    val description = Jsoup.parse(value.description).text().replace("/", "")
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(AllScreens.DetailScree.route + "/${description}/${value.pubDate}")
            },
    ) {
        Text(text = value.pubDate, Modifier.padding(5.dp))
        Text(text = value.title)
        GlideImage(
            model = value.enclosure.link,
            contentDescription = "UNN"
        )
        //ImageView
    }
}