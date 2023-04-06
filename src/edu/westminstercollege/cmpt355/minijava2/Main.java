package edu.westminstercollege.cmpt355.minijava2;

import edu.westminstercollege.cmpt355.minijava2.node.DoubleLiteral;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String... args) throws IOException {
        final String MINI_JAVA_FILE = "test_programs/p6test.txt";
        final String CLASS_NAME = getClassNameFromPath(MINI_JAVA_FILE);

        System.out.printf("Compiling class %s from %s...\n", CLASS_NAME, MINI_JAVA_FILE);

        var lexer = new MiniJavaLexer(CharStreams.fromFileName(MINI_JAVA_FILE));
        var parser = new MiniJavaParser(new CommonTokenStream(lexer));

        List<Type> paramTypes = List.of(new ClassType("String"));
        SymbolTable symbolTable = new SymbolTable();
        //System.out.println(symbolTable.findJavaClass("Math"));
        System.out.println(symbolTable.findConstructor(new ClassType("String"), paramTypes));

        var program = parser.methodBody().n;
        AST.checkForNulls(program);
        AST.print(program);

        var compiler = new Compiler(program, CLASS_NAME);
        try {
            compiler.compile(Path.of("test_output"));
        }
        catch (SyntaxException ex) {
            System.out.println("\u001B[31mError on line " + ex.getNode().ctx().start.getLine() + "\u001B[0m");
            System.out.println(ex.getMessage());
        }

        jasmin.Main.main(new String[] {
                "-d", "out/test_compiled",
                String.format("test_output/%s.j", CLASS_NAME)
        });

        try {
            // Use reflection to find the class that was just compiled
            var compiledClass = Class.forName(CLASS_NAME);
            // Find its main() method
            var compiledMainMethod = compiledClass.getMethod("main", String[].class);

            System.out.printf("——— Running compiled class %s ———\n", CLASS_NAME);
            // Run the compiled main()
            compiledMainMethod.invoke(null, new Object[] { new String[0] });
            System.out.println("——— End of output ———");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException ex) {
            System.err.println("Unable to execute newly-compiled program: class or method not found!");
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            // An exception was thrown by the compiled program (not a compiler problem 🙂)
            ex.getTargetException().printStackTrace();
        }

    }

    private static String getClassNameFromPath(String path) {
        Path p = Path.of(path);
        String filename = p.getFileName().toString();
        int index = filename.indexOf('.');
        return filename.substring(0, index);
    }
}
