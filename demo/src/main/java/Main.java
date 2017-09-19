import org.eclipse.jdt.core.dom.ASTNode;


// TODO: Simplify import statements
import static at.hschroedl.fluentast.ast.expression.MethodInvocationKt.invocation;
import static at.hschroedl.fluentast.ast.expression.ThisExpressionKt.thiss;
import static at.hschroedl.fluentast.ast.expression.VariableDeclarationKt.var;
import static at.hschroedl.fluentast.ast.statement.BlockKt.block;
import static at.hschroedl.fluentast.ast.statement.StatementKt.ret;
import static at.hschroedl.fluentast.ast.statement.StatementKt.stmnt;

public class Main {

    public static void main(String[] args) {
        ASTNode node = block(stmnt("int i = 3;"),
                stmnt("List<String> myStrings = new ArrayList<>();"),
                var("Integer", "iins"),
                block(var("myInt", 3),
                        var("myBool", false),
                        var("Integer", "mydudu", thiss()),
                        ret(invocation("myTMethod")))).build();

        try {
            System.out.println(node.toString());
        } catch (final ExceptionInInitializerError e) {

        }
        int[] a = new int[5];

        int[][] aasd = new int[][]{{1, 2, 3}};


    }
}
