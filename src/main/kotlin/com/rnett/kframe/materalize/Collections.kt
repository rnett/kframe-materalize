package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.ListElement
import com.rnett.kframe.elements.li
import com.rnett.kframe.elements.ul

@KFrameElementDSL
fun AnyDisplayElement.collection(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        ul("collection $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.collectionHeadered(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        ul("collection with-header $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItem(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        li("collection-item $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItemAvatar(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        li("collection-item avatar $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun ListElement.collectionItemActive(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        li("collection-item $klass", builder = builder, attrs = *attrs).active()

fun <T : Element<*>> T.secondaryContent(): T {
    this addClass "secondary-content"
    return this
}

fun <T : Element<*>> T.avatar(): T {
    this addClass "avatar"
    return this
}
