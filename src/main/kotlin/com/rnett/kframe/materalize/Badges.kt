package com.rnett.kframe.materalize

import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.Attributes

fun <T : AnyElement> T.badge(): T {
    this addClass "badge"
    return this
}

infix fun <T : AnyElement> T.badge(new: Boolean): T {
    this addClass "badge${if (new) " new" else ""}"
    return this
}


fun <T : AnyElement> T.newBadge(): T {
    this addClass "new badge"
    return this
}

var Attributes.badgeCaption
    get() = this["data-badge-caption"]
    set(value) {
        this["data-badge-caption"] = value ?: ""
    }