Notes
=====

Focalisé sur les données
------------------------

is a Lisp :
Mode de compilation :
Texte -(read)-> Data(code) -(eval)-> Résultat

all about data
data is easier to read than code

data focus allows for technical decoupling (between libs, protocols etc.). No common code/interface to share and try to match

data focus allows for temporal decoupling. One can push to data to some queue, then this data is consumed.

Primitives
----------

### Numbers

42 Long
3.14 Double
6.5M
3/4 Ratio
985320498572409857959N Big Integer
0xFF Hexadecimal
2r101 : xr where x = base

### Keywords

:mykeyword
:my.namespace/mykeyword


### Collections

In maps {:key 'value'}, keys and values can be anything, even another collection
Functions are special when used as keys, lookup for equality only works with same identity

### Lists ?

Mostly for code, sequential data is better with vectors

Functions
---------

Everything is an expression
All parameters are evaluated before calling the function

Special forms
-------------

Don't evaluate their args like functions, this is why they're called special. Ex: if, let, do, fn, def,

### Let

(let [deux (inc 1)
      trois (inc deux)]
    (* trois deux))

Vectors and not maps are used for let args :
1. Maps are not ordered like vectors, so maps can't express dependencies
2. Same "key" can be used more than once

Let has an implicit do after its vector, so multiple forms can be used.

Core principle in Clojure
-------------------------

Data should be valid. That's all that matter

Mutability
----------

Most of Clojure code is immutable, some the few mutable points are easier to reason with.

swap! changes an atom with a transaction function

Various
-------

contains? doesn't check presence of values, but of indexes/keys. So doesn't work on seqs.

Don't do (as a beginner)
--------

loop/recur : higher level constructs are easier for humans and optimized by machines
recursion : loop like
mmethods, protocoles
macros : too complex
scope dynamiques (set!) : Here be dragons
lazy-seq
indices numériques
atoms partout :

Basically everything we're familiar with, loop-like construct similar to imperative style
