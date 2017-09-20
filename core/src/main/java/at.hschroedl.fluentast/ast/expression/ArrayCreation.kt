package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentArrayType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayCreation

class FluentArrayCreation internal constructor(private val type: FluentArrayType,
                                               private val initializer: FluentArrayInitializer?) : FluentExpression() {
    override fun build(ast: AST): ArrayCreation {
        val exp = ast.newArrayCreation()
        exp.type = type.build(ast)
        exp.initializer = initializer?.build(ast)
        return exp
    }

}
