package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL


@KFrameElementDSL
fun Element.blockquote(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        Element(this, builder, "blockquote", klass, *attrs)


fun <T : Element> T.flowText(): T {
    this addClass "flow-text"
    return this
}