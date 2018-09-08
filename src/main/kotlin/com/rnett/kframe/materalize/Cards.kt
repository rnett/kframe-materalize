package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.div
import com.rnett.kframe.elements.span
import com.rnett.kframe.elements.text

@KFrameElementDSL
fun DisplayElement<*>.contentCard(cardKlass: String = "", contentKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card $cardKlass").div("card-content $contentKlass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.card(sticky: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card${if (sticky) " sticky-action" else ""} $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.card(size: String, sticky: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card $size${if (sticky) " sticky-action" else ""} $klass", builder = builder, attrs = *attrs)

fun <T : Element<*>> T.stickyAction(): T {
    this addClass "sticky-action"
    return this
}

infix fun <T : Element<*>> T.size(size: String): T {
    this addClass "size"
    return this
}

@KFrameElementDSL
fun DisplayElement<*>.cardContent(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-content $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.cardAction(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-action $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.cardImage(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-image $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.cardStacked(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-stacked $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.cardReveal(title: String, titleKlass: String = "", cardKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}): StandardDisplayElement {
    val d = div("card-reveal $cardKlass", builder = builder, attrs = *attrs)
    d.span(titleKlass).text(title)
    return d
}

@KFrameElementDSL
fun DisplayElement<*>.cardReveal(titleBuilder: StandardDisplayBuilder, titleKlass: String = "", cardKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}): StandardDisplayElement {
    val d = div("card-reveal $cardKlass", builder = builder, attrs = *attrs)
    d.span(titleKlass, builder = titleBuilder)
    return d
}

@KFrameElementDSL
fun DisplayElement<*>.cardTabs(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-tabs $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.cardPanel(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("card-panel $klass", builder = builder, attrs = *attrs)