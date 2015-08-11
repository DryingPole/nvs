package org.nvs.expr.evaluators

/**
 * Mimics arithmetic behavior as defined by the Unix utility "bc", namely by using integer division.
 */
object BcEvaluator extends ArithEvaluator {

  /**
   * Returns an integer result of the division of a by b.
   * @param a the dividend.
   * @param b the divisor.
   * @return the result.
   */
  override def div(a: Double, b: Double): Double = if (b == 0) throw new ArithmeticException("Divide by 0") else (a/b).toInt

}
