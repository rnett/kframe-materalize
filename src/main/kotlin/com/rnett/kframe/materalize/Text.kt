package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*


@KFrameElementDSL
fun AnyDisplayElement.blockquote(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        StandardDisplayElement(this, builder, "blockquote", klass, *attrs)


fun <T : Element<*>> T.flowText(): T {
    this addClass "flow-text"
    return this
}