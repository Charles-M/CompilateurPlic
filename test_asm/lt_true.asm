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
blt $t8, $v0, lower1712811212
li $v0,0
b continue1712811212

lower1712811212:
li $v0,1

continue1712811212:
sw $v0, ($sp)
add $sp, $sp, -4
