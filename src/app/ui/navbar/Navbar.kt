package app.ui

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import react.router.dom.routeLink
import kotlin.browser.window

@JsModule("src/app/ui/navbar/menu-open.svg")
external val menuIconOpen: dynamic

@JsModule("src/app/ui/navbar/menu-close.svg")
external val menuIconClose: dynamic

class NavbarComponent : RComponent<NavbarComponent.Props, NavbarComponent.State>() {

    interface Props : RProps {}

    interface State : RState {
        var open: Boolean
    }

    override fun RBuilder.render() {
        nav {
            attrs {
                if(state.open) classes += "open" else classes -= "open"
            }
            ul {
                navItem("about me", "/about")
                navItem("projects", "/projects")
                navItem("contact", "/contact")
            }
        }

        div(classes = "nav-button-wrapper") {
            menuButton()
        }
    }

    private fun RBuilder.menuButton() = div(classes = "menu-button") {
        attrs {
            onClickFunction = { toggleNavbar() }
            if(state.open) classes += "open" else classes -= "open"
        }
        img(alt = "menu.icon", src = menuIconOpen, classes = "menu-icon menu-icon-open") {}

        img(alt = "menu.icon", src = menuIconClose, classes = "menu-icon menu-icon-close") {}
    }

    private fun toggleNavbar() {
        setState { open = state.open.not() }
    }

    private fun RBuilder.navItem(title: String, route: String) = li(
            classes = if(window.location.pathname == route) "active" else ""
    ) {
        routeLink(
                to = route
        ) {
            + title
        }
    }

}

fun RBuilder.navbar() = child(NavbarComponent::class) {}