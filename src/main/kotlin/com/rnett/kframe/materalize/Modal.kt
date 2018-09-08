package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.A
import com.rnett.kframe.elements.div

class Modal internal constructor(parent: Element<*>??, klass: String, builder: ElementBuilder<Modal>, vararg attrs: Pair<String, Any>)
    : DisplayElement<Modal>(parent, builder, "div", "modal $klass", *attrs) {

    init {
        id = "modal${nextId()}"
        this runJS "window.setTimeout(function(){ \$('.modal').modal(); }, 200);"
        this runJS "\$(document).ready(function(){ \$('.modal').modal(); });"
    }

    fun open() {

        this runJS "\$('#$id').modal('open');"
    }

    fun close() {

        this runJS "\$('#$id').modal('close');"
    }

    fun nextId() = page.elements.values.filter { it is Modal }.count()

    @KFrameElementDSL
    fun closeThisModalBtn(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
            btn("modal-close $klass", "#!", builder = builder, attrs = *attrs)

    @KFrameElementDSL
    fun closeThisModalBtn(size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
            btn(size, "modal-close $klass", "#!", builder = builder, attrs = *attrs)

    @KFrameElementDSL
    fun closeThisModalFlatBtn(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
            flatBtn("modal-close $klass", "#!", builder = builder, attrs = *attrs)
}

@KFrameElementDSL
fun DisplayElement<*>.modal(fixedFooter: Boolean = false, bottomSheet: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Modal> = {}) =
        Modal(this, "$klass${if (fixedFooter) " modal-fixed-footer" else ""}${if (bottomSheet) " bottom-sheet" else ""}", builder, *attrs)

@KFrameElementDSL
fun Modal.content(klass: String = "", vararg attrs: Pair<String, Any>, builder: DisplayElementBuilder = {}) =
        div("modal-content $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Modal.footer(klass: String = "", vararg attrs: Pair<String, Any>, builder: DisplayElementBuilder = {}) =
        div("modal-footer $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.openModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn("modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.closeModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn("modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.openModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn(size, "modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.closeModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn(size, "modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.openModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        flatBtn("modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun DisplayElement<*>.closeModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        flatBtn("modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)