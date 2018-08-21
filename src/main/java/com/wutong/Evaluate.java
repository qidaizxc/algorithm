package com.wutong;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * Dijkstra的双核算术表达式求值算法
 */
public class Evaluate {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();

    Scanner scanner = new Scanner(System.in);
 //    String str = "(1 + ( ( 2 + 3  ) * ( 4 * 5 )))";
    String str = scanner.next().replaceAll(" ", "");
    scanner.close();
    for (int i = 0; i < str.length(); i++) {
      String s = str.substring(i, i + 1);
      if (s.equals("(")) {
        continue;
      }
      if (
        s.equals("+") ||
          s.equals("-") ||
          s.equals("*") ||
          s.equals("/") ||
          s.equals("sqrt")
        ) {
        ops.push(s);
      } else if (s.equals(")")) {
        String op = ops.pop();
        double v = vals.pop();
        if (op.equals("+")) {
          v = vals.pop() + v;
        } else if (op.equals("-")) {
          v = vals.pop() - v;
        } else if (op.equals("*")) {
          v = vals.pop() * v;
        } else if (op.equals("/")) {
          v = vals.pop() / v;
        } else if (op.equals("sqrt")) {
          v = Math.sqrt(v);
        }
        vals.push(v);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    StdOut.println(vals.pop());
  }
}
