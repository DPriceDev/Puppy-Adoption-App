package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import com.example.androiddevchallenge.R
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.MyApp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

data class Puppy(val name: String,
                 val breed: String,
                 val imageUrl: String)

object PuppyListUi {

    @Composable
    fun PuppyListLayout() {
        // todo: viewmodel, hilt?

        val items = listOf(
            Puppy(
                "Henry",
                "Sausage",
                "https://dogtime.com/assets/uploads/2011/03/puppy-development-1280x720.jpg"
            ),
            Puppy(
                "Tom",
                "Hund",
                "https://dogtime.com/assets/uploads/2011/03/puppy-development-1280x720.jpg"
            )
        )

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PuppyList(puppies = items)
        }

    }

    @Composable
    fun PuppyList(puppies: List<Puppy>) {
        val scrollState = rememberLazyListState()
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
        ) {
            items(puppies) { puppy ->
                PuppyRow(puppy)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    @Composable
    fun PuppyRow(puppy: Puppy) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            elevation = 8.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                PuppyIcon(puppy.imageUrl)
                Spacer(modifier = Modifier.width(8.dp))

                Column(

                ) {
                    Text(text = puppy.name)
                    Text(text = puppy.breed)
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right_24),
                    contentDescription = "Go to Puppy Details",
                    modifier = Modifier.size(24.dp)

                )
            }
        }
    }

    @Composable
    fun PuppyIcon(url: String) {
        CoilImage(
            data = url,
            contentDescription = "Picture of Puppy",
            requestBuilder = {
                transformations(CircleCropTransformation())
            },
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview("Light Theme")
@Composable
private fun PuppyRowPreview() {
    val testPuppy = Puppy(
        "Pups",
        "Doggo",
        "https://dogtime.com/assets/uploads/2011/03/puppy-development-1280x720.jpg"
    )

    MyTheme {
        PuppyListUi.PuppyRow(testPuppy)
    }
}