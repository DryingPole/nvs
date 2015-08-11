package org.nvs

import org.nvs.expr.Expr

/**
 * Defines the set of commands accepted by the REPL.
 */
package object cmd {

  /**
   * Generic super type for all REPL commands.
   */
  sealed trait Command

  /**
   * Represents the Unix "bc" command.
   * @param expr the expression to evaluate.
   */
  case class Bc(expr: Expr) extends Command

  /**
   * Indicates a command to exit the REPL.
   */
  case object Quit extends Command

}
