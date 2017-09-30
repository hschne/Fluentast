---
layout: default
---


<div class="container">

    <div class="row">
        <div class="col-md-6">
            <h2 class="header-light regular-pad">Fluentast</h2>
            <blockquote>
              <p>Jekyll is a simple, blog-aware, static site generator. It takes a template
              directory containing raw text files in various formats, runs it through
              a converter (like <a href="https://daringfireball.net/projects/markdown/">Markdown</a>)
              and our <a href="https://github.com/Shopify/liquid/wiki">Liquid</a> renderer, and
              spits out a complete, ready-to-publish static website suitable
              for serving with your favorite web server. Jekyll also happens to be the engine
              behind <a href="https://pages.github.com">GitHub Pages</a>, which means you can use Jekyll
              to host your project’s page, blog, or website from GitHub’s servers <strong>for
              free</strong>.</p>
            </blockquote>
        </div>
        <div class="col-md-6 text-center">
            <img src="img/jekyll-dark.png" alt="" class="img-responsive">
        </div>
    </div>

    <hr>


<div id="exTab2" class="container">	
<ul class="nav nav-tabs">
			<li class="active">
        <a  href="#1" data-toggle="tab">Plain Java</a>
			</li>
			<li><a href="#2" data-toggle="tab">Using JDT</a>
			</li>
			<li><a href="#3" data-toggle="tab">Using Fluentast</a>
			</li>
		</ul>
			<div class="tab-content ">
			  <div class="tab-pane active" id="1">
{% highlight java %}
int i=1;
while (true) {
  System.out.println(i);
  if (i > 99)     break;
  i++;
}
{% endhighlight %}
				</div>
				<div class="tab-pane" id="2">
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
				
        <div class="tab-pane" id="3">
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
  </div>


    <div class="row">
        <div class="col-sm-4">
            <h1 class="text-center"><i class="fa fa-pencil" aria-hidden="true"></i></h1>
            <h3 class="text-center">Easy to install and publish</h3>
            <p>Get started by clonening source into GitHub account of your project. Thanks to <a href="https://pages.github.com">GitHub Pages</a>,
              it will be automatically compiled and publsihed under your project's subdomain on `github.io`.
            </p>
        </div>
        <div class="col-sm-4">
            <h1 class="text-center"><i class="fa fa-cogs" aria-hidden="true"></i></h1>
            <h3 class="text-center">Modular Styling and Templating</h3>
            <p>This template uses <a href="https://github.com/twbs/bootstrap-sass">bootstrap-sass</a> along with <a href="https://bootswatch.com/">Bootwatch themes</a>.
            You can change the theme or write your custom by overwriting bootstrap sass variables for different color set, font options, etc.</p>
        </div>
        <div class="col-sm-4">
            <h1 class="text-center"><i class="fa fa-code-fork" aria-hidden="true"></i></h1>
            <h3 class="text-center">Git based source control</h3>
            <p>Leverege from Git version control system by
              maintaining your documentation along with the source code; publish the page when you merge to the master branch.</p>
        </div>
    </div>
</div>
