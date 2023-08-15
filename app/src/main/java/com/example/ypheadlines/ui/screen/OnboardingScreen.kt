package com.example.ypheadlines.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.ypheadlines.R
import com.example.ypheadlines.presentation.onboarding.pages
import com.example.ypheadlines.ui.component.Dimens
import com.example.ypheadlines.ui.component.PageIndicator
import com.example.ypheadlines.ui.component.YPHFilledButton
import com.example.ypheadlines.ui.component.YPHTextButton
import com.example.ypheadlines.ui.theme.YPHeadlinesTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val pageStateList = listOf(
            LocalContext.current.resources.getStringArray(R.array.first_page).toList(),
            LocalContext.current.resources.getStringArray(R.array.second_page).toList(),
            LocalContext.current.resources.getStringArray(R.array.third_page).toList()
        )
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> pageStateList[0]
                    1 -> pageStateList[1]
                    2 -> pageStateList[2]
                    else -> emptyList()
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.DisplayPadding)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(Dimens.PageIndicatorWidth),
                pageCount = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {

                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    YPHTextButton(text = buttonState.value[0]) {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    }
                }
                YPHFilledButton(
                    text = buttonState.value[1]
                ) {
                    scope.launch {
                        if (pagerState.currentPage == 3) {
                            //TODO: Navigate to home screen
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    YPHeadlinesTheme {
        Surface {
            OnboardingScreen()
        }
    }
}