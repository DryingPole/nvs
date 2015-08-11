package org.nvs

/**
 * Defines the types of operations supported by expressions.
 */
package object expr {
  sealed trait Expr
  case class Lit(v: Double) extends Expr
  case class Add(e1: Expr, e2: Expr) extends Expr
  case class Sub(e1: Expr, e2: Expr) extends Expr
  case class Mult(e1: Expr, e2: Expr) extends Expr
  case class Div(e1: Expr, e2: Expr) extends Expr
}
