package org.nvs.cmd

import org.nvs.expr.parsers.ExprParser
import scala.util.parsing.combinator.RegexParsers

/**
 * Parses a designated set of REPL commands into a [[org.nvs.cmd.Command]] AST.
 */
trait CommandParser extends RegexParsers with ExprParser {

  def command: Parser[Command] = (
    """[bB][cC]""".r~>"\""~>expr<~"\"" ^^ {e => Bc(e)}
    | "q" ^^^ Quit
    | "^$".r ^^^ Quit
    )
}
