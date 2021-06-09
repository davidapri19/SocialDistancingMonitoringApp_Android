package com.alphabangkit.socialdistancing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Entry(
    val url : String?,
    val id : String?
):Parcelable
