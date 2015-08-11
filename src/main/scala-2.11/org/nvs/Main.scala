package org.nvs

import org.nvs.cmd._
import org.nvs.expr.evaluators.BcEvaluator

/**
 * The main entry point for the REPL
 */
object Main extends App with CommandParser {

  println("Welcome to the repl!")

  var prompt = true

  while(prompt) {
    val input = io.StdIn.readLine()
    parse(command, input) match {
      case Success(cmd, _) =>
        val (result, continue) = execCommand(cmd)
        println(result)
        prompt = continue
      case f@_ => println(s"Unable to process input: $f")
    }
  }

  def execCommand(cmd: Command): (Any, Boolean) = cmd match {
    case Bc(expr) => (BcEvaluator.safeEval(expr) match {
      case scala.util.Success(r) => r
      case scala.util.Failure(t) => t
    }, true)
    case Quit => ("bye!", false)
  }

}
