package at.hschroedl.fluentast;

import org.eclipse.jdt.core.dom.ASTNode;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

import static at.hschroedl.fluentast.ast.BlockKt.block;
import static at.hschroedl.fluentast.ast.expression.ExpressionKt.exp;
import static at.hschroedl.fluentast.ast.StatementKt.s;
import static at.hschroedl.fluentast.ast.expression.VariableDeclarationKt.var;

public class asdf {

    public static void main(String[] args) {
        ASTNode node = block(s("int i = 3;"),
                s("List<String> myStrings = new ArrayList<>();"),
                var("Integer", "iins"),
                block(var("myInt", 3),
                        var("myBool", false),
                        var("Integer", "mydudu", exp()))).build();

        try {
            System.out.println(node.toString());
        }
        catch(final ExceptionInInitializerError e){

        }
        int[] a = new int[5];

        int[][] aasd = new int[][] {{1,2,3}};
    }
}
