// See LICENSE.txt for license details.
package problems

import chisel3._
import chisel3.util._
import scala.collection.mutable.ArrayBuffer

// Problem:
//
// Implement a four-by-four multiplier using a look-up table.
//
class Mul extends Module {
  val io = IO(new Bundle {
    val x   = Input(UInt(4.W))
    val y   = Input(UInt(4.W))
    val z   = Output(UInt(8.W))
  })
  val mulsValues = new ArrayBuffer[UInt]()
  // Calculate io.z = io.x * io.y by generating a table of values for mulsValues

  // Implement below ----------
  for (x <- 0 until 16) {
    for (y <- 0 until 16) {
      mulsValues += (x * y).U
      // printf("%d %d %d\n", x.U, y.U, mulsValues(x*16+y))
    }
  }
  val table = VecInit(mulsValues)
  val word = Cat(io.x, io.y)
  // printf("io.x, io.y, word: %d, %d, %d\n", io.x, io.y, word)
  // io.z := 0.U
  io.z := table(word)

  // Implement above ----------
}
