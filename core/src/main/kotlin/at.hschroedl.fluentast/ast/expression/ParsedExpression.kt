package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentParsedNode
import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.*

internal class FluentParsedExpression internal constructor(private val content: String) : FluentExpression() {

    override fun build(): Expression {
        val result = FluentParsedNode(content,
                                                                 ASTParser.K_EXPRESSION).build()
        if (result is CompilationUnit) {
            // If we get a compilation unit as result that means parsing failed
            val error = result.problems[0]
            throw FluentArgumentException(
                    "Failed to parse expression '$content'. $error")
        }
        return result as Expression
    }


    override fun build(ast: AST): Expression {
        return ASTNode.copySubtree(ast,
                                   build()) as Expression
    }
}