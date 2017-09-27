package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.MarkerAnnotation

class FluentMarkerAnnotation(private val name: String) : FluentAnnotation() {
    override fun build(ast: AST): MarkerAnnotation {
        val annotation = ast.newMarkerAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        return annotation
    }
}