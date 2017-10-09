package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentMemberValuePair
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.NormalAnnotation

abstract class FluentAnnotation internal constructor(): FluentExpression()


class FluentNormalAnnotation internal constructor(private val name: String,
                             private vararg val members: FluentMemberValuePair) : FluentAnnotation() {

    override fun build(ast: AST): NormalAnnotation {
        val annotation = ast.newNormalAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        annotation.values().addAll(members.map { it.build(ast) })
        return annotation
    }
}

