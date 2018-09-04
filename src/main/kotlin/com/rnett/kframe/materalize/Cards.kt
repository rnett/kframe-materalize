package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.div
import com.rnett.kframe.elements.span
import com.rnett.kframe.elements.text

@KFrameElementDSL
fun Element.contentCard(cardKlass: String = "", contentKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card $cardKlass").div("card-content $contentKlass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.card(sticky: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card${if (sticky) " sticky-action" else ""} $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.card(size: String, sticky: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card $size${if (sticky) " sticky-action" else ""} $klass", builder = builder, attrs = *attrs)

fun <T : Element> T.stickyAction(): T {
    this addClass "sticky-action"
    return this
}

infix fun <T : Element> T.size(size: String): T {
    this addClass "size"
    return this
}

@KFrameElementDSL
fun Element.cardContent(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-content $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.cardAction(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-action $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.cardImage(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-image $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.cardStacked(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-stacked $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.cardReveal(title: String, titleKlass: String = "", cardKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}): Element {
    val d = div("card-reveal $cardKlass", builder = builder, attrs = *attrs)
    d.span(titleKlass).text(title)
    return d
}

@KFrameElementDSL
fun Element.cardReveal(titleBuilder: ElementBuilder, titleKlass: String = "", cardKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}): Element {
    val d = div("card-reveal $cardKlass", builder = builder, attrs = *attrs)
    d.span(titleKlass, builder = titleBuilder)
    return d
}

@KFrameElementDSL
fun Element.cardTabs(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-tabs $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.cardPanel(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("card-panel $klass", builder = builder, attrs = *attrs)