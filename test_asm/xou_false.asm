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
beq $t8, $v0, equal249986066
li $v0,0
b continue249986066

equal249986066:
li $v0,1

continue249986066:
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
blt $t8, $v0, lower1037797730
li $v0,0
b continue1037797730

lower1037797730:
li $v0,1

continue1037797730:
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
beq $v0, 0, XOR404267176
li $v0,1
b continue404267176

XOR404267176:
li $v0,0

continue404267176:
sw $v0, ($sp)
add $sp, $sp, -4
