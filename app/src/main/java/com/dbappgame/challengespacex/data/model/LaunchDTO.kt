package com.dbappgame.challengespacex.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class LaunchDTO (
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("mission_name")
    val missionName: String,
    val upcoming: Boolean,
    @SerializedName("launch_year")
    val launchYear: String,
    @SerializedName("launch_date_unix")
    val launchDateUnix: Int,
    @SerializedName("launch_date_utc")
    val launchDateUtc: String,
    @SerializedName("launch_date_local")
    val launchDateLocal: Date,
    val rocket: RocketDTO?,
    @SerializedName("launch_site")
    val launchSite: LaunchSiteDTO?,
    @SerializedName("launch_success")
    val launchSuccess: Boolean,
    @SerializedName("links")
    val links: BaseLinksDTO,
    val details: String
)





