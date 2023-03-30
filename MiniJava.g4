grammar MiniJava;

@parser::header {
import edu.westminstercollege.cmpt355.minijava2.node.*;
}

methodBody
returns [Block n]
    : (stmts += statement)* EOF {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block($ctx, statements);
    }
    ;

statement
returns [Statement n]
    : '{' (stmts+=statement)* '}' {
        var statements = new ArrayList<Statement>();
        for (var stmt : $stmts)
            statements.add(stmt.n);

        $n = new Block($ctx, statements);
    }
    | variableDeclaration {
        $n = $variableDeclaration.n;
    }
    | expr ';' {
        $n = new ExpressionStatement($ctx, $expr.n);
    }
    | ';' {
        $n = new EmptyStatement($ctx);
    }
    ;

variableDeclaration
returns [VarDeclarations n]
    : type args+=variableDeclarationItem (',' args+=variableDeclarationItem)* ';' {
        var arguments = new ArrayList<VarDecs>();
        for (var arg : $args)
            arguments.add(arg.n);
        $n = new VarDeclarations($ctx, new TypeNode($ctx, $type.n), arguments);
    }
    ;

variableDeclarationItem
returns [VarDecs n]
    : NAME {
        $n = new VarDeclaration($ctx, $NAME.text);
    }
    | NAME '=' expr {
        $n = new VarDeclarationInit($ctx, $NAME.text, $expr.n);
    }
    ;

expr
returns [Expression n]
    : l=expr op=('++' | '--') {
        $n = new PostIncrement($ctx, $l.n, $op.text);
    }
    // unary
    | op=('++' | '--' | '+' | '-') expr {
        if ($op.text.equals("-")) {
            $n = new Negate($ctx, $expr.n);
        } else if (!$op.text.equals("+")) {
            $n = new PreIncrement($ctx, $expr.n, $op.text);
        }
    }
    | '(' type ')' expr {
        $n = new Cast($ctx, new TypeNode($ctx, $type.n), $expr.n);
    }
    | l=expr op=('*' | '/' | '%') r=expr {
        $n = new BinaryOp($ctx, $l.n, $r.n, $op.text);
    }
    | l=expr op=('+' |'-' ) r=expr {
        $n = new BinaryOp($ctx, $l.n, $r.n, $op.text);
    }
    |<assoc=right>l=expr '=' r=expr {
        $n = new Assignment($ctx, $l.n, $r.n);
    }
    | 'print' '(' (args+=expr (',' args+=expr )*)? ')' {
        var arguments = new ArrayList<Expression>();
        for (var arg : $args)
            arguments.add(arg.n);
        $n = new Print($ctx, arguments);
    }
    | '(' expr ')' {
        $n = $expr.n;
    }
    | INT {
        $n = new IntLiteral($ctx, Integer.parseInt($INT.text));
    }
    | DOUBLE {
        $n = new DoubleLiteral($ctx, Double.parseDouble($DOUBLE.text));
    }
    | STRING {
        $n = new StringLiteral($ctx, $STRING.text);
    }
    | 'true' {
        $n = new BooleanLiteral($ctx, "True");
    }
    | 'false' {
        $n = new BooleanLiteral($ctx, "False");
    }
    | NAME {
        $n = new VariableAccess($ctx, $NAME.text);
    }
    ;

type
returns [Type n]
    : 'double' {
        $n = PrimitiveType.Double;
    }
    | 'boolean' {
        $n = PrimitiveType.Boolean;
    }
    | 'int' {
        $n = PrimitiveType.Int;
    }
    | NAME {
        $n = new ClassType($NAME.text);
    }
    ;

LINE_COMMENT
    : '//' .*? ('\n' | EOF) -> skip
    ;


MULTI_COMMENT
    : '/*' .*? '*/' -> skip
    ;

STRING
    : '"' .*? '"'
    ;

KEYWORD
    : 'abstract'   | 'continue'   | 'for'          | 'new'         | 'switch'
    | 'assert'     | 'default'    | 'if'           | 'package'     | 'synchronized'
    | 'boolean'    | 'do'         | 'goto'         | 'private'     | 'this'
    | 'break'      | 'double'     | 'implements'   | 'protected'   | 'throw'
    | 'byte'       | 'else'       | 'import'       | 'public'      | 'throws'
    | 'case'       | 'enum'       | 'instanceof'   | 'return'      | 'transient'
    | 'catch'      | 'extends'    | 'int'          | 'short'       | 'try'
    | 'char'       | 'final'      | 'interface'    | 'static'      | 'void'
    | 'class'      | 'finally'    | 'long'         | 'strictfp'    | 'volatile'
    | 'const'      | 'float'      | 'native'       | 'super'       | 'while'
    | '_'
    ;

INT
    : [0-9]+
    ;

fragment FIXED_POINT
    : [0-9]+ '.' [0-9]*
    | [0-9]* '.' [0-9]+
    ;

DOUBLE
    : FIXED_POINT
    | (FIXED_POINT | INT) [eE] [+-]? INT
    ;

NAME
    : [a-zA-Z_$][a-zA-Z_$0-9]*
    ;

WS
    : [ \n\r\t]+ -> skip
    ;