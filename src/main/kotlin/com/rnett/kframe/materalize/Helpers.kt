package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.a
import com.rnett.kframe.elements.div
import com.rnett.kframe.elements.img
import java.lang.Math.abs

@KFrameElementDSL
fun Element.valAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("valign-wrapper $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.centerAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("center-align $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.middleAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("center-align valign-wrapper $klass", builder = builder, attrs = *attrs)

fun <T : Element> T.valAlignThis(): T {
    this addClass "valign-wrapper"
    return this
}

fun <T : Element> T.leftAlign(): T {
    this addClass "left-align"
    return this
}

fun <T : Element> T.centerAlignThis(): T {
    this addClass "center-align"
    return this
}

fun <T : Element> T.middleAlignThis(): T {
    this addClass "center-align"
    this addClass "valign-wrapper"
    return this
}

fun <T : Element> T.rightAlign(): T {
    this addClass "right-align"
    return this
}


fun <T : Element> T.left(): T {
    this addClass "left"
    return this
}

fun <T : Element> T.center(): T {
    this addClass "center"
    return this
}

fun <T : Element> T.right(): T {
    this addClass "right"
    return this
}

fun <T : Element> T.pulse(): T {
    this addClass "pulse"
    return this
}

infix fun <T : Element> T.zDepth(depth: Int): T {
    this addClass "z-depth-$depth"
    return this
}

fun <T : Element> T.color(color: String, lighten: Int = 0): T {
    this addClass color
    if (lighten > 0)
        this addClass "lighten-$lighten"
    else if (lighten < 0)
        this addClass "darken-${abs(lighten)}"
    return this
}

fun <T : Element> T.textColor(color: String, lighten: Int = 0): T {
    this addClass "$color-text"
    if (lighten > 0)
        this addClass "text-lighten-$lighten"
    else if (lighten < 0)
        this addClass "text-darken-${abs(lighten)}"
    return this
}

fun <T : Element> T.active(): T {
    this addClass "active"
    return this
}

fun <T : Element> T.inactive(): T {
    this.classes.remove("active")
    return this
}

infix fun <T : Element> T.activate(active: Boolean): T {
    return if (active) active() else inactive()
}

@KFrameElementDSL
fun Element.responsiveImage(src: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        img(src, klass = "responsive-img $klass", builder = builder, attrs = *attrs)

fun <T : Element> T.circle(): T {
    this addClass "circle"
    return this
}

@KFrameElementDSL
fun Element.breadcrumb(href: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a(href, "breadcrumb $klass", builder = builder, attrs = *attrs)

infix fun <T : Element> T.waves(color: String): T {
    this addClass "waves-effect"
    if (color.isNotBlank())
        this addClass "waves-$color"
    return this
}

infix fun <T : Element> T.wavesCircle(color: String): T {
    this addClass "waves-effect waves-circle "
    if (color.isNotBlank())
        this addClass "waves-$color"
    return this
}

fun <T : Element> T.wavesLight() = this.waves("light")

@KFrameElementDSL
fun Element.inputField(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("input-field $klass", builder = builder, attrs = *attrs)

fun <T : Element> T.inputFieldThis(): T {
    this addClass "input-field"
    return this
}

fun <T : Element> T.hoverable(): T {
    this addClass "hoverable"
    return this
}
