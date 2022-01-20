                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "

                ##########################################################
                # Segmento de código
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
		li $a1, 0x00173b3b  #Hora 23:59:59
		jal init_reloj
		la $a0, reloj
		jal imprime_reloj

		la $a0, reloj
		jal pasa_segundo #Incrementa el reloj en un segundo
		jal pasa_segundo #Incrementa el reloj en un segundo

		la $a0, reloj
                jal imprime_reloj
             
salir:          li $v0, 10              # Código de exit (10)
                syscall                 # Última instrucción ejecutada
                .end


                ########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
                ########################################################## 

imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                la $a0, cad_horas       # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_minutos     # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_segundos    # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprime_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall


                la $a0, cad_reloj_en_s  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra
                
                ########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra

pasa_minuto: 	lbu $t1, 1($a0)		# $t1 = MM
		addiu $t1, $t1, 1	# $t1 = MM++
		li $t3, 60
		beq $t1, $t3, M60	# Si MM==60 se pone MM a cero
		sb $t1, 1($a0)		# Escribe MM++
		j fin_pasa_minuto
MM60:		sb $zero, 1($a0)	# Escribe MM a 0
		j pasa_hora		# Por lo que incrementa una hora y hay que ir a pasa_hora
fin_pasa_minuto:jr $ra

pasa_segundo:	lbu $t2, 0($a0)		# $t2 = SS
		addiu $t2, $t2, 1	# $t2 = SS++
		li $t3, 60
		beq $t2, $t3, S60	# Si SS==60 se pone SS a cero
		sb $t2, 0($a0)		# Escribe SS++
		j fin_pasa_segundo
MM60:		sb $zero, 0($a0)	# Escribe SS a 0
		j pasa_minuto		# Por lo que incrementa un minuto y hay que ir a pasa_minuto
fin_pasa_segundo:jr $ra

ej1:            sll $v0, $a0, 5  # $v0 = $a0*2^5
		sll $t0, $a0, 2  # $t0 = $a0*2^2
		addu $v0, $v0, $t0 # $v0 = $a0*(2^5+2^2)

ej2:		lb $t0, 0($a0)
		lb $t1, 1($a0)
		lb $t2, 2($a0)
		sll $v0, $t2, 5
		sll $t3, $t2, 4
		addu $v0, $v0, $t3
		sll $t3, $t2, 3
		addu $v0, $v0, $t3
		sll $t3, $t2, 2
		addu $v0, $v0, $t3
		addu $v0, $v0, $t1
		addu $t2, $v0, $t1
		sll $v0, $t2, 5
		sll $t3, $t2, 4
		addu $v0, $v0, $t3
		sll $t3, $t2, 3
		addu $v0, $v0, $t3
		sll $t3, $t2, 2
		addu $v0, $v0, $t3
		addu $v0, $v0, $t0
		jr $ra
	
ej3:		sll $v0, $a0, 5 # $v0 = $a0*2^5
		sub $v0, $v0, $a0 # $v0 = $v0 - ($a0*2^0)

ej4:		lb $t0, 0($a0)
		lb $t1, 1($a0)
		lb $t2, 2($a0)
		sll $v0, $t2, 6
		sll $t2, $t2, 2
		sub $v0, $v0, $t2
		addu $v0, $v0, $t1
		addu $t2, $v0, $t1
		sll $v0, $t2, 6
		sll $t2, $t2, 2
		sub $v0, $v0, $t2
		addu $v0, $v0, $t0
		jr $ra