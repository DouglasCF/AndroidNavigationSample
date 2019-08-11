package br.com.fornaro.sample.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SomeObj(val title: String, val description: String) : Parcelable