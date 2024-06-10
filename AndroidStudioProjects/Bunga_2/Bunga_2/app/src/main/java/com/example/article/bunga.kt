package com.example.article

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class bunga(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
