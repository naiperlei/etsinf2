		  .globl __start
          .text 0x00400000
__start:  jal Input
		  move $a2,$v0
		  
		  jal Input
          move $a1,$v0
		  move $v0,$a0
		  
		  bgez $a1, Pos
		  addi $a3,$zero,0xFFFFFFFF
		  #sub $a1,$zero,$a1
		  #sub $a0,$zero,$a0
		  mult $a3,$a2
		  mfhi $a2
		  mflo $a2
		  mult $a3,$a1
		  mfhi $a1
		  mflo $a1
		  
Pos:      jal Mult
		  move $a2,$v0
          
		  jal Output
          
		  li $v0,10
          syscall

Mult:     li $v0, 0
          beqz $a1, MultRet
MultFor:  add $v0, $v0, $a2
          addi $a1, $a1, -1
          bne $a1, $zero, MultFor
MultRet:  jr $ra

Input:    li $v0, 12
		  syscall
		  
		  li $v0, 11
		  li $a0, '='
		  syscall
		  
		  li $v0, 5
		  syscall
		  
		  jr $ra
Output:   li $v0, 12
		  syscall
		  
		  li $v0, 11
		  li $a0, '='
		  syscall
		  
		  move $a0,$a2
		  li $v0, 1
		  syscall
		  
		  li $v0, 11
		  li $a0, '\n'
		  syscall
		  
		  jr $ra