package at.hschroedl.fluentast.demo;

import at.hschroedl.fluentast.ast.expression.FluentVariableDeclarationExpression;
import at.hschroedl.fluentast.ast.statement.FluentIfStatement;
import at.hschroedl.fluentast.demo.quicksort.QuicksortWithJDT;

import static at.hschroedl.fluentast.FluentastKt.block;
import static at.hschroedl.fluentast.FluentastKt.body;
import static at.hschroedl.fluentast.FluentastKt.i;
import static at.hschroedl.fluentast.FluentastKt.if_;
import static at.hschroedl.fluentast.FluentastKt.infix;
import static at.hschroedl.fluentast.FluentastKt.nullz;
import static at.hschroedl.fluentast.FluentastKt.return_;
import static at.hschroedl.fluentast.FluentastKt.v;
import static java.lang.System.out;

/**
 * This class' main method creates the code for the Quicksort Algorithm.
 *
 * @see <a href="https://www.programcreek.com/2012/11/quicksort-array-in-java/">Programcreek
 * Quicksort</a>
 */
public class Quicksort {

  public static void main(String[] args) {
    out.println(QuicksortWithJDT.quickSortJDT());
    out.println(quickSortFluentast());
  }

  static String quickSortFluentast() {

    FluentIfStatement firstIf;
    firstIf = if_(infix("||")
                      .left(infix("==")
                                .left(v("arr"))
                                .right(nullz()))
                      .right(infix("==")
                                 .left(v("arr").field("length"))
                                 .right(i(0)))).then(block(return_()));

    FluentIfStatement secondIf = if_(infix(">=")
                                         .left(v("arr"))
                                         .right(v("high"))).then(block(return_()));

    FluentVariableDeclarationExpression variableDeclarationExpression = v()

    //    int middle = low + (high - low) / 2;
//    int pivot = arr[middle];
//    int i = low, j = high;

    return body(firstIf,
                secondIf)
        .build()
        .toString();


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
