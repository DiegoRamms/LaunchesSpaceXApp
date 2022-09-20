package com.dbappgame.challengespacex.data.model

import com.google.gson.annotations.SerializedName

data class LaunchSiteDTO (
    @SerializedName("site_id")
    val siteId: String?,
    @SerializedName("site_name")
    val siteName: String?,
    @SerializedName("site_name_long")
    val siteNameLong: String?
)