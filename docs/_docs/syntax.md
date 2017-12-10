---
title: Syntax
permalink: /docs/syntax/
---

## Syntax

Work in progress.

## FluentAST and JDT

FLuentast is basically a fancy wrapper around various [JDT](https://www.eclipse.org/jdt/) classes. Really, there's no point denying it. 
 
This means that pretty much all types in Fluentast have a corresponding type in JDT. For example, the class *FluentReturnStatement* represents *[ReturnStatement](http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjdt%2Fcore%2Fdom%2FReturnStatement.html)* from JDT. 
And of course, the syntax tree built using FluentAST is always of type [AST](https://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fjdt%2Fcore%2Fdom%2FAST.html). You can have a look at the JDT grammar, that was used for constructing Fluentast [here](http://slebok.github.io/zoo/java/eclipse/jdt/extracted/index.html).

To find out how to construct a type you know from JDT using Fluentast check out the API or simply search for it using the search bar above. 

You may simply convert the AST created by Fluentast to a String and write it to a file, or leverage additional functionality from JDT. 