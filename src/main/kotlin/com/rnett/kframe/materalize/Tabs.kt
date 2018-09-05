package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.a
import com.rnett.kframe.elements.script

class Tabs internal constructor(parent: Element?, klass: String, vararg attrs: Pair<String, Any>)
    : TypedElement<Tabs>(parent, {}, "ul", "tabs $klass", *attrs) {

    init {
        script { +"\$('.tabs').tabs();" }
    }

    private val tabs = mutableMapOf<String, Pair<Tab, Element>>()

    fun addTab(tab: Tab, liKlass: String, disabled: Boolean, builder: ElementBuilder = {}): Element {
        val t = addTabElement(tab.id, liKlass, disabled, builder)
        tabs[tab.id] = Pair(tab, t)
        return t
    }

    private fun addTabElement(ref: String, liKlass: String, disabled: Boolean, builder: ElementBuilder = {}): Element {
        val e = Element(this, {
            a("#$ref", builder = builder)
        }, "li", "tab $liKlass${if (disabled) " disabled" else ""}")
        +e
        return e
    }

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
fun Element.tabs(klass: String = "", vararg attrs: Pair<String, Any>) =
        Tabs(this, klass, *attrs)

class Tab internal constructor(parent: Element?, val tabs: Tabs, klass: String,
                               liKlass: String, default: Boolean = false, disabled: Boolean, tabBuilder: ElementBuilder,
                               builder: ElementTypeBuilder<Tab>, vararg attrs: Pair<String, Any>)
    : TypedElement<Tab>(parent, builder, "div", klass, *attrs) {

    val listElement: Element

    init {
        id = "tab$elementID"
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
fun Element.tab(tabs: Tabs, klass: String = "", liKlass: String = "", tabBuilder: ElementBuilder = {}, default: Boolean = false, disabled: Boolean = false, vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        Tab(this, tabs, klass, liKlass, default, disabled, tabBuilder, builder, *attrs)
