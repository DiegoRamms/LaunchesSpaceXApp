package com.dbappgame.challengespacex.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchSite (
    val siteId: String?,
    val siteName: String?,
    val siteNameLong: String?
): Parcelable