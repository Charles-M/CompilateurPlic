li $v0, 1
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 7
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
add $v0, $t8, $v0
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
blt $t8, $v0, lower738225560
li $v0,0
b continue738225560

lower738225560:
li $v0,1

continue738225560:
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 3
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 2
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
blt $t8, $v0, lower1343958201
li $v0,0
b continue1343958201

lower1343958201:
li $v0,1

continue1343958201:
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
bgt $v0, 0, OR672485061
li $v0,0
b continue672485061

OR672485061:
li $v0,1

continue672485061:
sw $v0, ($sp)
add $sp, $sp, -4
