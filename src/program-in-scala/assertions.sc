println("begin a assertion")
//assert(1 == 2,(1,2))

def increase(i:Int):Int = {i +1} ensuring {
  _<i
}


increase(2)