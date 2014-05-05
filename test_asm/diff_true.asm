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
bne $t8, $v0, non_equal199752049
li $v0,0
b continue199752049

non_equal199752049:
li $v0,1

continue199752049:
sw $v0, ($sp)
add $sp, $sp, -4
