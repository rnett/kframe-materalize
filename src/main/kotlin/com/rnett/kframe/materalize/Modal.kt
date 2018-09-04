package com.rnett.kframe.materalize

import com.rnett.kframe.dom.*
import com.rnett.kframe.elements.div

class Modal internal constructor(parent: Element?, klass: String, builder: ElementTypeBuilder<Modal>, vararg attrs: Pair<String, Any>)
    : TypedElement<Modal>(parent, builder, "div", "modal $klass", *attrs) {

    private var script: Element? = null

    init {
        id = "modal$elementID"
        script { +"\$('.modal').modal();" }
    }

    fun open() {
        script?.delete(true)

        script = script { +"\$('#$id').modal('open');" }

        if (script != null)
            +script!!
    }

    fun close() {
        script?.delete(true)

        script = script { +"\$('#$id').modal('close');" }

        if (script != null)
            +script!!
    }
}

@KFrameElementDSL
fun Element.modal(fixedFooter: Boolean = false, bottomSheet: Boolean = false, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementTypeBuilder<Modal> = {}) =
        Modal(this, "$klass${if (fixedFooter) " modal-fixed-footer" else ""}${if (fixedFooter) " bottom-sheet" else ""}", builder, *attrs)

@KFrameElementDSL
fun Modal.content(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("modal-content $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Modal.footer(klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        div("modal-footer $klass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.openModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        btn("modal-trigger $klass", modal.id, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.closeModalBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        btn("modal-close $klass", modal.id, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.openModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        btn(size, "modal-trigger $klass", modal.id, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.closeModalBtn(modal: Modal, size: String, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        btn(size, "modal-close $klass", modal.id, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.openModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        flatBtn("modal-trigger $klass", modal.id, builder = builder, attrs = *attrs)

@KFrameElementDSL
fun Element.closeModalFlatBtn(modal: Modal, klass: String = "", vararg attrs: Pair<String, Any>, builder: ElementBuilder = {}) =
        flatBtn("modal-close $klass", modal.id, builder = builder, attrs = *attrs)