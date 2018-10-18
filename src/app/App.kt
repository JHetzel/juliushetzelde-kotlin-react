package app

import app.aboutme.aboutMe
import app.ui.navbar
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.router.dom.browserRouter
import react.router.dom.redirect
import react.router.dom.route
import kotlin.browser.window

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        browserRouter {
            div {

                redirectBase()

                route("/about") {
                    aboutMe()
                }
                navbar()
            }
        }
    }
}

fun RBuilder.redirectBase() {
    if(window.location.pathname === "/") {
        redirect(from = "/", to = "/about")
    }
}

fun RBuilder.app() = child(App::class) {}
