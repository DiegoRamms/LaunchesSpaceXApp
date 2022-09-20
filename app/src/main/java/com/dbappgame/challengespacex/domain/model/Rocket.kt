package com.dbappgame.challengespacex.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rocket (
    val rocketId: String?,
    val rocketName: String?,
    val rocketType: String?,
): Parcelable