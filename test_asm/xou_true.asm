li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
bne $t8, $v0, non_equal1037797730
li $v0,0
b continue1037797730

non_equal1037797730:
li $v0,1

continue1037797730:
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
blt $t8, $v0, lower404267176
li $v0,0
b continue404267176

lower404267176:
li $v0,1

continue404267176:
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
beq $v0, 0, XOR2027651571
li $v0,1
b continue2027651571

XOR2027651571:
li $v0,0

continue2027651571:
sw $v0, ($sp)
add $sp, $sp, -4
