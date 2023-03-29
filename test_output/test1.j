.class public test1
.super java/lang/Object

.field private static in Ljava/util/Scanner;

.method static <clinit>()V
.limit stack 3
.limit locals 0
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokenonvirtual java/util/Scanner/<init>(Ljava/io/InputStream;)V
putstatic test1/in Ljava/util/Scanner;
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 15

return
.end method
