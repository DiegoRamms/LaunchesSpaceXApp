package com.dbappgame.challengespacex.data.model

import com.google.gson.annotations.SerializedName

data class BaseLinksDTO (
    @SerializedName("mission_patch")
    val missionPatch: String,
    @SerializedName("mission_patch_small")
    val missionPatchSmall: String,
    @SerializedName("article_link")
    val articleLink: String,
    @SerializedName("wikipedia")
    val wikipedia: String,
    @SerializedName("video_link")
    val videoLink: String,
    @SerializedName("flickr_images")
    val flickrImages: List<String>
)