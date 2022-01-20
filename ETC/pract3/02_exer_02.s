          .globl __start
          .text 0x00400000
__start:  jal Input

		  move $a2,$v0 #Se guarda en $a2 el valor del entero leído
		  
          jal Output
		  
		  li $v0, 11
          li $a0, 82 #R
		  syscall #print_char
		  
		  li $v0, 11
          li $a0, 61 #=
		  syscall #print_char
		  
          jal Mult
          move $a0,$v0
          li $v0,1
          syscall #print_integer, se imprime 1
          li $v0,10
          syscall #exit
Mult:     li $v0, 0
          beqz $a1, MultRet #Si $a1 = 0, saltar a MultRet
MultFor:  add $v0, $v0, $a2
          addi $a1, $a1, -1
          bne $a1, $zero, MultFor #Si $a1 es diferente de 0, saltar a MultFor
MultRet:  jr $ra


Input:    li $v0, 11
          li $a0, 77 #M
		  syscall #print_char
		  
		  li $v0, 11
          li $a0, 61 #=
		  syscall #print_char
		  
		  li $v0,5
          syscall #read_integer
		  
		  jr $ra
		  
Output:   li $v0, 11
          li $a0, 81 #Q
		  syscall #print_char
		  
		  li $v0, 11
          li $a0, 61 #=
		  syscall #print_char
		  
		  li $v0,5 
          syscall #read_integer
          move $a1,$v0 #Se guarda en $a1 el valor del entero leído
		  
		  li $v0, 11
          li $a0, 10 #\n
		  syscall #print_char
		  
		  jr $ra
		  
		  