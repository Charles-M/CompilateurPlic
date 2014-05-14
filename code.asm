#Initialisation
la $t7,($sp)
la $s7,($gp)

#Bloc
Class_test:
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

#Bloc
Constructeur_idf353028520:
li $v0, 2
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,4($s7)
#ecrire string
.data
str1: .asciiz "a = "
.text
li $v0,4
la $a0,str1
syscall

lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4

#ecrire entier
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

#ecrire string
.data
str2: .asciiz "\nA = "
.text
li $v0,4
la $a0,str2
syscall

lw $v0,8($s7)
sw $v0, ($sp)
add $sp, $sp, -4

#ecrire entier
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

#ecrire string
.data
str3: .asciiz "\nFIN"
.text
li $v0,4
la $a0,str3
syscall

