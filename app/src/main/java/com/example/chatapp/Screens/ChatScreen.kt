package com.example.chatapp.Screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.R
import com.example.chatapp.component.IconComponentDrawable
import com.example.chatapp.component.IconComponentImageVector
import com.example.chatapp.component.Spacerwidth
import com.example.chatapp.data.Person
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.style.TextAlign
import com.example.chatapp.data.Chat
import com.example.chatapp.data.chatList
import com.example.chatapp.ui.theme.Gray
import com.example.chatapp.ui.theme.LightRed

@Composable
fun ChatScreen(navHostController: NavHostController) {

    var message by remember { mutableStateOf(" ") }
    val person =
        navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("data") ?: Person()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
            UserEachRow(
                person = person,
                modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp)
            )
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(
                    White, RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp
                    )
                )
                .padding(top = 25.dp)
            ){

                LazyColumn(
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 25.dp,
                        bottom = 75.dp
                    )
                ) {
                    items(chatList , key = {it.id}){
                        chatRow(chat = it)
                    }
                }

                TextFieldComponent(text = message, modifier = Modifier
                    .padding(20.dp)
                    .align(
                        Alignment.BottomCenter
                    )){
                    message = it
                }
            }
        }
    }
}

@Composable
fun chatRow(
    chat: Chat
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if(chat.direction)Alignment.Start else Alignment.End
    ) {
        Box(modifier = Modifier.background(
            if(chat.direction) LightRed
            else Yellow
        ,
            RoundedCornerShape(100.dp)
        ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = chat.message, style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
                textAlign = TextAlign.End
            )
        }
        Text(
            text = chat.time,
            style = TextStyle(
                color = Gray,
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
        )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged:(String)->Unit
) {
    
    TextField(value = text,
        onValueChange = onValueChanged,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(160.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder ={
            Text(text = stringResource(R.string.type_message) , style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            )
            )
        },
        leadingIcon = { CommonIconButton(imageVector = Icons.Default.Add)},
        trailingIcon = { CommonIconButtonDrawable(icon = R.drawable.mic)},
        


        )

}



@Composable
fun CommonIconButton(
    imageVector: ImageVector
) {

    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), contentAlignment = Alignment.Center
    ) {
        IconComponentImageVector(icon = imageVector, size = 15.dp, tint = Color.Black)
    }

}

@Composable
fun CommonIconButtonDrawable(
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .background(Yellow, CircleShape)
            .size(33.dp), contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.size(15.dp)
        )
    }

}

@Composable
fun UserEachRow(
    modifier: Modifier = Modifier,
    person: Person
) {
    Row (
        modifier = modifier.fillMaxWidth().padding(bottom = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row {
            IconComponentDrawable(icon = person.icon, size = 42.dp)
            Spacerwidth()
            Column {
                Text(
                    text = person.name,
                    style = TextStyle(
                        color = White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ))
                Text(
                    text = "Online",
                    style = TextStyle(
                        color = White,
                        fontSize = 13.sp,

                    ))
            }
        }
        
        IconComponentImageVector(
            icon = Icons.Default.MoreVert,
            size =24.dp,
            tint = White
        )
    }
}