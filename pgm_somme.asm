#Initialisation
la $t7,($sp)
la $s7,($gp)

#Bloc
Class_Prout:
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
Constructeur_idf1778858866:
#ecrire string
.data
str1: .asciiz "Calcul de somme : c = a + b \n"
.text
li $v0,4
la $a0,str1
syscall

#ecrire string
.data
str2: .asciiz "nombre a : "
.text
li $v0,4
la $a0,str2
syscall

#lire entier
li $v0,5
syscall
sw $v0,($sp)
add $sp,$sp,-4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,4($s7)

#ecrire string
.data
str3: .asciiz "\nnombre b : "
.text
li $v0,4
la $a0,str3
syscall

#lire entier
li $v0,5
syscall
sw $v0,($sp)
add $sp,$sp,-4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,12($s7)

lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,12($s7)
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
sw $v0,8($s7)
#ecrire string
.data
str4: .asciiz "\nresultat de "
.text
li $v0,4
la $a0,str4
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
str5: .asciiz " + "
.text
li $v0,4
la $a0,str5
syscall

lw $v0,12($s7)
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
str6: .asciiz " = "
.text
li $v0,4
la $a0,str6
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
str7: .asciiz ".\n"
.text
li $v0,4
la $a0,str7
syscall

#ecrire string
.data
str8: .asciiz "FIN"
.text
li $v0,4
la $a0,str8
syscall

