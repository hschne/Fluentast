package at.hschroedl.fluentast.demo;

import org.eclipse.jdt.core.dom.ASTNode;

import static at.hschroedl.fluentast.ast.expression.MethodInvocationKt.invocation;
import static at.hschroedl.fluentast.ast.expression.ThisExpressionKt.thiss;
import static at.hschroedl.fluentast.ast.expression.VariableDeclarationExpressionKt.var;
import static at.hschroedl.fluentast.ast.statement.BlockKt.block;
import static at.hschroedl.fluentast.ast.statement.ExpressionStatementKt.stmnt;
import static at.hschroedl.fluentast.ast.statement.StatementKt.ret;
import static at.hschroedl.fluentast.ast.statement.StatementKt.stmnt;

// TODO: Simplify import statements

/**
 * This class' main method creates the code for the Quicksort Algorithm.
 *
 * @see <a href="https://www.programcreek.com/2012/11/quicksort-array-in-java/">Programcreek Quicksort</a>
 */
public class Quicksort {

    public static void main(String[] args) {
        ASTNode node = block(stmnt("int i = 3;"),
                stmnt("List<String> myStrings = new ArrayList<>();"),
                stmnt(var("Integer", "iins")),
                block(stmnt(var("myInt", 3)),
                        stmnt(var("myBool", false)),
                        stmnt(var("Integer", "mydudu", thiss())),
                        ret(invocation("myTMethod")))).build();
    }
}
