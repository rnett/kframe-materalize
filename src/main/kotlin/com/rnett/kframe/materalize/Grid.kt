package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.div

@KFrameElementDSL
fun Element.row(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("row $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.col(s: Int, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("col s$s $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.col(s: Int, m: Int = 0, l: Int = 0, xl: Int = 0, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("col s$s${if (m != 0) " m$m" else ""}${if (l != 0) " l$l" else ""}${if (xl != 0) " xl$xl" else ""} $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.col(size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("col $size $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.divider(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("divider $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.section(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("section $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.container(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("container $klass", builder = builder, attrs = *attrs)

fun <T : Element> T.offset(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): T {
    if (s != 0)
        this addClass "offset-s$s"
    if (m != 0)
        this addClass "offset-m$m"
    if (l != 0)
        this addClass "offset-l$l"
    if (xl != 0)
        this addClass "offset-xl$xl"
    return this
}

fun <T : Element> T.push(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): T {
    if (s != 0)
        this addClass "push-s$s"
    if (m != 0)
        this addClass "push-m$m"
    if (l != 0)
        this addClass "push-l$l"
    if (xl != 0)
        this addClass "push-xl$xl"
    return this
}

fun <T : Element> T.pull(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): T {
    if (s != 0)
        this addClass "pull-s$s"
    if (m != 0)
        this addClass "pull-m$m"
    if (l != 0)
        this addClass "pull-l$l"
    if (xl != 0)
        this addClass "pull-xl$xl"
    return this
}

infix fun <T : Element> T.offset(size: String): T {
    this addClass "offset-$size"
    return this
}

infix fun <T : Element> T.push(size: String): T {
    this addClass "push-$size"
    return this
}

infix fun <T : Element> T.pull(size: String): T {
    this addClass "pull-$size"
    return this
}