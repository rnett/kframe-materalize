package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.dom.classes.A
import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL

@KFrameElementDSL
fun AnyDisplayElement.btn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.btn(size: String, href: String = "", klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn-$size $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.flatBtn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn-flat $klass", builder = builder, attrs = *attrs)


fun <T : AnyElement> T.btnThis(): T {
    this addClass "btn"
    return this
}

fun <T : AnyElement> T.flatBtnThis(): T {
    this addClass "btn-flat"
    return this
}

infix fun <T : AnyElement> T.btnThis(value: String): T {
    this addClass "btn-$value"
    return this
}

fun <T : AnyElement> T.disabled(): T {
    this addClass "disabled"
    return this
}

@KFrameElementDSL
fun AnyDisplayElement.floatingActionButton(buttonBuilder: ElementBuilder<A>, direction: String = "", size: String = "large", clickOnly: Boolean = false, klass: String = "", buttonKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        div("fixed-action-btn $klass${if (direction.isNotBlank()) " direction-$direction" else ""}${if (clickOnly) " click-to-toggle" else ""}", *attrs) {
            a("", "btn-floating btn-$size $buttonKlass", builder = buttonBuilder)
            ul(builder = builder)
        }

@KFrameElementDSL
fun ListElement.fabSubButton(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        li { a("", "fabSubButton $klass", builder = builder, attrs = *attrs) }