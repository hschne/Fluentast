package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.MethodInvocation

class FluentMethodInvocation internal constructor(private val expression: FluentExpression? = null,
                             private val typeParameter: List<FluentType>? = null,
                             private val name: String,
                             private vararg val arguments: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): MethodInvocation {
        val exp = ast.newMethodInvocation()
        exp.expression = expression?.build(ast)
        if (typeParameter != null) {
            exp.typeArguments().addAll(typeParameter.map { it.build(ast) })
        }
        exp.name = ast.newSimpleName(name)
        if (!arguments.isEmpty()) {
            exp.arguments().addAll(arguments.map { it.build(ast) })
        }
        return exp
    }
}

