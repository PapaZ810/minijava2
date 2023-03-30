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
.limit locals 14

ldc 583
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Change for $"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
i2d
ldc2_w 100.000000
ddiv
invokevirtual java/io/PrintStream/print(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc ":"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
iload 2
ldc 100
idiv
istore 3
iload 2
ldc 100
irem
dup
istore 2
pop
iload 2
ldc 25
idiv
istore 4
iload 2
ldc 25
irem
dup
istore 2
pop
iload 2
ldc 10
idiv
istore 5
iload 2
ldc 10
irem
dup
istore 2
pop
iload 2
ldc 5
idiv
istore 6
iload 2
ldc 5
irem
dup
istore 2
pop
iload 2
istore 7
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "    "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 3
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " dollars"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "    "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 4
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " quarters"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "    "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 5
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " dimes"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "    "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 6
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " nickels"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "    "
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 7
invokevirtual java/io/PrintStream/print(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " pennies"
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
return
.end method
