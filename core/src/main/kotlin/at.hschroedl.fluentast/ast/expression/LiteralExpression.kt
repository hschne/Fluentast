package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.NumberLiteral
import org.eclipse.jdt.core.dom.StringLiteral

/**
 * Base class for other literals. See [NumberLiteral],[StringLiteral],[BooleanLiteral]...
 */
abstract class FluentLiteral internal constructor() : FluentExpression()
