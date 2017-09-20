package at.hschroedl.fluentast.demo;

import org.eclipse.jdt.core.dom.*;

import static at.hschroedl.fluentast.FluentastKt.*;


// TODO: Simplify import statements

/**
 * This class' main method creates the code for the Quicksort Algorithm.
 *
 * @see <a href="https://www.programcreek.com/2012/11/quicksort-array-in-java/">Programcreek Quicksort</a>
 */
public class Quicksort {

    public static void main(String[] args) {
        System.out.println(quickSortJDT());

    }

    static String quickSortFluentast() {
        block();
        return "";
    }


    static void quickSortOriginal(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;

        if (low >= high) return;

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

        if (low < j)
            quickSortOriginal(arr, low, j);

        if (high > i)
            quickSortOriginal(arr, i, high);
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

        condition.setOperator(InfixExpression.Operator.OR);

        InfixExpression rightSide = ast.newInfixExpression();
        FieldAccess fieldAccess = ast.newFieldAccess();
        fieldAccess.setExpression(ast.newSimpleName("arr"));
        fieldAccess.setName(ast.newSimpleName("length"));
        rightSide.setOperator(InfixExpression.Operator.EQUALS);
        rightSide.setLeftOperand(fieldAccess);
        rightSide.setRightOperand(ast.newNumberLiteral("0"));

        condition.setRightOperand(rightSide);

        ifStatement.setExpression(condition);
        ifStatement.setThenStatement(ast.newReturnStatement());

        body.statements().add(ifStatement);
        return body.toString();
    }
}
