package com.rnett.kframe.materalize

import com.rnett.kframe.dom.Element
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.ElementTypeBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.*

@KFrameElementDSL
fun Element.navbar(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        nav().div("nav-wrapper $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.navList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        ul(klass, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.rightNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        navList("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.leftNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<ListElement> = {}) =
        navList("left $klass", builder = builder, attrs = *attrs)


@KFrameElementDSL
fun Element.logo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        a("brand-logo $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.leftLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        logo("left $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.rightLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        logo("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.centeredLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        logo("center $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.extendedNav(contentBuilder: ElementBuilder = {}, wrapperKlass: String = "", contentKlass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        nav("nav-extended") {
            div("nav-wrapper $wrapperKlass", builder = builder, attrs = *attrs)
            div("nav-content $contentKlass", builder = builder)
        }
