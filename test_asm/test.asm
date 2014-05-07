la $t7,($sp)
la $s7,($gp)
.data
newline: .asciiz "\n"
.text

Class_test:

Constructeur_idf26056784:
lw $v0,4($s7)
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 5
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
lw $v0,8($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,4
la $a0,newline
syscall

li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

Constructeur_idf17478435:
lw $v0,8($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,4
la $a0,newline
syscall

li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4

Constructeur_idf24569170:
li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,8($s7)
lw $v0,8($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,4
la $a0,newline
syscall

li $v0,5
syscall

sw $v0,($sp)
add $sp,$sp,-4
add $sp, $sp, 4
lw $v0, ($sp)
sw $v0,8($s7)
lw $v0,8($s7)
sw $v0, ($sp)
add $sp, $sp, -4
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,4
la $a0,newline
syscall

li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 5
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 6
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
add $sp,$sp,4
lw $t8,($sp)
li $v0,1
add $a0,$t8,$zero
syscall

li $v0,4
la $a0,newline
syscall

