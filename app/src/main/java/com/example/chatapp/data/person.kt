package com.example.chatapp.data


import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.chatapp.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int = 0,
    val name: String = "",
    @DrawableRes val icon: Int = R.drawable.user1
) : Parcelable


val personList = listOf(
    Person(
        1,
        "Pranav",
        R.drawable.user1
    ),
    Person(
        2,
        "Ayesha",
        R.drawable.user2
    ),
    Person(
        3,
        "Roshini",
        R.drawable.user3
    ),
    Person(
        4,
        "Kaushik",
        R.drawable.user4
    ),
    Person(
        5,
        "Dad",
        R.drawable.user5
    ),
    Person(
        6,
        "Pranav",
        R.drawable.user1
    ),
    Person(
        7,
        "Ayesha",
        R.drawable.user2
    ),
    Person(
        8,
        "Roshini",
        R.drawable.user3
    ),
    Person(
        9,
        "Kaushik",
        R.drawable.user4
    ),
    Person(
        10,
        "Dad",
        R.drawable.user5
    ),
)