package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.dom.Style
import com.rnett.kframe.elements.externalStylesheet
import com.rnett.kframe.elements.i
import com.rnett.kframe.elements.text

@KFrameElementDSL
fun Element.icon(icon: String, klass: String = "", vararg attrs: Pair<String, Any>): Element {

    if (page.head.children.none { it.tag == "link" && it.attributes["href"] == "https://fonts.googleapis.com/icon?family=Material+Icons" })
        page.head.externalStylesheet("https://fonts.googleapis.com/icon?family=Material+Icons")

    val i = i("material-icons $klass", builder = {}, attrs = *attrs)
    i.text(icon)
    return i
}

@KFrameElementDSL
fun Element.icon(icon: String, size: String, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = "$size $klass", attrs = *attrs)

@KFrameElementDSL
fun Element.fontSizedIcon(icon: String, fontSize: String, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = klass, attrs = *arrayOf(*attrs, "style" to Style("font-size" to fontSize)))

@KFrameElementDSL
fun Element.fontSizedIcon(icon: String, fontSize: Int, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = klass, attrs = *arrayOf(*attrs, "style" to Style("font-size" to "${fontSize}px")))