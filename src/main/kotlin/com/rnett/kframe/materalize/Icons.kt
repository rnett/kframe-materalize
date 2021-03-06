package com.rnett.kframe.materalize

import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayElement
import com.rnett.kframe.dom.externalStylesheet
import com.rnett.kframe.dom.i
import com.rnett.kframe.dom.text
import com.rnett.kframe.element.KFrameElementDSL
import com.rnett.kframe.element.Style
import com.rnett.kframe.element.cssStyle
import com.rnett.kframe.element.px

@KFrameElementDSL
fun AnyDisplayElement.icon(icon: String, klass: String = "", vararg attrs: Pair<String, Any>): StandardDisplayElement {

    if (page.head.children.none { it.tag == "link" && it.attributes["href"] == "https://fonts.googleapis.com/icon?family=Material+Icons" })
        page.head.externalStylesheet("https://fonts.googleapis.com/icon?family=Material+Icons")

    val i = i("material-icons $klass", builder = {}, attrs = *attrs)
    i.text(icon)
    return i
}

@KFrameElementDSL
fun AnyDisplayElement.icon(icon: String, size: String, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = "$size $klass", attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.fontSizedIcon(icon: String, fontSize: String, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = klass, attrs = *arrayOf(*attrs, "style" to Style("font-size" to fontSize.cssStyle)))

@KFrameElementDSL
fun AnyDisplayElement.fontSizedIcon(icon: String, fontSize: Int, klass: String = "", vararg attrs: Pair<String, Any>) =
        icon(icon = icon, klass = klass, attrs = *arrayOf(*attrs, "style" to Style("font-size" to fontSize.px)))