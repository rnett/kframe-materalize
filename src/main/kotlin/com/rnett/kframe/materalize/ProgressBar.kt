package com.rnett.kframe.materalize

import com.rnett.kframe.dom.classes.AnyDisplayElement
import com.rnett.kframe.dom.classes.StandardDisplayBuilder
import com.rnett.kframe.dom.div
import com.rnett.kframe.dom.divs
import com.rnett.kframe.element.KFrameElementDSL

@KFrameElementDSL
fun AnyDisplayElement.progressBarStatic(progressPercent: Int, barKlass: String = "", backgroundKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("progress $backgroundKlass").div("determinate $barKlass", builder = builder, attrs = *attrs).invoke {
            style.width = "$progressPercent%"
        }

@KFrameElementDSL
fun AnyDisplayElement.progressBar(barKlass: String = "", backgroundKlass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("progress $backgroundKlass").div("indeterminate $barKlass", builder = builder, attrs = *attrs)

@KFrameElementDSL
fun AnyDisplayElement.circleSpinner(color: String = "", size: String = "", klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("preloader-wrapper $klass${if (size.isNotBlank()) " $size" else ""}", builder = builder, attrs = *attrs).invoke {
            div("spinner-layer") {
                style["border-color"] = color
                divs("circle-clipper left", "circle")
                divs("gap-patch", "circle")
                divs("circle-clipper right", "circle")
            }
        }

@KFrameElementDSL
fun AnyDisplayElement.circleSpinnerMulticolor(color1: String = "", color2: String = "", color3: String = "", color4: String = "",
                                              size: String = "", klass: String = "", vararg attrs: Pair<String, Any>, builder: StandardDisplayBuilder = {}) =
        div("preloader-wrapper $klass${if (size.isNotBlank()) " $size" else ""}", builder = builder, attrs = *attrs).invoke {
            div("spinner-layer spinner-blue") {
                if (color1.isNotBlank())
                    style["border-color"] = color1

                divs("circle-clipper left", "circle")
                divs("gap-patch", "circle")
                divs("circle-clipper right", "circle")
            }
            div("spinner-layer spinner-red") {
                if (color2.isNotBlank())
                    style["border-color"] = color2

                divs("circle-clipper left", "circle")
                divs("gap-patch", "circle")
                divs("circle-clipper right", "circle")
            }
            div("spinner-layer spinner-yellow") {
                if (color3.isNotBlank())
                    style["border-color"] = color3

                divs("circle-clipper left", "circle")
                divs("gap-patch", "circle")
                divs("circle-clipper right", "circle")
            }
            div("spinner-layer spinner-green") {
                if (color4.isNotBlank())
                    style["border-color"] = color4

                divs("circle-clipper left", "circle")
                divs("gap-patch", "circle")
                divs("circle-clipper right", "circle")
            }
        }