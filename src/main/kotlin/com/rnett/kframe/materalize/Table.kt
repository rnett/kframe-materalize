package com.rnett.kframe.materalize

import com.rnett.kframe.dom.classes.TableElement


fun TableElement.striped(): TableElement {
    this addClass "striped"
    return this
}


fun TableElement.highlight(): TableElement {
    this addClass "highlight"
    return this
}


fun TableElement.centered(): TableElement {
    this addClass "centered"
    return this
}


fun TableElement.responsive(): TableElement {
    this addClass "responsive"
    return this
}
