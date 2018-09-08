package com.rnett.kframe.materalize

import com.rnett.kframe.dom.DisplayElement
import com.rnett.kframe.dom.DisplayElementBuilder
import com.rnett.kframe.dom.ElementBuilder
import com.rnett.kframe.dom.KFrameElementDSL
import com.rnett.kframe.elements.*

@KFrameElementDSL
fun DisplayElement<*>.navbar(klass: String = "", vararg attrs: Pair<String, Any>, builder: DisplayElementBuilder = {}) =
        nav().div("nav-wrapper $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.navList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        ul(klass, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.rightNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        navList("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.leftNavList(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<ListElement> = {}) =
        navList("left $klass", builder = builder, attrs = *attrs)


@KFrameElementDSL
fun DisplayElement<*>.logo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        a("brand-logo $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.leftLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("left $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.rightLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("right $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.centeredLogo(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        logo("center $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.extendedNav(contentBuilder: DisplayElementBuilder = {}, wrapperKlass: String = "", contentKlass: String = "", vararg attrs: Pair<String, Any>, builder: DisplayElementBuilder = {}) =
        nav("nav-extended") {
            div("nav-wrapper $wrapperKlass", builder = builder, attrs = *attrs)
            div("nav-content $contentKlass", builder = contentBuilder)
        }
