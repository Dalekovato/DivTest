package com.example.divtest.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.divtest.R
import com.example.divtest.data.networkDto.StatusImgNetwork
import com.example.divtest.data.model.CharactersDomain
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharactersScreen() {

    val charactersViewModel: CharactersViewModel = hiltViewModel()
    val characters by charactersViewModel.all.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 90.dp, 174.dp, 37.dp),
            style = MaterialTheme.typography.displayLarge,
            text = "Characters")

        LazyColumn {
            items(characters) { characters ->
                ItemCard(character = characters)
            }
        }

    }

}

@Composable
fun ItemCard(character: CharactersDomain) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 12.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            GlideImage(
                imageModel = { character.image },
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(40.dp)),

                ) {
                it.errorDrawable
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(modifier = Modifier
                        .width(137.dp)
                        .height(25.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight(400),
                            lineHeight = 25.06.sp,
                            fontSize = 21.sp
                        ),
                        text = character.name)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            modifier = Modifier
                                .width(40.dp)
                                .height(17.dp),
                            painter = painterResource(id = when (character.status) {
                                StatusImgNetwork.ALIVE -> R.drawable.alive
                                StatusImgNetwork.DEAD -> R.drawable.dead
                                StatusImgNetwork.UNKNOWN -> R.drawable.unknown
                            }),
                            contentDescription = null)
                    }
                }

                Text(
                    modifier = Modifier
                        .width(87.dp)
                        .height(17.dp),
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight(400),
                        lineHeight = 16.71.sp,
                        fontSize = 14.sp
                    ),
                    text = "${character.species}, ${character.gender}"
                )

                Button(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x1AFF6B00),
                        contentColor = Color(0xFFFF6B00),
                    ),
                    onClick = { /*TODO*/ },
                ) {
                    Image(
                        modifier = Modifier
                            .width(12.dp)
                            .height(10.dp),
                        painter = painterResource(id = R.drawable.button_img), contentDescription = null
                    )

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight(400),
                            lineHeight = 16.71.sp,
                            fontSize = 12.sp
                        ),
                        text = "Watch episode"
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier
                            .width(12.dp)
                            .height(12.dp),
                        painter = painterResource(id = R.drawable.location), contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .width(102.dp)
                            .height(17.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight(400),
                            lineHeight = 16.71.sp,
                            fontSize = 14.sp
                        ),
                        text = character.location.name
                    )
                }

            }

        }

    }

}




