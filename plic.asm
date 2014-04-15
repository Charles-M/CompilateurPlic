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
bgt $t8, $v0, greater288327032
li $v0,0
b continue288327032

greater288327032:
li $v0,1

continue288327032:
sw $v0, ($sp)
add $sp, $sp, -4

li $v0, 4
sw $v0, ($sp)
add $sp, $sp, -4
li $v0, 5
sw $v0, ($sp)
add $sp, $sp, -4
add $sp, $sp, 4
lw $v0, ($sp)
add $sp, $sp, 4
lw $t8, ($sp)
bgt $t8, $v0, greater1189319192
li $v0,0
b continue1189319192

greater1189319192:
li $v0,1

continue1189319192:
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
bgt $v0, 0, OR109873668
li $v0,0
b continue109873668

OR109873668:
li $v0,1

continue109873668:
sw $v0, ($sp)
add $sp, $sp, -4
