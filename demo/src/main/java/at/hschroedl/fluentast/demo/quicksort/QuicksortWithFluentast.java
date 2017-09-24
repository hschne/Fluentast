package at.hschroedl.fluentast.demo.quicksort;

import at.hschroedl.fluentast.ast.statement.FluentIfStatement;
import at.hschroedl.fluentast.ast.statement.FluentStatement;

import static at.hschroedl.fluentast.FluentastKt.block;
import static at.hschroedl.fluentast.FluentastKt.body;
import static at.hschroedl.fluentast.FluentastKt.decl;
import static at.hschroedl.fluentast.FluentastKt.fragment;
import static at.hschroedl.fluentast.FluentastKt.i;
import static at.hschroedl.fluentast.FluentastKt.if_;
import static at.hschroedl.fluentast.FluentastKt.infix;
import static at.hschroedl.fluentast.FluentastKt.n;
import static at.hschroedl.fluentast.FluentastKt.null_;
import static at.hschroedl.fluentast.FluentastKt.paranthesis;
import static at.hschroedl.fluentast.FluentastKt.return_;
import static at.hschroedl.fluentast.FluentastKt.stmnt;

/**
 * This class contains code creating the AST for the following Quicksort implementation and returns
 * it as a String. Fluentast is used in this case.
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
public class QuicksortWithFluentast {

  private QuicksortWithFluentast() {
  }

  public static String quickSortFluentast() {

    FluentIfStatement firstIf = if_(infix("||")
                                        .left(infix("==")
                                                  .left(n("arr"))
                                                  .right(null_()))
                                        .right(infix("==")
                                                   .left(n("arr").field("length"))
                                                   .right(i(0)))).then(block(return_()));

    FluentIfStatement secondIf = if_(infix(">=")
                                         .left(n("arr"))
                                         .right(n("high"))).then(block(return_()));

    FluentStatement middle = stmnt(decl("int",
                                        fragment("middle").init(infix("+")
                                                                    .left(n("low"))
                                                                    .right((infix("/")
                                                                        .left(paranthesis(infix("-")
                                                                                              .left(n("high"))
                                                                                              .right(n("low"))))
                                                                        .right(i(2)))))));

    FluentStatement pivot = stmnt(decl("int",
                                       fragment("pivot").init(n("arr").index(n("middle")))));

    FluentStatement indices = stmnt(decl("int",
                                         fragment("i").init(n("low")),
                                         fragment("j").init(n("high"))));

    return body(firstIf,
                secondIf,
                middle,
                pivot,
                indices)
        .build()
        .toString();


  }


}
