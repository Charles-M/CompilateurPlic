#Initialisation
la $t7,($sp)
la $s7,($gp)

#Bloc
Class_test:
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
li $v0,0
sw $v0, ($gp)
add $gp, $gp, -4
