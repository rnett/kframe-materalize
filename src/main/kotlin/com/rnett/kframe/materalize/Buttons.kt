package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.ElementTypeBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.ListElement
import com.rnett.kframe.elements.a
import com.rnett.kframe.elements.div
import com.rnett.kframe.elements.ul

@KFrameElementDSL
fun Element.btn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a(href, "btn $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.btn(size: String, href: String = "", klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a(href, "btn-$size $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.flatBtn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a(href, "btn-flat $klass", builder = builder, attrs = *attrs)


fun <T : Element> T.btn(): T {
    this addClass "btn"
    return this
}

fun <T : Element> T.flatBtn(): T {
    this addClass "btn-flat"
    return this
}

infix fun <T : Element> T.btn(value: String): T {
    this addClass "btn-$value"
    return this
}

fun <T : Element> T.disabled(): T {
    this addClass "disabled"
    return this
}

@KFrameElementDSL
fun Element.floatingActionButton(buttonBuilder: ElementBuilder, direction: String = "", size: String = "large", clickOnly: Boolean = false, klass: String = "", buttonKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        div("fixed-action-btn $klass${if (direction.isNotBlank()) " direction-$direction" else ""}${if (clickOnly) " click-to-toggle" else ""}", *attrs) {
            a("", "btn-floating btn-$size $buttonKlass", builder = buttonBuilder)
            ul(builder = builder)
        }

@KFrameElementDSL
fun ListElement.fabSubButton(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a("", "fabSubButton $klass", builder = builder, attrs = *attrs)