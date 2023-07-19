package com.example.chatapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.Navigation.Home
import com.example.chatapp.R
import com.example.chatapp.component.ButtonComponent
import com.example.chatapp.component.IconComponentImageVector
import com.example.chatapp.component.Spacerwidth
import com.example.chatapp.ui.theme.Aqua

@Composable
fun StartScreen(navHostController: NavHostController) {
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){

        Image(
            modifier = Modifier.padding(top = 80.dp , start = 20.dp).height(450.dp),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Box(modifier = Modifier
            .padding(top = 220.dp)
            .background(Color.Black)
            .align(Alignment.Center)){

            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 40.dp)) {
                Text(
                    text = stringResource(R.string.stay_connected_with_your_friend_and_family),
                    style = TextStyle(
                        Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))

                CustomxhexkBox()

            }
        }
        
        ButtonComponent(modifier  = Modifier
            .padding(22.dp)
            .align(Alignment.BottomCenter)) {
            
            navHostController.navigate(Home)
        }
    }
}


@Composable
fun CustomxhexkBox() {
    Row (
        modifier = Modifier.fillMaxWidth()
            ){
        Box(modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomEnd = 80.dp,
                    bottomStart = 80.dp
                )
            )
            .background(Aqua)
            .size(24.dp),
            contentAlignment = Alignment.Center)
        {
            IconComponentImageVector(icon = Icons.Default.Check, size = 15.dp,tint = Color.Black)
        }

        Spacerwidth(10.dp)
        Text(text = "Secure, private messaging" , style = TextStyle(
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        )
    }
}


