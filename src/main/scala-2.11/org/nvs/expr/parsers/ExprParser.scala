package org.nvs.expr.parsers

import org.nvs.expr._

import scala.util.parsing.combinator.RegexParsers

/**
 * Parses arithmetic expressions into an AST of [[org.nvs.expr.Expr]]s
 */
trait ExprParser extends RegexParsers {

  def double: Parser[Double] =  """-?\d+(\.\d*)?""".r ^^ {_.toDouble}

  def expr: Parser[Expr] = term~rep("+"~term | "-"~term)  ^^ {
    case e~rest => rest.foldLeft(e: Expr) {
      (base, next) => next match {
        case "+" ~ v => Add(base, v)
        case "-" ~ v => Sub(base, v)
      }
    }
  }

  def term: Parser[Expr] = factor~rep("*"~factor | "/"~factor) ^^ {
    case e~rest => rest.foldLeft(e: Expr) {
      (base, next) => next match {
        case "*" ~ v => Mult(base, v)
        case "/" ~ v => Div(base, v)
      }
    }
  }

  def factor: Parser[Expr] = (
    double ^^ {Lit(_)}
    | "("~>expr<~")"
    | "{"~>expr<~"}"
  )
}
