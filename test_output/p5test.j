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

ldc2_w 12.500000
dneg
dstore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 2
dup2
dconst_1
dadd
dstore 2
dload 2
dconst_1
dsub
dup2
dstore 2
dadd
invokevirtual java/io/PrintStream/print(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 2
invokevirtual java/io/PrintStream/print(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
return
.end method
