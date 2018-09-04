package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Attributes
import com.rnett.kframe.dom.Element


fun <T : Element> T.badge(): T {
    this addClass "badge"
    return this
}

infix fun <T : Element> T.badge(new: Boolean): T {
    this addClass "badge${if (new) " new" else ""}"
    return this
}


fun <T : Element> T.newBadge(): T {
    this addClass "new badge"
    return this
}

var Attributes.badgeCaption
    get() = this["data-badge-caption"]
    set(value) {
        this["data-badge-caption"] = value ?: ""
    }