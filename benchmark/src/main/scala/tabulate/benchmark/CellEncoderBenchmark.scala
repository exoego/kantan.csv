package tabulate.benchmark

import org.openjdk.jmh.annotations._
import tabulate.ops._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
class CellEncoderBenchmark extends BenchData {
  @Benchmark
  def encodeInt = ints.map(_.asCsvCell)

  @Benchmark
  def encodeOptions = options.map(_.asCsvCell)
}
