package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayInitializer

class FluentArrayInitializer internal constructor(
        private vararg val expressions: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ArrayInitializer {
        val exp = ast.newArrayInitializer()
        expressions
                .map { it.build(ast) }
                .forEach { exp.expressions().add(it) }
        return exp
    }
}

