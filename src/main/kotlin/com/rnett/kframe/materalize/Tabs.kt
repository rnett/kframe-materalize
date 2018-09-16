package com.rnett.kframe.materalize

import com.rnett.kframe.dom.a
import com.rnett.kframe.dom.classes.A
import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.DisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayElement
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.Element
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL

class Tabs internal constructor(parent: AnyElement?, klass: String, vararg attrs: Pair<String, Any>)
    : Element<Tabs>(parent, {}, "ul", "tabs $klass", *attrs) {

    init {
        //this runJS "window.setTimeout(function(){ \$('.tabs').tabs(); }, 100);"
        //this runJS "\$(document).ready(function(){ \$('.tabs').tabs(); });"
        this runJS "\$('.tabs').tabs();console.log('done');"
    }

    private val tabs = mutableMapOf<String, Pair<Tab, StandardDisplayElement>>()

    fun addTab(tab: Tab, liKlass: String, disabled: Boolean, builder: ElementBuilder<A> = {}): StandardDisplayElement {
        val t = addTabElement(tab.id, liKlass, disabled, builder)
        tabs[tab.id] = Pair(tab, t)
        return t
    }

    private fun addTabElement(ref: String, liKlass: String, disabled: Boolean, builder: ElementBuilder<A> = {}): StandardDisplayElement {
        val e = StandardDisplayElement(this, {
            a("#$ref", builder = builder)
        }, "li", "tab $liKlass${if (disabled) " disabled" else ""}")
        +e
        return e
    }

    fun nextId(): Int = page.elements.values.filter { it is Tab }.count()

    fun select(tab: Tab): Tabs {
        return select(tab.id)
    }

    fun select(tabId: String): Tabs {
        tabs.values.forEach { it.second.children.first().classes.remove("active") }
        tabs[tabId]?.second?.children?.first()?.addClass("active")
        return this
    }
}

@KFrameElementDSL
fun AnyDisplayElement.tabs(fixedWidth: Boolean = true, klass: String = "", vararg attrs: Pair<String, Any>) =
        Tabs(this, "$klass${if (fixedWidth) " tabs-fixed-width" else ""}", *attrs)

class Tab internal constructor(parent: AnyElement?, val tabs: Tabs, klass: String,
                               liKlass: String, default: Boolean = false, disabled: Boolean, tabBuilder: ElementBuilder<A>,
                               builder: ElementBuilder<Tab>, vararg attrs: Pair<String, Any>)
    : DisplayElement<Tab>(parent, builder, "div", klass, *attrs) {

    val listElement: StandardDisplayElement

    init {
        id = "tab${tabs.nextId()}"
        listElement = tabs.addTab(this, liKlass, disabled, tabBuilder)
        if (default)
            tabs.select(this)
    }

    fun disable() {
        listElement addClass "disabled"
    }

    fun enable() {
        listElement.classes.remove("disabled")
    }

    infix fun enabled(enabled: Boolean) {
        when (enabled) {
            true -> enable()
            false -> disable()
        }
    }

    var enabled
        get() = !listElement.classes.contains("disabled")
        set(v) {
            this enabled v
        }

}

@KFrameElementDSL
fun AnyDisplayElement.tab(tabs: Tabs, klass: String = "", liKlass: String = "", tabBuilder: ElementBuilder<A> = {}, default: Boolean = false, disabled: Boolean = false, vararg attrs: Pair<String, Any>, builder: ElementBuilder<Tab> = {}) =
        Tab(this, tabs, klass, liKlass, default, disabled, tabBuilder, builder, *attrs)

@KFrameElementDSL
fun AnyDisplayElement.tab(tabs: Tabs, tabTitle: String, klass: String = "", liKlass: String = "", default: Boolean = false, disabled: Boolean = false, vararg attrs: Pair<String, Any>, builder: ElementBuilder<Tab> = {}) =
        Tab(this, tabs, klass, liKlass, default, disabled, { +tabTitle }, builder, *attrs)
