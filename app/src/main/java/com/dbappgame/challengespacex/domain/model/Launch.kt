package com.dbappgame.challengespacex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Launch (
    val flightNumber: Int?,
    val missionName: String?,
    val upcoming: Boolean?,
    val launchYear: String?,
    val launchDateUnix: Int?,
    val launchDateUtc: String?,
    val launchDateLocal: String?,
    val rocket: Rocket?,
    val launchSite: LaunchSite?,
    val launchSuccess: Boolean?,
    val links: BaseLinks,
    val details: String?
): Parcelable
