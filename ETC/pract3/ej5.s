		  .globl __start
          .text 0x00400000
		  
__start:  li $v0,12
		  syscall
		  move $a1,$a0

		  li $v0,11
		  li $a0, '\n'
		  syscall
		  
		  li $v0,11
		  li $a0, '"'
		  syscall
		  		  
		  li $a2,10
		  beqz $a1,cero
		  beq $a1,$a2,diez
		  
		  move $a0,$a1
    	  li $v0,11
		  syscall
		  
fin:	  li $v0,11
		  li $a0, '"'
		  syscall
		  
		  li $v0,10
		  syscall
		  
cero:     li $v0,11
		  li $a0, '/'
		  syscall
		  
		  li $v0,11
		  li $a0, '0'
		  syscall
		  
		  j fin
		  
diez:     li $v0,11
		  li $a0, '/'
		  syscall
		  
		  li $v0,11
		  li $a0, 'n'
		  syscall
		  
		  j fin
		  