package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.dom.classes.*
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL
import java.lang.Math.abs

@KFrameElementDSL
fun Head.materalize() {
    externalStylesheet("/css/materialize.min.css", attrs = *arrayOf("media" to "screen,projection"))
    scriptFrom("/js/materialize.min.js")
}

@KFrameElementDSL
fun AnyDisplayElement.valAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("valign-wrapper $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.centerAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("center-align $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.middleAlign(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("center-align valign-wrapper $klass", builder = builder, attrs = *attrs)

fun <T : AnyElement> T.valAlignThis(): T {
    this addClass "valign-wrapper"
    return this
}

fun <T : AnyElement> T.leftAlign(): T {
    this addClass "left-align"
    return this
}

fun <T : AnyElement> T.centerAlignThis(): T {
    this addClass "center-align"
    return this
}

fun <T : AnyElement> T.middleAlignThis(): T {
    this addClass "center-align"
    this addClass "valign-wrapper"
    return this
}

fun <T : AnyElement> T.rightAlign(): T {
    this addClass "right-align"
    return this
}


fun <T : AnyElement> T.left(): T {
    this addClass "left"
    return this
}

fun <T : AnyElement> T.center(): T {
    this addClass "center"
    return this
}

fun <T : AnyElement> T.right(): T {
    this addClass "right"
    return this
}

fun <T : AnyElement> T.pulse(): T {
    this addClass "pulse"
    return this
}

infix fun <T : AnyElement> T.zDepth(depth: Int): T {
    this addClass "z-depth-$depth"
    return this
}

fun <T : AnyElement> T.color(color: String, lighten: Int = 0): T {
    this addClass color
    if (lighten > 0)
        this addClass "lighten-$lighten"
    else if (lighten < 0)
        this addClass "darken-${abs(lighten)}"
    return this
}

fun <T : AnyElement> T.textColor(color: String, lighten: Int = 0): T {
    this addClass "$color-text"
    if (lighten > 0)
        this addClass "text-lighten-$lighten"
    else if (lighten < 0)
        this addClass "text-darken-${abs(lighten)}"
    return this
}

fun <T : AnyElement> T.active(): T {
    this addClass "active"
    return this
}

fun <T : AnyElement> T.inactive(): T {
    this.classes.remove("active")
    return this
}

infix fun <T : AnyElement> T.activate(active: Boolean): T {
    return if (active) active() else inactive()
}

@KFrameElementDSL
fun AnyDisplayElement.responsiveImage(src: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ImageElement> = {}) =
        img(src, klass = "responsive-img $klass", builder = builder, attrs = *attrs)

fun <T : AnyElement> T.circle(): T {
    this addClass "circle"
    return this
}

@KFrameElementDSL
fun AnyDisplayElement.breadcrumb(href: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "breadcrumb $klass", builder = builder, attrs = *attrs)

infix fun <T : AnyElement> T.waves(color: String): T {
    this addClass "waves-effect"
    if (color.isNotBlank())
        this addClass "waves-$color"
    return this
}

infix fun <T : AnyElement> T.wavesCircle(color: String): T {
    this addClass "waves-effect waves-circle "
    if (color.isNotBlank())
        this addClass "waves-$color"
    return this
}

fun <T : AnyElement> T.wavesLight() = this.waves("light")

@KFrameElementDSL
fun AnyDisplayElement.inputField(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("input-field $klass", builder = builder, attrs = *attrs)

fun <T : AnyElement> T.inputFieldThis(): T {
    this addClass "input-field"
    return this
}

fun <T : AnyElement> T.hoverable(): T {
    this addClass "hoverable"
    return this
}
