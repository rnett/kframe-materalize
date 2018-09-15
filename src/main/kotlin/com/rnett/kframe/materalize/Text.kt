package com.rnett.kframe.materalize

import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayBuilder
import com.rnett.kframe.dom.classes.StandardDisplayElement
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.KFrameElementDSL


@KFrameElementDSL
fun AnyDisplayElement.blockquote(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        StandardDisplayElement(this, builder, "blockquote", klass, *attrs)


fun <T : AnyElement> T.flowText(): T {
    this addClass "flow-text"
    return this
}