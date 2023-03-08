package pc.exercise

import pc.modelling.SystemAnalysis.Path
import pc.modelling.SystemAnalysis.paths

object SafetyChecker:

  import pc.utils.MSet

  def isSafe[S](petriNet: pc.modelling.System[S], initialState: S, excludedCase: S, depth: Int): Boolean =
    !petriNet.paths(initialState, 10).toList.flatten.contains(excludedCase)

  def isSafeMany[S](petriNet: pc.modelling.System[S], initialState: S, excludedCases: Seq[S], depth: Int): Boolean =
    excludedCases.map(x => isSafe(petriNet, initialState, x, depth)).foldLeft(true)(_ & _)
  
