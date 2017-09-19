import org.eclipse.jdt.core.dom.ASTNode;


// TODO: Simplify import statements
import static at.hschroedl.fluentast.ast.expression.MethodInvocationKt.invocation;
import static at.hschroedl.fluentast.ast.expression.ThisExpressionKt.thiss;
import static at.hschroedl.fluentast.ast.expression.VariableDeclarationExpressionKt.var;
import static at.hschroedl.fluentast.ast.expression.VariableDeclarationExpressionKt.vars;
import static at.hschroedl.fluentast.ast.statement.BlockKt.block;
import static at.hschroedl.fluentast.ast.statement.StatementKt.ret;
import static at.hschroedl.fluentast.ast.statement.StatementKt.stmnt;
import static at.hschroedl.fluentast.ast.statement.ExpressionStatementKt.stmnt;

public class Main {

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
