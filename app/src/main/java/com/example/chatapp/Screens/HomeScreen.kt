package com.example.chatapp.Screens

import android.annotation.SuppressLint
import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.Navigation.Chat
import com.example.chatapp.R
import com.example.chatapp.component.IconComponentDrawable
import com.example.chatapp.component.IconComponentImageVector
import com.example.chatapp.component.SpacerHeight
import com.example.chatapp.component.Spacerwidth
import com.example.chatapp.data.Person
import com.example.chatapp.data.personList
import com.example.chatapp.ui.theme.Line

@Composable
fun HomeScreen(navHostController: NavHostController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){
       Column(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp)
       ) {
           HeaderandStory()
           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .clip(
                       RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                   )
                   .background(Color.White)
           ){
               BottomSwip(
                   modifier = Modifier
                       .padding(top = 15.dp)
                       .align(TopCenter)
               )
               LazyColumn(modifier = Modifier.padding(top = 30.dp , bottom = 15.dp)){
                   items(personList , key = {it.id}){
                       UserEachRow(person = it) {
                           navHostController.currentBackStackEntry?.savedStateHandle?.set("data",it)
                           navHostController.navigate(Chat)

                       }
                   }
               }
           }
       }
    }
}

@Composable
fun UserEachRow(
    modifier: Modifier = Modifier,
    person: Person,
    onClick:() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable{ onClick() }
            .padding(vertical = 5.dp, horizontal = 20.dp)
    ){
        Column {
            Row (
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row {
                    IconComponentDrawable(icon = person.icon, size = 70.dp)
                    Spacerwidth()
                    Column {

                        Text(text = person.name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ))
                        SpacerHeight(5.dp)
                        Text(text = "Okay",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 14.sp,
                            ))
                    }
                }
                Text(text = "02.55 Am",
                    style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                ))
            }
            SpacerHeight(15.dp)
            Divider(modifier = modifier.fillMaxWidth() , thickness = 1.dp , color = Line)
        }
    }
}

@Composable
fun BottomSwip(
    modifier: Modifier=Modifier
) {
    Box(modifier = modifier
        .clip(RoundedCornerShape(90.dp))
        .width(90.dp)
        .height(5.dp)
        .background(Color.Gray)
    )
}

@Composable
fun HeaderandStory() {
    Column (
        modifier = Modifier.padding(start = 20.dp , top = 20.dp)
    ){
        Header()
        ViewStoryLayout()
    }
}

@Composable
fun Header() {

    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        ){
            append("Welcome back, ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        ){
            append("Yash!")
        }
    }
    Text(text = text)
}

@Composable
fun ViewStoryLayout() {
    LazyRow(modifier = Modifier.padding(vertical = 20.dp)){
        item {
            AddStoryLayout()
            Spacerwidth()
        }
        items(personList , key = {it.id}) {
            UserStoryLayout(person = it)
        }
    }
}

@Composable
fun AddStoryLayout() {
    Column {
        Box(modifier = Modifier
            .border(2.dp, Color.DarkGray, CircleShape)
            .background(Color.White, CircleShape)
            .size(70.dp)
            , contentAlignment = Center
        ){
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black)
                .size(20.dp)
            , contentAlignment = Center
            ){
                IconComponentImageVector(icon = Icons.Default.Add, size = 12.dp, tint = Color.White)
            }
        }
        SpacerHeight(8.dp)
        Text(text = stringResource(R.string.add_story),
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ),
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@Composable
fun UserStoryLayout(
    modifier: Modifier = Modifier,
    person: Person
) {
    Column(modifier = modifier.padding(end = 10.dp)) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(Color.White, CircleShape)
            .size(70.dp)
        , contentAlignment = Center
        ){
            IconComponentDrawable(icon = person.icon, size = 65.dp)
        }
        SpacerHeight(8.dp)

        Text(text = person.name,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ),
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}

//@SuppressLint("UnnecessaryComposedModifier")
//fun Modifier.noRippleEffect(onClick: () -> Unit) = composed {
//    clickable(
//        interactionSource = MutableInteractionSource(),
//        indication = null
//    ) {
//        onClick()
//    }
//}