trait Cloneable extends java.lang.Cloneable{
  override def clone() = super.clone().asInstanceOf[Cloneable]
}

trait Readable {
  def reset(): Unit
}

type CloneRead = Cloneable with Readable

def cloneAndReset(obj:CloneRead):Cloneable = {
  val cloned = obj.clone()
  obj reset()
  cloned
}