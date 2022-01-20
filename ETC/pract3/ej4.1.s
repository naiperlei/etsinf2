		  .globl __start
          .text 0x00400000
		  
__start:  li $s0,11
		  li $a2, 0
		  li $v0,5
		  syscall#read_int
		  move $a1,$v0#guarda en $a1 el valor leido


OutputM:  move $a0,$a1
		  li $v0,1
		  syscall#print_int
		  
		  li $v0,11
		  li $a0, 'x'
		  syscall#print_char
		  
		  move $a0,$a2
		  li $v0,1
		  syscall
		  
		  li $v0,11
		  li $a0, '='
		  syscall
		  
		  mult $a1,$a2
		  mflo $a3
		  li $v0,1
		  move $a0,$a3
		  syscall
		  
		  li $v0,11
		  li $a0, '\n'
		  syscall

		  addi $a2,$a2,1
		  
		  j inter
		  
mientras: beq $a2,$s0,endwhile
		  j OutputM
inter:	  j mientras
		  
endwhile: li $v0,10 
		  syscall
		  
		  

		 
		  