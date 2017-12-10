---
title: Basics
permalink: /docs/home/
redirect_from: /docs/index.html
---

## Getting Started

Fluentast is a fluent API to create abstract syntax trees for Java. Getting started is simple. 

Install Fluentast using either Maven or Gradle. 

  <ul class="nav nav-tabs">
    <li class="active">
      <a href="#1" data-toggle="tab">Maven</a>
    </li>
    <li><a href="#2" data-toggle="tab">Gradle</a>
    </li>
  </ul>
  <div class="tab-content"  >
    <div class="tab-pane active" id="1">
{% highlight xml %}
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
{% endhighlight %}
    </div>
        <div class="tab-pane" id="2">
{% highlight gradle %}
testCompile group: 'junit', name: 'junit', version: '4.12'

{% endhighlight %}
    </div>

 </div>
 
You may then use Fluentast to create a syntax tree. 


## Examples

The example below demonstrates how to build a simple code snippet can be built using JDT Core or Fluentast.

  <ul class="nav nav-tabs">
    <li class="active">
      <a href="#4" data-toggle="tab">Plain Java</a>
    </li>
    <li><a href="#5" data-toggle="tab">Using JDT</a>
    </li>
    <li><a href="#6" data-toggle="tab">Using Fluentast</a>
    </li>
  </ul>
  <div  class="tab-content ">
    <div class="tab-pane active" id="4">
{% highlight java %}
int i=1;
while (true) {
  System.out.println(i);
  if (i > 99) break;
  i++;
}
{% endhighlight %}
				</div>
				<div class="tab-pane" id="5">
{% highlight java %}
AST ast = AST.newAST(AST.JLS8);
Block block = ast.newBlock();
VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
fragment.setName(ast.newSimpleName("i"));
fragment.setInitializer(ast.newNumberLiteral("1"));
VariableDeclarationStatement statement = ast.newVariableDeclarationStatement(fragment);
statement.setType(ast.newPrimitiveType(PrimitiveType.INT));
block.statements().add(statement);
WhileStatement whileStatement = ast.newWhileStatement();
whileStatement.setExpression(ast.newBooleanLiteral(true));
Block whileBody = ast.newBlock();
MethodInvocation methodInvocation = ast.newMethodInvocation();
methodInvocation.setName(ast.newSimpleName("println"));
methodInvocation.setExpression(ast.newName("System.out"));
methodInvocation
    .arguments()
    .add(ast.newSimpleName("i"));
whileBody
    .statements()
    .add(ast.newExpressionStatement(methodInvocation));
IfStatement ifStatement = ast.newIfStatement();
InfixExpression infixExpression = ast.newInfixExpression();
infixExpression.setLeftOperand(ast.newSimpleName("i"));
infixExpression.setOperator(Operator.GREATER);
infixExpression.setRightOperand(ast.newNumberLiteral("99"));
ifStatement.setExpression(infixExpression);
ifStatement.setThenStatement(ast.newBreakStatement());
whileBody
    .statements()
    .add(ifStatement);
PostfixExpression postfixExpression = ast.newPostfixExpression();
postfixExpression.setOperator(PostfixExpression.Operator.INCREMENT);
postfixExpression.setOperand(ast.newSimpleName("i"));
whileBody
    .statements()
    .add(ast.newExpressionStatement(postfixExpression));
whileStatement.setBody(whileBody);
block.statements().add(whileStatement);
{% endhighlight %}
				</div>

        <div class="tab-pane" id="6">
{% highlight java %}
FluentStatement variableDeclaration = stmnt(decl("int",1));
FluentStatement methodInvocation = stmnt(invocation(name("System.out"),
                                                    new ArrayList<FluentType>(),
                                                    "println",
                                                    n("i")));
FluentBlock whileBody = block(methodInvocation,
                              if_(infix(">")
                                      .left(n("i"))
                                      .right(i(99))).then(break_()),
                              stmnt(postfix("++").operand(n("i"))));
block(variableDeclaration,
      while_(b(true))
          .do_(whileBody))
    .build();
{% endhighlight %}
				</div>
			</div>


You can find additional examples in the in the demo project on [Github](https://github.com/hschroedl/FluentAST/tree/master/demo/src/main/java/at/hschroedl/fluentast/demo). 

For more information regarding the Fluentast syntax have a look at the [syntax page](#) or at the [API](/docs/fluentast-core/)


