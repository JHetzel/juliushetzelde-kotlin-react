package app.aboutme

import app.ui.content.content
import react.RBuilder
import react.dom.h1
import react.dom.img
import react.dom.section

@JsModule("src/app/aboutme/me.jpg")
external val imageMe: dynamic

fun RBuilder.aboutMe() = content {

    section(classes = "about-me") {
        img("me.image", imageMe, "image-me") {}
        h1 {
            + "Julius Hetzel"
        }
    }
}