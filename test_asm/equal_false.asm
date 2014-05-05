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
beq $t8, $v0, equal940129113
li $v0,0
b continue940129113

equal940129113:
li $v0,1

continue940129113:
sw $v0, ($sp)
add $sp, $sp, -4
