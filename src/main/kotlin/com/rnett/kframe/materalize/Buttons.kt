package com.rnett.kframe.materalize

import com.rnett.kframe.dom.DisplayElement
import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.*

@KFrameElementDSL
fun DisplayElement<*>.btn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.btn(size: String, href: String = "", klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn-$size $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.flatBtn(klass: String = "", href: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a(href, "btn-flat $klass", builder = builder, attrs = *attrs)


fun <T : Element<*>> T.btnThis(): T {
    this addClass "btn"
    return this
}

fun <T : Element<*>> T.flatBtnThis(): T {
    this addClass "btn-flat"
    return this
}

infix fun <T : Element<*>> T.btnThis(value: String): T {
    this addClass "btn-$value"
    return this
}

fun <T : Element<*>> T.disabled(): T {
    this addClass "disabled"
    return this
}

@KFrameElementDSL
fun DisplayElement<*>.floatingActionButton(buttonBuilder: ElementBuilder<A>, direction: String = "", size: String = "large", clickOnly: Boolean = false, klass: String = "", buttonKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        div("fixed-action-btn $klass${if (direction.isNotBlank()) " direction-$direction" else ""}${if (clickOnly) " click-to-toggle" else ""}", *attrs) {
            a("", "btn-floating btn-$size $buttonKlass", builder = buttonBuilder)
            ul(builder = builder)
        }

@KFrameElementDSL
fun ListElement.fabSubButton(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        li { a("", "fabSubButton $klass", builder = builder, attrs = *attrs) }