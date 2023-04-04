package edu.westminstercollege.cmpt355.minijava2;

import edu.westminstercollege.cmpt355.minijava2.node.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Compiler {

    private SymbolTable symbols = new SymbolTable();
    private PrintWriter out;
    private final Block program;
    private final String className;

    public Compiler(Block program, String className) {
        this.program = program;
        this.className = className;
    }

    public void compile(Path outputDir) throws IOException, SyntaxException {
        Path asmFilePath = outputDir.resolve(className + ".j");
        try (var out = new PrintWriter(Files.newBufferedWriter(asmFilePath))) {
            this.out = out;
            symbols.allocateLocalVariable(1);
            symbols.registerVariable(new ClassType("String"),"args");
            resolveSymbols(program);
            program.typecheck(symbols);

            out.printf(".class public %s\n", className);
            out.printf(".super java/lang/Object\n");
            out.println();
            out.println(".field private static in Ljava/util/Scanner;");
            out.println();
            out.printf("""
                    .method static <clinit>()V
                    .limit stack 3
                    .limit locals 0
                    new java/util/Scanner
                    dup
                    getstatic java/lang/System/in Ljava/io/InputStream;
                    invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V
                    putstatic %s/in Ljava/util/Scanner;
                    return
                    .end method
                    
                    """, className);
            out.printf(".method public static main([Ljava/lang/String;)V\n");
            out.printf(".limit stack 100\n");
            out.printf(".limit locals %d\n", symbols.getVariableCount()*2);
            out.println();

            // Generate code for program here 🙂
            // Generate code for each statement of the program
            for (var statement : program.stmt())
                generateCode(statement);

            //program.statements().forEach(this::generateCode);

            out.printf("return\n");
            out.printf(".end method\n");
        }
    }

    // Make sure that all symbols (in this case, names of variables) make sense,
    // i.e. we should not be using the value of a variable before we have assigned
    // to it (Eval does not have declarations).
    private void resolveSymbols(Block program) throws SyntaxException {
        AST.postOrder(program, node -> {
            switch (node) {
                case VarDeclarations(ParserRuleContext ignored, TypeNode type, List<VarDecs> vars) -> {
                    for (var dec: vars) {
                        switch (dec) {
                            case VarDeclaration(ParserRuleContext ctx, String name) -> {
                                if (symbols.findVariable(name).isEmpty())
                                    symbols.registerVariable(type.getType(), name);
                                else
                                    throw new SyntaxException(node, String.format("Variable already assigned: %s", name));
                            }
                            case VarDeclarationInit(ParserRuleContext ctx, String name, Expression expr) -> {
                                if (symbols.findVariable(name).isEmpty())
                                    symbols.registerVariable(type.getType(), name);
                                else
                                    throw new SyntaxException(node, String.format("Variable already assigned: %s", name));
                            }
                        }
                    }
                }
                case VariableAccess(ParserRuleContext ctx, String name) -> {
                    if (symbols.findVariable(name).isEmpty())
                        throw new SyntaxException(node, String.format("Variable used before assignment: %s", name));
                }
                case Assignment(ParserRuleContext ctx, Expression target, Expression value) -> {
                    if (target instanceof VariableAccess var) {
                        if (symbols.findVariable(var.variableName()).isEmpty())
                            throw new SyntaxException(node, String.format("Variable used before assignment: %s", var.variableName()));
                    } else {
                        throw new SyntaxException(node, "Left side of assignment must be a variable");
                    }
                }
                default -> {}
            }
        });
    }

    private void generateCode(Statement statement) {
        switch (statement) {
            case Block(ParserRuleContext ctx, ArrayList<Statement> statements) -> {
                for (var stmt : statements)//block generated by copilot
                    generateCode(stmt);
            }
            case VarDeclarations(ParserRuleContext ctx, TypeNode type, List<VarDecs> vars) -> {
                //placeholder generateCode(type);
                for (var dec: vars) {
                    if (dec instanceof VarDeclarationInit init) {//block generated by copilot
                        generateCode(init.value());
                        Variable var = symbols.findVariable(init.name()).get();
                        if (var.getType() == PrimitiveType.Double) {
                            if (init.value().getType(symbols) == PrimitiveType.Int)//block generated by copilot
                                out.println("i2d");
                            out.printf("dstore %d\n", var.getIndex());
                        } else if (var.getType() == PrimitiveType.Int || var.getType() == PrimitiveType.Boolean) {
                            out.printf("istore %d\n", var.getIndex());
                        } else if (var.getType().equals(new ClassType("String"))) {
                            out.printf("astore %d\n", var.getIndex());
                        }
                    }
                }
            }
            case ExpressionStatement(ParserRuleContext ctx, Expression expr) -> {
                generateCode(expr);
                if (expr.getType(symbols) == PrimitiveType.Double) {
                    out.println("pop2");
                } else if (expr.getType(symbols) != VoidType.Instance) {
                    out.println("pop");
                }
            }
            case EmptyStatement(ParserRuleContext ctx) -> {
                //do nothing
            }
            default -> throw new RuntimeException(String.format("Unimplemented: %s", statement.getNodeDescription()));
        }
    }

    private void generateCode(Expression expr) {
        switch (expr) {
            case Print(ParserRuleContext ctx, List<Expression> args) -> {
                // Print each argument individually (using generateCode(PrintArgument))
                // then do a println.
                for (var arg : args) {
                    out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    generateCode(arg);
                    if (arg.getType(symbols) == PrimitiveType.Double) {//block generated by copilot
                        out.println("invokevirtual java/io/PrintStream/print(D)V");
                    } else if (arg.getType(symbols) == PrimitiveType.Int) {
                        out.println("invokevirtual java/io/PrintStream/print(I)V");
                    } else if (arg.getType(symbols) == PrimitiveType.Boolean) {
                        out.println("invokevirtual java/io/PrintStream/print(Z)V");
                    } else if (arg.getType(symbols).equals(new ClassType("String"))) {
                        out.println("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
                    }
                }
                out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
                out.println("invokevirtual java/io/PrintStream/println()V");
            }
            case Assignment(ParserRuleContext ctx, Expression varName, Expression value) -> {
                Variable var = symbols.findVariable(((VariableAccess)varName).variableName()).get();
                generateCode(value); // get the value to be assigned on top of the stack
                if (value.getType(symbols) == PrimitiveType.Int && var.getType() == PrimitiveType.Double)//block generated by copilot
                    out.println("i2d");
                if (var.getType() == PrimitiveType.Double) {
                    out.printf("dup2\n");
                } else {
                    out.printf("dup\n");
                }
                if (var.getType() == PrimitiveType.Double) {
                    out.printf("dstore %d\n", var.getIndex());
                } else if (var.getType() == PrimitiveType.Int || var.getType() == PrimitiveType.Boolean) {
                    out.printf("istore %d\n", var.getIndex());
                } else {
                    out.printf("astore %d\n", var.getIndex());//statement generated by copilot
                }
            }
            case IntLiteral(ParserRuleContext ctx, int val) -> {
                out.printf("ldc %d\n", val);
            }
            case DoubleLiteral(ParserRuleContext ctx, double val) -> {
                out.printf("ldc2_w %f\n", val);
            }
            case BooleanLiteral(ParserRuleContext ctx, String bool) -> {
                if ("true".equals(bool)) // condition generated by copilot
                    out.println("iconst_1");
                else
                    out.println("iconst_0");
            }
            case StringLiteral(ParserRuleContext ctx, String str) -> {//block generated by copilot
                out.printf("ldc %s\n", str);
            }
            case Negate(ParserRuleContext ctx, Expression child) -> {
                generateCode(child);
                if (child.getType(symbols) == PrimitiveType.Double) //block generated by copilot
                    out.println("dneg");
                else
                    out.println("ineg");
            }
            case PreIncrement(ParserRuleContext ctx, Expression child, String op) -> {
                generateCode(child);
                var type = child.getType(symbols);

                if (type == PrimitiveType.Double) {
                    out.println("dconst_1");
                    if (op.equals("++"))
                        out.println("dadd");
                    else
                        out.println("dsub");
                    out.printf("dup2\n");
                    out.printf("dstore %d\n", symbols.findVariable(((VariableAccess)child).variableName()).get().getIndex());
                } else if (type == PrimitiveType.Int) {
                    out.println("iconst_1");
                    if (op.equals("++"))
                        out.println("iadd");
                    else
                        out.println("isub");
                    out.printf("dup\n");
                    out.printf("istore %d\n", symbols.findVariable(((VariableAccess)child).variableName()).get().getIndex());
                }
            }
            case PostIncrement(ParserRuleContext ctx, Expression child, String op) -> {
                generateCode(child);
                var type = child.getType(symbols);

                if (type == PrimitiveType.Double) {
                    out.printf("dup2\n");
                    out.println("dconst_1");
                    if (op.equals("++"))
                        out.println("dadd");
                    else
                        out.println("dsub");
                    out.printf("dstore %d\n", symbols.findVariable(((VariableAccess)child).variableName()).get().getIndex());
                } else if (type == PrimitiveType.Int) {
                    out.printf("dup\n");
                    out.println("iconst_1");
                    if (op.equals("++"))
                        out.println("iadd");
                    else
                        out.println("isub");
                    out.printf("istore %d\n", symbols.findVariable(((VariableAccess)child).variableName()).get().getIndex());
                }
            }
            case VariableAccess(ParserRuleContext ctx, String variableName) -> {
                var v = symbols.findVariable(variableName).get();
                if (v.getType() == PrimitiveType.Double) {//block generated by copilot
                    out.printf("dload %d\n", v.getIndex());
                } else if (v.getType() == PrimitiveType.Int || v.getType() == PrimitiveType.Boolean) {
                    out.printf("iload %d\n", v.getIndex());
                } else {
                    out.printf("aload %d\n", v.getIndex());
                }
            }
            case BinaryOp(ParserRuleContext ctx, Expression left, Expression right, String op) -> {//block generated by copilot but edited
                generateCode(left);
                if (left.getType(symbols) == PrimitiveType.Int && right.getType(symbols) == PrimitiveType.Double) {//block generated by copilot
                    out.println("i2d");
                }
                generateCode(right);

                if (left.getType(symbols) == PrimitiveType.Double && right.getType(symbols) == PrimitiveType.Int) {//block generated by copilot
                    out.println("i2d");
                }

                Type leftType = left.getType(symbols), rightType = right.getType(symbols);

                switch (op) {
                    case "+" -> {
                        if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) //block generated by copilot
                            out.println("dadd");
                        else
                            out.println("iadd");
                    }
                    case "-" -> {
                        if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) //block generated by copilot
                            out.println("dsub");
                        else
                            out.println("isub");
                    }
                    case "*" -> {
                        if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) //block generated by copilot
                            out.println("dmul");
                        else
                            out.println("imul");
                    }
                    case "/" -> {
                        if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) //block generated by copilot
                            out.println("ddiv");
                        else
                            out.println("idiv");
                    }
                    case "%" -> {
                        if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) //block generated by copilot
                            out.println("drem");
                        else
                            out.println("irem");
                    }
                }
            }
            case Cast(ParserRuleContext ctx, TypeNode type, Expression child) -> {
                generateCode(child);

                if (type.getType() == PrimitiveType.Double && child.getType(symbols) == PrimitiveType.Int) {
                    out.println("i2d");
                } else if (type.getType() == PrimitiveType.Int && child.getType(symbols) == PrimitiveType.Double) {
                    out.println("d2i");
                } else if (type.getType().equals(new ClassType("String"))) {
                    if (child.getType(symbols) == PrimitiveType.Int) {
                        out.println("invokedynamic makeConcatWithConstants(I)Ljava/lang/String;");
                    } else if (child.getType(symbols) == PrimitiveType.Double) {
                        out.println("invokedynamic makeConcatWithConstants(D)Ljava/lang/String;");
                    } else if (child.getType(symbols) == PrimitiveType.Boolean) {
                        out.println("invokedynamic makeConcatWithConstants(Z)Ljava/lang/String;");
                    } else {
                        out.println("invokedynamic makeConcatWithConstants(Ljava/lang/String;)Ljava/lang/String;");
                    }
                }
            }
            default ->
                    throw new RuntimeException(String.format("Unimplemented: %s", expr.getNodeDescription()));
        }
    }
}
