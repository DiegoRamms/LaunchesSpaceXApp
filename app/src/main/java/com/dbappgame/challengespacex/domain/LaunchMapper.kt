package com.dbappgame.challengespacex.domain

import com.dbappgame.challengespacex.data.model.*
import com.dbappgame.challengespacex.domain.model.*
import com.dbappgame.challengespacex.utils.toBaseFormat

object LaunchMapper {

    fun List<LaunchDTO>.toDomainList() = this.map { it.toDomain() }

    private fun LaunchDTO.toDomain(): Launch {
        return Launch(
            this.flightNumber,
            this.missionName,
            this.upcoming,
            this.launchYear,
            this.launchDateUnix,
            this.launchDateUtc,
            this.launchDateLocal.toBaseFormat(),
            this.rocket?.toDomain(),
            this.launchSite?.toDomain(),
            this.launchSuccess,
            this.links.toDomain(),
            this.details
        )
    }

    private fun RocketDTO?.toDomain(): Rocket? {
        this?.let {
            return Rocket(
                this.rocketId,
                this.rocketName,
                this.rocketName
            )
        }
        return null
    }


    private fun LaunchSiteDTO?.toDomain(): LaunchSite? {
        return this?.let {
            LaunchSite(
                this.siteId,
                this.siteName,
                this.siteNameLong
            )
        }
    }


    private fun BaseLinksDTO.toDomain(): BaseLinks =

            BaseLinks(
                this.missionPatch,
                this.missionPatchSmall,
                this.articleLink,
                this.wikipedia,
                this.videoLink,
                this.flickrImages
            )

}

