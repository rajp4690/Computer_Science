/*
Raj Patel
N03555681
Computer System
mys.java (JAVA)
*/
import java.io.*;
import java.nio.channels.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
class mys {

  public static void main(String arg[]) throws IOException{

   FileChannel fc = (FileChannel) Files.newByteChannel(Paths.get(arg[0] +".mac"), StandardOpenOption.READ);
   ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
   byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
   fc.read(byteBuffer);
   byteBuffer.position(0);

   Buffer buffer = byteBuffer.asShortBuffer();
   short[] memory = new short[4096];
   ((ShortBuffer)buffer).get(memory);

   short pc=0,sp=0,ac=0,ir;              // Creating registers

   while(true){
     ir = memory[pc];
     pc++;                               // Increment PC register by 1

     int opCode,address;

     opCode = ir & 0XF000;               // Seperate opCode from instruction
     address = ir & 0X0FFF;              // Seperate address from instruction

     opCode = opCode >> 12;              // Shifting opCode to left
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
         Scanner s = new Scanner(System.in);
         ac = s.nextShort();
         break;

       case 0x0008 :                     // Ldc instruction
         ac = (short)address;
         break;

       case 0X0009 :                     // Ja instruction
         pc = (short)address;
         break;

       case 0X000A :                     // Ret instruction
         pc = memory[sp++];
         break;

       case 0X000B :                     // Sout instruction
         while(memory[ac] != 0)
           System.out.printf("%c",memory[ac++]);
         break;

       case 0X000C :                     // Dout instruction
         System.out.printf("%d", ac);
         break;

       case 0X000D :                     // Jnz instruction
         if(ac != 0)
           pc = (short)address;
         break;

       case 0X000E :                     // Call instruction
         memory[--sp] = pc;
         pc = (short)address;
         break;

       case 0X000F :                     // Halt instruction
         System.exit(0);

     }
   }

  }
}
