package pc.exercise

import java.util.Random
import pc.modelling.{CTMCSimulation, DAP, DAPGrid}
import pc.utils.{MSet, Grids}
import pc.modelling.CTMCSimulation.*

object Exercise:
  enum Place:
    case A, B, C

  type ID = (Int, Int)
  export Place.*
  export pc.modelling.DAP.*
  export pc.modelling.DAPGrid.*
  export pc.modelling.CTMCSimulation.*

  val gossipRules = DAP[Place](
    Rule(MSet(A, A), m => 1000, MSet(A), MSet()),
    Rule(MSet(A), m => 1, MSet(B), MSet(A)),
    Rule(MSet(A, B), m => 1, MSet(C), MSet()),
    Rule(MSet(A, C), m => 1, MSet(C), MSet()),
  )
  val gossipCTMC = DAP.toCTMC[ID, Place](gossipRules)
  val net = Grids.createRectangularGrid(5, 5)
  // an `a` initial on top left
  val state = State[ID, Place](MSet(Token((0, 0), A)), MSet(), net)

@main def mainDAPGossip =
  import Exercise.*
  gossipCTMC.newSimulationTrace(state, new Random).take(50).toList.foreach(
    step =>
      println(step._1) // print time
      println(DAPGrid.simpleGridStateToString[Place](step._2, A)) // print state, i.e., A's
  )