package app.ui.content

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class ContentComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        div(classes = "content") {
            props.children()
        }
    }
}

fun RBuilder.content(handler: react.RHandler<RProps>) = child(ContentComponent::class, handler)