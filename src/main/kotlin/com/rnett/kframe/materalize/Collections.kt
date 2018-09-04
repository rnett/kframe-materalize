package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.ElementTypeBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.ListElement
import com.rnett.kframe.elements.li
import com.rnett.kframe.elements.ul

@KFrameElementDSL
fun Element.collection(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        ul("collection $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.collectionHeadered(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        ul("collection with-header $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItem(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        li("collection-item $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItemAvatar(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        li("collection-item avatar $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItemActive(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        li("collection-item $klass", builder = builder, attrs = *attrs).active()

fun <T : Element> T.secondaryContent(): T {
    this addClass "secondary-content"
    return this
}

fun <T : Element> T.avatar(): T {
    this addClass "avatar"
    return this
}
