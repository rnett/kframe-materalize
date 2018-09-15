package com.rnett.kframe.materalize

import com.rnett.kframe.dom.ListElement
import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayBuilder
import com.rnett.kframe.dom.li
import com.rnett.kframe.dom.ul
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL

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

fun <T : AnyElement> T.secondaryContent(): T {
    this addClass "secondary-content"
    return this
}

fun <T : AnyElement> T.avatar(): T {
    this addClass "avatar"
    return this
}
