package com.sidewayscoding.immutable

import com.sidewayscoding.Multiset
import com.sidewayscoding.MultisetLike
import com.sidewayscoding.MultisetBuilder
import scala.collection.mutable.Builder
import scala.collection.generic.CanBuildFrom
import scala.collection.generic.GenericCompanion

abstract class ImmutableMultisetFactory[CC[X] <: Multiset[X] with MultisetLike[X, CC[X]]] 
       extends GenericCompanion[CC] {

  override def newBuilder[A]: Builder[A, CC[A]] = new MultisetBuilder[A, CC[A]](empty[A])

  implicit def newCanBuildFrom[A]: CanBuildFrom[Coll, A, CC[A]] = new CanBuildFrom[Coll, A, CC[A]] {
    def apply(from: Coll) = newBuilder[A]
    def apply() = newBuilder[A]
  }

 }