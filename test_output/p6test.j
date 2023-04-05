.class public p6test
.super java/lang/Object

.field private static in Ljava/util/Scanner;

.method static <clinit>()V
.limit stack 3
.limit locals 0
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V
putstatic p6test/in Ljava/util/Scanner;
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 8
i2d
ldc2_w 12.000000
dsub
invokestatic java/lang/String.valueOf(D)Ljava/lang/String;
ldc ""
invokevirtual java/lang/String.concat(Ljava/lang/String;)Ljava/lang/String;
ldc 6
ldc 2
imul
invokestatic java/lang/String.valueOf(I)Ljava/lang/String;
invokevirtual java/lang/String.concat(Ljava/lang/String;)Ljava/lang/String;
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokevirtual java/io/PrintStream/println()V
return
.end method
