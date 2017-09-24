package at.hschroedl.fluentast.demo.quicksort;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.jetbrains.annotations.NotNull;

import static org.eclipse.jdt.core.dom.PrimitiveType.INT;

/**
 * This class contains code creating the AST for the following Quicksort implementation and returns
 * it as a String. This goes to show that plain JDT is cumbersome.
 *
 * Original Code:
 * <pre>
 *   <code>
 *    if (arr == null || arr.length == 0) {
 *      return;
 *    }
 *
 *    if (low >= high) {
 *      return;
 *    }
 *
 *    int middle = low + (high - low) / 2;
 *    int pivot = arr[middle];
 *    int i = low, j = high;
 *
 *    while (i <= j) {
 *      while (arr[i] < pivot) {
 *        i++;
 *      }
 *
 *      while (arr[j] > pivot) {
 *        j--;
 *      }
 *
 *      if (i <= j) {
 *        int temp = arr[i];
 *        arr[i] = arr[j];
 *        arr[j] = temp;
 *        i++;
 *        j--;
 *      }
 *    }
 *
 *    if (low < j) {
 *      quickSortOriginal(arr,
 *                        low,
 *                        j);
 *    }
 *
 *    if (high > i) {
 *      quickSortOriginal(arr,
 *                        i,
 *                        high);
 *    }
 *  }
 *  </code>
 * </pre>
 */
public class QuicksortWithJDT {

  private QuicksortWithJDT() {
  }

  public static String quickSortJDT() {
    AST ast = org.eclipse.jdt.core.dom.AST.newAST(org.eclipse.jdt.core.dom.AST.JLS8);
    Block body = ast.newBlock();

    IfStatement firstIf = createFirstIf(ast);
    body
        .statements()
        .add(firstIf);

    IfStatement secondIf = createSecondIf(ast);
    body
        .statements()
        .add(secondIf);
    VariableDeclarationStatement middleDecl = middleDecl(ast);
    body
        .statements()
        .add(middleDecl);

    VariableDeclarationStatement pivotDecl = pivotDecl(ast);

    body
        .statements()
        .add(pivotDecl);

    VariableDeclarationStatement iDecl = iDecl(ast);

    body
        .statements()
        .add(iDecl);

    return body.toString();
  }

  @NotNull
  private static VariableDeclarationStatement iDecl(AST ast) {
    VariableDeclarationFragment firstFragment = ast.newVariableDeclarationFragment();
    firstFragment.setName(ast.newSimpleName("i"));
    firstFragment.setInitializer(ast.newSimpleName("low"));

    VariableDeclarationFragment secondFragment = ast.newVariableDeclarationFragment();
    secondFragment.setName(ast.newSimpleName("j"));
    secondFragment.setInitializer(ast.newSimpleName("high"));

    VariableDeclarationStatement iDecl = ast.newVariableDeclarationStatement(firstFragment);
    iDecl.setType(ast.newPrimitiveType(INT));
    iDecl
        .fragments()
        .add(secondFragment);
    return iDecl;
  }

  @NotNull
  private static VariableDeclarationStatement pivotDecl(AST ast) {
    VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
    fragment.setName(ast.newSimpleName("privot"));
    ArrayAccess arrayAccess = ast.newArrayAccess();
    arrayAccess.setIndex(ast.newSimpleName("middle"));
    arrayAccess.setArray(ast.newSimpleName("arr"));

    fragment.setInitializer(arrayAccess);

    VariableDeclarationStatement pivotDecl = ast.newVariableDeclarationStatement(fragment);
    pivotDecl.setType(ast.newPrimitiveType(INT));
    return pivotDecl;
  }

  @NotNull
  private static VariableDeclarationStatement middleDecl(AST ast) {
    VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
    fragment.setName(ast.newSimpleName("middle"));
    InfixExpression minusExpression = ast.newInfixExpression();
    minusExpression.setOperator(Operator.MINUS);
    minusExpression.setLeftOperand(ast.newSimpleName("high"));
    minusExpression.setRightOperand(ast.newSimpleName("low"));

    ParenthesizedExpression parenthesizedExpression = ast.newParenthesizedExpression();
    parenthesizedExpression.setExpression(minusExpression);

    InfixExpression divisionExpression = ast.newInfixExpression();
    divisionExpression.setOperator(Operator.DIVIDE);
    divisionExpression.setLeftOperand(parenthesizedExpression);
    divisionExpression.setRightOperand(ast.newNumberLiteral("2"));

    InfixExpression plusExpression = ast.newInfixExpression();
    plusExpression.setOperator(Operator.PLUS);
    plusExpression.setLeftOperand(ast.newSimpleName("low"));
    plusExpression.setRightOperand(divisionExpression);

    fragment.setInitializer(plusExpression);
    VariableDeclarationStatement varDecl = ast.newVariableDeclarationStatement(fragment);
    varDecl.setType(ast.newPrimitiveType(INT));
    return varDecl;
  }


  @NotNull
  private static IfStatement createFirstIf(AST ast) {
    IfStatement ifStatement = ast.newIfStatement();
    InfixExpression condition = ast.newInfixExpression();

    InfixExpression leftSide = ast.newInfixExpression();
    leftSide.setLeftOperand(ast.newSimpleName("arr"));
    leftSide.setOperator(Operator.EQUALS);
    leftSide.setRightOperand(ast.newNullLiteral());
    condition.setLeftOperand(leftSide);

    condition.setOperator(Operator.CONDITIONAL_OR);

    InfixExpression rightSide = ast.newInfixExpression();
    FieldAccess fieldAccess = ast.newFieldAccess();
    fieldAccess.setExpression(ast.newSimpleName("arr"));
    fieldAccess.setName(ast.newSimpleName("length"));
    rightSide.setOperator(Operator.EQUALS);
    rightSide.setLeftOperand(fieldAccess);
    rightSide.setRightOperand(ast.newNumberLiteral("0"));

    condition.setRightOperand(rightSide);

    ifStatement.setExpression(condition);
    Block block = ast.newBlock();
    block
        .statements()
        .add(ast.newReturnStatement());
    ifStatement.setThenStatement(block);
    return ifStatement;
  }

  @NotNull
  private static IfStatement createSecondIf(AST ast) {
    IfStatement secondIf = ast.newIfStatement();

    InfixExpression condition = ast.newInfixExpression();
    condition.setLeftOperand(ast.newSimpleName("low"));
    condition.setOperator(Operator.GREATER_EQUALS);
    condition.setRightOperand(ast.newSimpleName("high"));

    secondIf.setExpression(condition);
    Block block = ast.newBlock();
    block
        .statements()
        .add(ast.newReturnStatement());
    secondIf.setThenStatement(block);
    return secondIf;
  }


}
