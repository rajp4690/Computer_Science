/* Raj Patel
   N03555681
   Computer System
   mys.c
*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(int arg, char *argv[]){

  char buf[120];                        // Create buffer
  strcpy(buf, argv[1]);                 // Copy file name to buffer
  strcat(buf,".mac");                   // Concat '.mac' with file name

  FILE *fPointer;

  fPointer = fopen(buf ,"rb");          // Read file in binary

  short memory[4096];                   // Creating main memory

  fread(memory, 2, 4096, fPointer);


  short pc=0,sp=0,ac=0,ir;              // Creating registers

  while(1){
    ir = memory[pc];
    pc++;                               // Increment PC register by 1
  //  printf("%hd\n", ir);
    int opCode,address;

    opCode = ir & 0XF000;               // Seperate opCode from instruction
    address = ir & 0X0FFF;              // Seperate address from instruction

    opCode = opCode >> 12;              // Shifting opCode to left
    //printf("%d  %d\n", opCode, address);
    switch(opCode){

      case 0X0000 :                     // Load instruction
        ac = memory[address];
        break;

      case 0X0001 :                     // Store instruction
        memory[address] = ac;
        break;

      case 0X0002 :                     // Add instruction
        ac += memory[address];
        break;

      case 0X0003 :                     // Sub instruction
        ac -= memory[address];
        break;

      case 0X0004 :                     // Push instruction
        if (sp == 0)
          sp = 4096;
        memory[--sp] = ac;
        break;

      case 0X0005 :                     // Aloc instruction
        if(sp == 0)
          sp = 4095;
        sp -= address;
        break;

      case 0X0006 :                     // Dloc instruction
        sp += address;
        if(sp >= 4096)
          sp -= 4096;
        break;

      case 0X0007 :                     // Din instruction
        scanf("%hd", &ac);
        break;

      case 0x0008 :                     // Ldc instruction
        ac = address;
        break;

      case 0X0009 :                     // Ja instruction
        pc = address;
        break;

      case 0X000A :                     // Ret instruction
        pc = memory[sp++];
        break;

      case 0X000B :                     // Sout instruction
        while(memory[ac] != 0)
          printf("%c",memory[ac++]);
        break;

      case 0X000C :                     // Dout instruction
        printf("%d", ac);
        break;

      case 0X000D :                     // Jnz instruction
        if(ac != 0)
          pc = address;
        break;

      case 0X000E :                     // Call instruction
        memory[--sp] = pc;
        pc = address;
        break;

      case 0X000F :                     // Halt instruction
        exit(0);

    }
  }
}
