package com.example.androiddevchallenge.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.components.HeaderRow
import com.example.androiddevchallenge.ui.components.RoundedImage
import com.example.androiddevchallenge.ui.components.ScrollToTopButton
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.list.PuppyListViewModel
import com.example.androiddevchallenge.viewmodel.list.PuppyListViewModelImpl
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

object PuppyListUi {

    @Composable
    fun Layout(puppyListViewModel: PuppyListViewModel,
               goToDetail: (Puppy) -> Unit) {
        val puppies = puppyListViewModel.puppies

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PuppyList(puppies = puppies, onItemClicked = goToDetail)
        }
    }

    @OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
    @Composable
    fun PuppyList(puppies: Map<Char, List<Puppy>>, onItemClicked: (Puppy) -> Unit) {
        Box {
            val scrollState = rememberLazyListState()
            val scope = rememberCoroutineScope()

            LazyColumn(
                state = scrollState,
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                puppies.forEach {
                    stickyHeader {
                        HeaderRow(title = it.key.toString())
                    }

                    items(it.value) { puppy ->
                        PuppyRow(puppy, onItemClicked)
                    }
                }
            }

            val isScrollToTopShown = scrollState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = isScrollToTopShown,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                ScrollToTopButton(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        scope.launch {
                            scrollState.scrollToItem(0)
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun PuppyRow(puppy: Puppy, onClick: (Puppy) -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(puppy) },
            elevation = 4.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                RoundedImage(
                    url = puppy.imageUrl,
                    modifier = Modifier.size(48.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f)
                ) {
                    Text(text = puppy.name)
                    Text(text = puppy.breed)
                }

                Icon(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = "Go to Puppy Details",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
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
        PuppyListUi.PuppyRow(testPuppy) { }
    }
}