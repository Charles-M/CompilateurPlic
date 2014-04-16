li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
bgt $t8, $v0, greater2052920903
li $v0,0
b continue2052920903

greater2052920903:
li $v0,1

continue2052920903:
sw $v0, ($sp)
add $sp, $sp, -4

li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 2
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
beq $t8, $v0, equal1969344019
li $v0,0
b continue1969344019

equal1969344019:
li $v0,1

continue1969344019:
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
beq $v0, 0, XOR1746959769
li $v0,1
b continue1746959769

XOR1746959769:
li $v0,0

continue1746959769:
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
bgt $v0, 0, AND756415799
li $v0,0
b continue756415799

AND756415799:
li $v0,1

continue756415799:
sw $v0, ($sp)
add $sp, $sp, -4
