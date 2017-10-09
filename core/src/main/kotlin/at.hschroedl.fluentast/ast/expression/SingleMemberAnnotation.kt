package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.SingleMemberAnnotation

class FluentSingleMemberAnnotation internal constructor(private val name: String,
                                   private val expression: FluentExpression) : FluentAnnotation() {
    override fun build(ast: AST): SingleMemberAnnotation {
        val annotation = ast.newSingleMemberAnnotation()
        annotation.typeName = FluentName(name).build(ast)
        annotation.value = expression.build(ast)
        return annotation
    }
}