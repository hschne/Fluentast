package at.hschroedl.fluentast.demo;

import static at.hschroedl.fluentast.FluentastKt.clazz;
import static at.hschroedl.fluentast.FluentastKt.n;
import static at.hschroedl.fluentast.FluentastKt.superMethod;
import static at.hschroedl.fluentast.FluentastKt.t;
import static at.hschroedl.fluentast.FluentastKt.this_;

import at.hschroedl.fluentast.ast.expression.FluentTypeLiteral;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.TypeLiteral;

public class Expressions {

  public static void main(String[] main){
    System.out.println(literals());
  }

  public static String literals(){
    AST ast = AST.newAST(AST.JLS9);
    SuperMethodInvocation methodInvocation = superMethod("myMethod").build(ast);
    return methodInvocation.toString();
  }

}
