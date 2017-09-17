package at.hschroedl.fluentast;

import org.eclipse.jdt.core.dom.ASTNode;

import static at.hschroedl.fluentast.ast.BlockKt.block;
import static at.hschroedl.fluentast.ast.expression.ExpressionKt.exp;
import static at.hschroedl.fluentast.ast.StatementKt.s;
import static at.hschroedl.fluentast.ast.VariableDeclarationKt.var;

public class asdf {

    public static void main(String[] args) {
        ASTNode node = block(s("int i = 3;"),
                s("List<String> myStrings = new ArrayList<>();"),
                var("Integer", "iins"),
                block(var("myInt", 3),
                        var("myBool", false),
                        var("Integer", "mydudu", exp()))).build();

        System.out.println(node.toString());
    }
}
