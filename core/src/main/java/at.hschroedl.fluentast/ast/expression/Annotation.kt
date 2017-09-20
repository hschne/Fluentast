package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentMemberValuePair
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.MarkerAnnotation
import org.eclipse.jdt.core.dom.NormalAnnotation
import org.eclipse.jdt.core.dom.SingleMemberAnnotation

abstract class FluentAnnotation : FluentExpression()


class FluentMarkerAnnotation(private val name: String) : FluentAnnotation() {
    override fun build(ast: AST): MarkerAnnotation {
        val annotation = ast.newMarkerAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        return annotation
    }
}

class FluentSingleMemberAnnotation(private val name: String,
                                   private val expression: FluentExpression) : FluentAnnotation() {
    override fun build(ast: AST): SingleMemberAnnotation {
        val annotation = ast.newSingleMemberAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        annotation.value = expression.build(ast)
        return annotation
    }
}

class FluentNormalAnnotation(private val name: String,
                             private vararg val members: FluentMemberValuePair) : FluentAnnotation() {

    override fun build(ast: AST): NormalAnnotation {
        val annotation = ast.newNormalAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        annotation.values().addAll(members.map { it.build(ast) })
        return annotation
    }
}

