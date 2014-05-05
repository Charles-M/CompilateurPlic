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
blt $t8, $v0, lower480591464
li $v0,0
b continue480591464

lower480591464:
li $v0,1

continue480591464:
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 50
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 25
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 2
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
beq $t8, $v0, equal614739081
li $v0,0
b continue614739081

equal614739081:
li $v0,1

continue614739081:
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 0
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
bne $t8, $v0, non_equal375908650
li $v0,0
b continue375908650

non_equal375908650:
li $v0,1

continue375908650:
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
bgt $v0, 0, OR2147274723
li $v0,0
b continue2147274723

OR2147274723:
li $v0,1

continue2147274723:
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
bgt $v0, 0, AND783581626
li $v0,0
b continue783581626

AND783581626:
li $v0,1

continue783581626:
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
beq $v0, 0, XOR1286664778
li $v0,1
b continue1286664778

XOR1286664778:
li $v0,0

continue1286664778:
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 2
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
div $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 0
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
beq $t8, $v0, equal1962082203
li $v0,0
b continue1962082203

equal1962082203:
li $v0,1

continue1962082203:
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
beq $v0, 0, XOR2104186136
li $v0,1
b continue2104186136

XOR2104186136:
li $v0,0

continue2104186136:
sw $v0, ($sp)
add $sp, $sp, -4
