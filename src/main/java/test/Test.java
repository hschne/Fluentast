package test;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;

import static at.hschroedl.fluentast.BlockKt.body;
import static at.hschroedl.fluentast.ExpressionKt.ex;
import static at.hschroedl.fluentast.StatementKt.*;

public class Test {

    public static void main(String[] args) {
        ThingTest();
        System.out.println("JEAH");
    }

    public static void test() {

        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource("int a = 5; a++;".toCharArray());
        parser.setResolveBindings(true);
        parser.setKind(ASTParser.K_STATEMENTS);
        Block unit = (Block) parser.createAST(null);
        System.out.println(unit.toString());
    }

    public static void ThingTest() {

        System.out.println(body("int a = 1; return a;").build());
        System.out.println(body(
                empty(),
                br(),
                ret(ex()))
                .build().toString());
    }
}
