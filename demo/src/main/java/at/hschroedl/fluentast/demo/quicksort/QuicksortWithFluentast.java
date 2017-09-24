package at.hschroedl.fluentast.demo.quicksort;

import at.hschroedl.fluentast.ast.statement.FluentIfStatement;
import at.hschroedl.fluentast.ast.statement.FluentStatement;
import at.hschroedl.fluentast.ast.statement.FluentWhileStatement;

import static at.hschroedl.fluentast.FluentastKt.block;
import static at.hschroedl.fluentast.FluentastKt.body;
import static at.hschroedl.fluentast.FluentastKt.decl;
import static at.hschroedl.fluentast.FluentastKt.fragment;
import static at.hschroedl.fluentast.FluentastKt.i;
import static at.hschroedl.fluentast.FluentastKt.if_;
import static at.hschroedl.fluentast.FluentastKt.infix;
import static at.hschroedl.fluentast.FluentastKt.n;
import static at.hschroedl.fluentast.FluentastKt.null_;
import static at.hschroedl.fluentast.FluentastKt.p;
import static at.hschroedl.fluentast.FluentastKt.paranthesis;
import static at.hschroedl.fluentast.FluentastKt.postfix;
import static at.hschroedl.fluentast.FluentastKt.return_;
import static at.hschroedl.fluentast.FluentastKt.stmnt;
import static at.hschroedl.fluentast.FluentastKt.while_;

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

    FluentStatement middle = stmnt(decl(p("int"),
                                        fragment("middle").init(infix("+")
                                                                    .left(n("low"))
                                                                    .right((infix("/")
                                                                        .left(paranthesis(infix("-")
                                                                                              .left(n("high"))
                                                                                              .right(n("low"))))
                                                                        .right(i(2)))))));

    FluentStatement pivot = stmnt(decl(p("int"),
                                       fragment("pivot").init(n("arr").index(n("middle")))));

    FluentStatement indices = stmnt(decl(p("int"),
                                         fragment("i").init(n("low")),
                                         fragment("j").init(n("high"))));

    // TODO: Adding expressions to body (as statments) should be simplified

    FluentWhileStatement firstNestedWhile = while_(infix("<")
                                                       .left(n("arr").index(n("i")))
                                                       .right(n("pivot"))).do_(body(stmnt(postfix("++").operand(n("i")))));

    FluentWhileStatement whileStatement = while_(infix("<=")
                                                     .left(n("i"))
                                                     .right(n("j"))).do_(body(firstNestedWhile));

    return body(firstIf,
                secondIf,
                middle,
                pivot,
                indices,
                whileStatement)
        .build()
        .toString();


  }


}
