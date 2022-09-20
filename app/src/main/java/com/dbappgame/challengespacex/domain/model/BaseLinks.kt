package com.dbappgame.challengespacex.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseLinks (
    val missionPatch: String?,
    val missionPatchSmall: String?,
    val articleLink: String?,
    val wikipedia: String?,
    val videoLink: String?,
    val flickrImages: List<String>
): Parcelable