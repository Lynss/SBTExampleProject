class Graph{
  class Node{
    var connectedNodes :List[Graph#Node] = Nil
    def connectToNode(node:Graph#Node) = {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  private var nodes:List[Node]  =Nil
  def newNode:Node={
    val node = new Node
    nodes = node::nodes
    node
  }
}

val graph1: Graph = new Graph
val node1: graph1.Node = graph1.newNode
val node2: graph1.Node = graph1.newNode
node1.connectToNode(node2)      // legal
val graph2: Graph = new Graph
val node3: graph2.Node = graph2.newNode
node1.connectToNode(node3)      // illegal! if type Graph#Node is Node
