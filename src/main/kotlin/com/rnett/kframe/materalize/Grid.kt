package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.div

@KFrameElementDSL
class Row(parent: Element<*>?, builder: ElementBuilder<Row>, klass: String, vararg attrs: Pair<String, Any>)
    : DisplayElement<Row>(parent, builder, "div", "row $klass", *attrs)

@KFrameElementDSL
fun DisplayElement<*>.row(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Row> = {}) =
        Row(this, builder, klass, *attrs)


@KFrameElementDSL
class Col(parent: Element<*>?, builder: ElementBuilder<Col>, klass: String, vararg attrs: Pair<String, Any>)
    : DisplayElement<Col>(parent, builder, "div", "col $klass", *attrs)

@KFrameElementDSL
fun Row.col(s: Int, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Col> = {}) =
        Col(this, builder, "s$s $klass", *attrs)

@KFrameElementDSL
fun Row.col(s: Int, m: Int = 0, l: Int = 0, xl: Int = 0, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Col> = {}) =
        Col(this, builder, "s$s${if (m != 0) " m$m" else ""}${if (l != 0) " l$l" else ""}${if (xl != 0) " xl$xl" else ""} $klass", *attrs)

@KFrameElementDSL
fun Row.col(size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Col> = {}) =
        Col(this, builder, "$size $klass", *attrs)

@KFrameElementDSL
fun DisplayElement<*>.divider(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("divider $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.section(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("section $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.container(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("container $klass", builder = builder, attrs = *attrs)

fun Col.offset(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): Col {
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

fun Col.push(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): Col {
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

fun Col.pull(s: Int = 0, m: Int = 0, l: Int = 0, xl: Int = 0): Col {
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

infix fun Col.offset(size: String): Col {
    this addClass "offset-$size"
    return this
}

infix fun Col.push(size: String): Col {
    this addClass "push-$size"
    return this
}

infix fun Col.pull(size: String): Col {
    this addClass "pull-$size"
    return this
}