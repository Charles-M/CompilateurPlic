li $v0, 5
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 5
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
mul $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 54
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 5
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
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 50
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
blt $t8, $v0, lower1166379684
li $v0,0
b continue1166379684

lower1166379684:
li $v0,1

continue1166379684:
sw $v0, ($sp)
add $sp, $sp, -4
