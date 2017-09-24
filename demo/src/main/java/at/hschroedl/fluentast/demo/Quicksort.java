package at.hschroedl.fluentast.demo;

import at.hschroedl.fluentast.demo.quicksort.QuicksortWithFluentast;
import at.hschroedl.fluentast.demo.quicksort.QuicksortWithJDT;

import static at.hschroedl.fluentast.FluentastKt.block;
import static at.hschroedl.fluentast.FluentastKt.body;
import static at.hschroedl.fluentast.FluentastKt.decl;
import static at.hschroedl.fluentast.FluentastKt.return_;
import static at.hschroedl.fluentast.FluentastKt.stmnt;
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
    out.println(QuicksortWithFluentast.quickSortFluentast());
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
