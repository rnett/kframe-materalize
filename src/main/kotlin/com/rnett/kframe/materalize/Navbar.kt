package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.dom.classes.A
import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayBuilder
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL

@KFrameElementDSL
fun AnyDisplayElement.navbar(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        nav().div("nav-wrapper $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.navList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        ul(klass, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.rightNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        navList("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.leftNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        navList("left $klass", builder = builder, attrs = *attrs)


@KFrameElementDSL
fun AnyDisplayElement.logo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a("brand-logo $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.leftLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("left $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.rightLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.centeredLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("center $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.extendedNav(contentBuilder: StandardDisplayBuilder = {}, wrapperKlass: String = "", contentKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        nav("nav-extended") {
            div("nav-wrapper $wrapperKlass", builder = builder, attrs = *attrs)
            div("nav-content $contentKlass", builder = contentBuilder)
        }
