.class public p5test
.super java/lang/Object

.field private static in Ljava/util/Scanner;

.method static <clinit>()V
.limit stack 3
.limit locals 0
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V
putstatic p5test/in Ljava/util/Scanner;
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 4

bipush 5
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 2
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
return
.end method
