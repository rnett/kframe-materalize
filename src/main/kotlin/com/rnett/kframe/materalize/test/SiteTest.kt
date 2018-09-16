package com.rnett.kframe.materalize.test

import com.rnett.kframe.dom.*
import com.rnett.kframe.hosts.web.site
import com.rnett.kframe.materalize.*
import io.ktor.application.Application
import io.ktor.util.nonceRandom


class W(var dat: Int)

fun Application.siteTest() {
    site {
        val w = W(20)

        page("") {
            head {
                materalize()
            }
            body {
                container {
                    section {
                        btn { +"Server Event!" }.onClick {
                            println("Button Hit")
                            w.dat += 1
                        }
                    }
                    br()
                    section {
                        data(w::dat) {
                            val tabs = tabs(true)

                            tab(tabs, tabTitle = "Light Tab") {
                                valAlign {
                                    +"Lightweight tab"
                                }
                            }
                            tab(tabs, tabTitle = "Light Tab") {
                                div {
                                    var div = div()

                                    for (i in 1..w.dat)
                                        div = div.div()
                                }

                                table {
                                    thead {
                                        trListHeader(elements = listOf("thing1", "thing2", "thing3"))
                                    }
                                    tbody {
                                        style.overflowYRaw = "auto"
                                        for (i in 1..1000) {
                                            trList(elements = *arrayOf(nonceRandom.nextInt(), nonceRandom.nextInt(), nonceRandom.nextInt()).map { it.toString() }.toTypedArray())
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}