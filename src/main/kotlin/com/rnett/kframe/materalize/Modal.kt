package com.rnett.kframe.materalize

import com.rnett.kframe.dom.classes.A
import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.DisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayBuilder
import com.rnett.kframe.dom.div
import com.rnett.kframe.element.AnyElement
import com.rnett.kframe.element.ElementBuilder
import com.rnett.kframe.element.KFrameElementDSL

class Modal internal constructor(parent: AnyElement?, klass: String, builder: ElementBuilder<Modal>, vararg attrs: Pair<String, Any>)
    : DisplayElement<Modal>(parent, builder, "div", "modal $klass", *attrs) {

    init {
        id = "modal${nextId()}"
        this runJS "\$('.modal').modal();"
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
fun AnyDisplayElement.modal(fixedFooter: Boolean = false, bottomSheet: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<Modal> = {}) =
        Modal(this, "$klass${if (fixedFooter) " modal-fixed-footer" else ""}${if (bottomSheet) " bottom-sheet" else ""}", builder, *attrs)

@KFrameElementDSL
fun Modal.content(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("modal-content $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Modal.footer(klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("modal-footer $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.openModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn("modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.closeModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn("modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.openModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn(size, "modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.closeModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        btn(size, "modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.openModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        flatBtn("modal-trigger $klass", "#${modal.id}", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.closeModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder<A> = {}) =
        flatBtn("modal-close $klass", "#${modal.id}", builder = builder, attrs = *attrs)