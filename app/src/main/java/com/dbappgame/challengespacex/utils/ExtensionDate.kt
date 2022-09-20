package com.dbappgame.challengespacex.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toBaseFormat() =
    SimpleDateFormat("MMMM/dd/yyyy", Locale.US).format(this) ?: "No Date"
