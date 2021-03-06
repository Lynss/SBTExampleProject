class Wire{
  def inverter(input: Wire, output: Wire)
  def andGate(a1: Wire, a2: Wire, output: Wire)
  def orGate(o1: Wire, o2: Wire, output: Wire)'

  def halfAdder(a:Wire,b:Wire,s:Wire,c:Wire) = {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }
}