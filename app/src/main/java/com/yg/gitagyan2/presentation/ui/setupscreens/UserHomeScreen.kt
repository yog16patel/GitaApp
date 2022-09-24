package com.yg.gitagyan2.presentation.ui.setupscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.utils.fontFamily
import com.yg.gitagyan2.R
import com.yg.gitagyan2.presentation.res.Dimensions.gitaPadding
import com.yg.gitagyan2.presentation.res.Dimensions.gitaPadding2x
import com.yg.gitagyan2.presentation.ui.theme.*


@Composable
fun UserHomeScreen(
    navigateToChapterList: () -> Unit
) {
    Column {
        StatusBar()
        QuoteBox()
        CurrentProgress()
        LikedSlokas()
        ExploreGita(navigateToChapterList)
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Divider(
            color = Bhagwa,
            modifier = Modifier
                .height(50.dp)
                .width(4.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = gitaPadding2x
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Good Morning,",
                    fontFamily = fontFamily,
                    color = TextBlack,
                    fontSize = 20.sp
                )

                Text(
                    text = "Ritu",
                    fontFamily = fontFamily,
                    color = Bhagwa,
                    fontSize = 20.sp
                )
            }
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "",
                tint = Bhagwa,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun QuoteBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = gitaPadding2x),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.krishna_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .height(100.dp)
                .blur(300.dp)
        )
        Text(
            text = "The only way you can conquer me is via love, and there I am happily conquered.",
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun CurrentProgress() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Bhagwa),
        ) {

            Row(
                modifier = Modifier
                    .padding(
                        start = gitaPadding2x,
                        end = gitaPadding2x,
                        top = gitaPadding
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "CURRENT PROGRESS",
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    color = TextWhite,
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_book_icon),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )

            }
            Row(
                modifier = Modifier
                    .padding(
                        start = gitaPadding2x,
                        end = gitaPadding2x,
                        top = gitaPadding
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "42%",
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = TextWhite,
                    fontSize = 25.sp
                )
                Column {
                    Row {
                        Text(text = "Adhyay", fontFamily = fontFamily, color = TextWhite)
                        Spacer(modifier = Modifier.width(gitaPadding2x))
                        Text(text = "6", fontFamily = fontFamily, color = TextWhite)

                    }
                    Row {
                        Text(text = "Sloka", fontFamily = fontFamily, color = TextWhite)
                        Spacer(modifier = Modifier.width(gitaPadding2x))
                        Text(text = "16", fontFamily = fontFamily, color = TextWhite)
                    }
                }
            }
            LinearProgressIndicator(
                progress = 0.5f,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = gitaPadding2x,
                        end = gitaPadding2x,
                        top = gitaPadding
                    )
            )

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        gitaPadding2x,
                    )
                    .clip(RoundedCornerShape(10.dp)),
                onClick = {

                }) {
                Text(
                    text = "CONTINUE READING",
                    Modifier
                        .padding(gitaPadding2x)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun LikedSlokas() {
    BoxWithConstraints(
        modifier = Modifier
            .padding(start = gitaPadding2x, end = gitaPadding2x)
            .clip(RoundedCornerShape(10.dp))
            .background(DarkPink)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(gitaPadding2x)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_heartliked_icon),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopEnd),
                tint = WhiteBackground
            )

            Text(
                text = "13",
                fontFamily = fontFamily,
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier.align(
                    Alignment.CenterStart
                )
            )
            Text(
                text = "LIKED SLOKAS",
                fontFamily = fontFamily,
                color = TextWhite,
                fontSize = 25.sp,
                modifier = Modifier.align(
                    Alignment.BottomStart
                )
            )
        }
    }
}

@Composable
fun ExploreGita(
    navigateToChapterList: () -> Unit
) {
    TextButton(
        onClick = { navigateToChapterList() }) {
        Text(
            text = "EXPLORE GITA",
            modifier = Modifier
                .padding(gitaPadding),
            color = Bhagwa
        )
    }
    Button(
        border = BorderStroke(1.dp, Bhagwa),
        modifier = Modifier
            .fillMaxWidth()
            .padding(gitaPadding2x),
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        onClick = {
            navigateToChapterList()
        }) {

    }
}







