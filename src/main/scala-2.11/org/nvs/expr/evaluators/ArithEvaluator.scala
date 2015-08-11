package org.nvs.expr.evaluators

import org.nvs.expr._

import scala.util.Try

/**
 * Evaluates [[org.nvs.expr.Expr]] arithmetic expression trees using
 * standard arithmetic operators and behaviors
 */
trait ArithEvaluator {

  final def safeEval(expr: Expr): Try[Double] = {
    Try {eval(expr)}
  }

  def eval(expr: Expr): Double = expr match {
    case Lit(v: Double) => v
    case Add(e1, e2) => add(eval(e1), eval(e2))
    case Sub(e1, e2) => sub(eval(e1), eval(e2))
    case Mult(e1, e2) => mult(eval(e1), eval(e2))
    case Div(e1, e2) => div(eval(e1), eval(e2))
  }

  def add(a: Double, b: Double): Double = a + b

  def sub(a: Double, b: Double): Double = a - b

  def mult(a: Double, b: Double): Double = a * b

  def div(a: Double, b: Double): Double = a / b

}
