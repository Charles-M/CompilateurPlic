la $t7,($sp)
la $s7,($gp)

Class_Essai:
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

Constructeur_idf356611321:
lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 25
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,8($s7)
li $v0, 0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,4($s7)
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

Constructeur_idf2087096917:
.data
str1: .asciiz "programme de test\n"
.text
li $v0,4
la $a0,str1
syscall

.data
str2: .asciiz "\n\n"
.text
li $v0,4
la $a0,str2
syscall

lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

.data
str3: .asciiz "\n"
.text
li $v0,4
la $a0,str3
syscall

li $v0, 12
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,24($s7)
li $v0, 12
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,24($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,24($s7)
lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 10
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 12
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
sub $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,12($s7)
li $v0, 5
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,32($s7)
lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
sub $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,12($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,32($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,20($s7)
lw $v0,12($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,28($s7)
lw $v0,28($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

.data
str4: .asciiz "\n"
.text
li $v0,4
la $a0,str4
syscall

.data
str5: .asciiz "ecriture d�un mot entre guillemets \"\"bonjour\"\""
.text
li $v0,4
la $a0,str5
syscall

.data
str6: .asciiz "\n"
.text
li $v0,4
la $a0,str6
syscall

li $v0,5
syscall

sw $a0,($sp)
add $sp,$sp,-4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,32($s7)
lw $v0,32($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,5
syscall

sw $a0,($sp)
add $sp,$sp,-4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,36($s7)
lw $v0,36($s7)
sw $v0, ($sp)
add $sp, $sp, -4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

Constructeur_idf1463607684:
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,36($s7)
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

Constructeur_idf1576652250:
li $v0, 2
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,36($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
lw $v0,($sp)
sw $v0,40($s7)
