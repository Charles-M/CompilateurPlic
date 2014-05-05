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
beq $t8, $v0, equal672485061
li $v0,0
b continue672485061

equal672485061:
li $v0,1

continue672485061:
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
blt $t8, $v0, lower249986066
li $v0,0
b continue249986066

lower249986066:
li $v0,1

continue249986066:
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
bgt $v0, 0, AND1037797730
li $v0,0
b continue1037797730

AND1037797730:
li $v0,1

continue1037797730:
sw $v0, ($sp)
add $sp, $sp, -4
