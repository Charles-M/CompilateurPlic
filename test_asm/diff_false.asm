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
bne $t8, $v0, non_equal26174005
li $v0,0
b continue26174005

non_equal26174005:
li $v0,1

continue26174005:
sw $v0, ($sp)
add $sp, $sp, -4
