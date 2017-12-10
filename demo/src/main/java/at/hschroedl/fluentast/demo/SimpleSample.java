package at.hschroedl.fluentast.demo;

import at.hschroedl.fluentast.ast.statement.FluentBlock;
import at.hschroedl.fluentast.ast.statement.FluentStatement;
import at.hschroedl.fluentast.ast.statement.FluentWhileStatement;
import at.hschroedl.fluentast.ast.type.FluentType;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import java.util.ArrayList;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

import static at.hschroedl.fluentast.FluentastKt.*;

/**
 * A simple example for demonstrating JDT vs. Fluentast.
 *
 * <pre><code>
 *
 * int i = 1;
 * while(true){
 *   System.out.println(i);
 *   if(i > 99){
 *     break;
 *   }
 *   i++;
 * }
 *
 * </code></pre>
 */
public class SimpleSample {

  public static void main(String[] args) {
    System.out.println(sampleWithJDT());
  }

  public static String sampleWithJDT() {
    AST ast = AST.newAST(AST.JLS8);
    Block block = ast.newBlock();
    VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
    fragment.setName(ast.newSimpleName("i"));
    fragment.setInitializer(ast.newNumberLiteral("1"));
    VariableDeclarationStatement statement = ast.newVariableDeclarationStatement(fragment);
    statement.setType(ast.newPrimitiveType(PrimitiveType.INT));

    block
        .statements()
        .add(statement);

    WhileStatement whileStatement = ast.newWhileStatement();
    whileStatement.setExpression(ast.newBooleanLiteral(true));

    Block whileBody = ast.newBlock();
    MethodInvocation methodInvocation = ast.newMethodInvocation();

    methodInvocation.setName(ast.newSimpleName("println"));
    methodInvocation.setExpression(ast.newName("System.out"));
    methodInvocation
        .arguments()
        .add(ast.newSimpleName("i"));
    whileBody
        .statements()
        .add(ast.newExpressionStatement(methodInvocation));

    IfStatement ifStatement = ast.newIfStatement();
    InfixExpression infixExpression = ast.newInfixExpression();
    infixExpression.setLeftOperand(ast.newSimpleName("i"));
    infixExpression.setOperator(Operator.GREATER);
    infixExpression.setRightOperand(ast.newNumberLiteral("99"));
    ifStatement.setExpression(infixExpression);
    ifStatement.setThenStatement(ast.newBreakStatement());
    whileBody
        .statements()
        .add(ifStatement);

    PostfixExpression postfixExpression = ast.newPostfixExpression();
    postfixExpression.setOperator(PostfixExpression.Operator.INCREMENT);
    postfixExpression.setOperand(ast.newSimpleName("i"));
    whileBody
        .statements()
        .add(ast.newExpressionStatement(postfixExpression));

    whileStatement.setBody(whileBody);

    block
        .statements()
        .add(whileStatement);

    return block.toString();
  }

  // TODO: Fix methodinvoation
  public void getSampleWithFluentast() {
    FluentStatement variableDeclaration = stmnt(decl("int",
                                                     1));

    FluentStatement methodInvocation = stmnt(invocation(name("System.out"),
                                                        new ArrayList<FluentType>(),
                                                        "println",
                                                        n("i")));

    FluentBlock whileBody = block(methodInvocation,
                                  if_(infix(">")
                                          .left(n("i"))
                                          .right(i(99))).then(break_()),
                                  stmnt(postfix("++").operand(n("i"))));
    block(variableDeclaration,
          while_(b(true))
              .do_(whileBody))
        .build();
  }
}
