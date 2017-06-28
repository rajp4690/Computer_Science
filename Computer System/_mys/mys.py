"""
Raj Patel
N03555681
Computer System
mys.py (Python)
"""
import sys

temp = [None] * 4096
memory= [None] * 4096
binary_file = open(sys.argv[1] + ".mac", "rb")
binary_file.seek(0)
temp[0] = binary_file.read(2)
memory[0] = int.from_bytes(temp[0], byteorder='little', signed = True)
i = 1
while (temp[i-1] != b''):
    temp[i] = binary_file.read(2)
    memory[i] = int.from_bytes(temp[i], byteorder='little', signed = True)
    i += 1

pc = sp = ac = 0

while(1):
    ir = memory[pc]
    pc += 1

    opCode = ir & 0xF000
    address = ir & 0x0FFF
    opCode = opCode >> 12

    if opCode == 0 :                     # Load instruction
        ac = memory[address]

    elif opCode == 1 :                   # Store instruction
        memory[address] = ac

    elif opCode == 2 :                   # Add instruction
        ac += memory[address]

    elif opCode == 3 :                   # Sub instruction
        ac -= memory[address]

    elif opCode == 4 :                   # Push instruction
        if sp == 0 :
            sp = 4096
        sp -= 1
        memory[sp] = ac

    elif opCode == 5 :                   # Aloc instruction
        if sp == 0 :
            sp = 4095
        sp -= address

    elif opCode == 6 :                   # Dloc instruction
        sp += address
        if sp >= 4096 :
            sp -= 4096

    elif opCode == 7 :                   # Din instruction
        ac = int(input())

    elif opCode == 8 :                   # Ldc instruction
        ac = address

    elif opCode == 9 :                   # Ja instruction
        pc = address

    elif opCode == 10 :                   # Ret instruction
        pc = memory[sp]
        sp += 1

    elif opCode == 11 :                   # Sout instruction
        while(memory[ac] != 0):
            print(chr(memory[ac]), end = "")
            ac += 1

    elif opCode == 12 :                   # Dout instruction
        print(ac,end = "")

    elif opCode == 13 :                   # Jnz instruction
        if ac != 0:
            pc = address

    elif opCode == 14 :                   # Call instruction
        sp -= 1
        memory[sp] = pc
        pc = address

    elif opCode == 15 :                   # Halt instruction
        exit(0)
