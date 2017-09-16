package at.hschroedl.fluentast.test

import org.eclipse.jdt.core.dom.ASTNode

fun ASTNode.toInlineString(): String = this.toString().replace("\n\\s*".toRegex(), "")