package at.hschroedl.fluentast.demo;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

import static at.hschroedl.fluentast.FluentastKt.if_;
import static at.hschroedl.fluentast.FluentastKt.name;
import static at.hschroedl.fluentast.FluentastKt.stmnt;


// TODO: Add samples for all kinda statements
public class Statements {


  /**
   * Produces the following with JDT and Fluentast
   *
   * if (expression) thenStatement; else elseStatement;
   */
  class If {

    public void ifWithJDT() {
      AST ast = AST.newAST(AST.JLS8);
      Expression expression = ast.newSimpleName("expression");
      Statement thenStatement = ast.newExpressionStatement(ast.newSimpleName("thenStatement"));
      Statement elseStatement = ast.newExpressionStatement(ast.newSimpleName("elseStatement"));
      IfStatement ifStatement = ast.newIfStatement();
      ifStatement.setExpression(expression);
      ifStatement.setThenStatement(thenStatement);
      ifStatement.setElseStatement(elseStatement);
    }

    public void ifWithFluentast() {
      if_(name("expression"))
          .then(stmnt(name("thenStatement")))
          .else_(stmnt(name("elseStatement")))
          .build();
    }

  }


}
