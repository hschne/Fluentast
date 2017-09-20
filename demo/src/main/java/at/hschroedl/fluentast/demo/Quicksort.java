package at.hschroedl.fluentast.demo;

import static at.hschroedl.fluentast.FluentastKt.block;
import static at.hschroedl.fluentast.FluentastKt.fieldAccess;
import static at.hschroedl.fluentast.FluentastKt.i;
import static at.hschroedl.fluentast.FluentastKt.iff;
import static at.hschroedl.fluentast.FluentastKt.infix;
import static at.hschroedl.fluentast.FluentastKt.nullz;
import static at.hschroedl.fluentast.FluentastKt.ret;
import static at.hschroedl.fluentast.FluentastKt.var;
import static java.lang.System.out;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;

// TODO: Simplify import statements

/**
 * This class' main method creates the code for the Quicksort Algorithm.
 *
 * @see <a href="https://www.programcreek.com/2012/11/quicksort-array-in-java/">Programcreek
 * Quicksort</a>
 */
public class Quicksort {

  public static void main(String[] args) {
    out.println(quickSortJDT());
    out.println(quickSortFluentast());
  }

  //TODO: Rework infix, iff API to make it more fluent
  static String quickSortFluentast() {
    return block(iff(infix(infix(var("arr"),
                                 "==",
                                 nullz()),
                           "||",
                           infix(fieldAccess(var("arr"),
                                             "length"),
                                 "==",
                                 i(0))),
                     block(ret()))).build()
                                   .toString();
  }

  static String quickSortJDT() {
    AST ast = AST.newAST(AST.JLS8);
    Block body = ast.newBlock();

    IfStatement ifStatement = ast.newIfStatement();
    InfixExpression condition = ast.newInfixExpression();

    InfixExpression leftSide = ast.newInfixExpression();
    leftSide.setLeftOperand(ast.newSimpleName("arr"));
    leftSide.setOperator(InfixExpression.Operator.EQUALS);
    leftSide.setRightOperand(ast.newNullLiteral());
    condition.setLeftOperand(leftSide);

    condition.setOperator(InfixExpression.Operator.CONDITIONAL_OR);

    InfixExpression rightSide = ast.newInfixExpression();
    FieldAccess fieldAccess = ast.newFieldAccess();
    fieldAccess.setExpression(ast.newSimpleName("arr"));
    fieldAccess.setName(ast.newSimpleName("length"));
    rightSide.setOperator(InfixExpression.Operator.EQUALS);
    rightSide.setLeftOperand(fieldAccess);
    rightSide.setRightOperand(ast.newNumberLiteral("0"));

    condition.setRightOperand(rightSide);

    ifStatement.setExpression(condition);
    Block block = ast.newBlock();
    block.statements()
         .add(ast.newReturnStatement());
    ifStatement.setThenStatement(block);

    body.statements()
        .add(ifStatement);
    return body.toString();
  }

  static void quickSortOriginal(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0) {
      return;
    }

    if (low >= high) {
      return;
    }

    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (low < j) {
      quickSortOriginal(arr,
                        low,
                        j);
    }

    if (high > i) {
      quickSortOriginal(arr,
                        i,
                        high);
    }
  }


}
