package demo;

import static com.mtsystems.coot.String8.cs8;
import static include.Stdio.fclose;
import static include.Stdio.fopen;
import static include.Stdio.fread_U;

import com.mtsystems.coot.Container;
import com.mtsystems.coot.ShortContainer;
import com.mtsystems.coot.String8;

import include.IoFile;

import java.util.Scanner;

public class DemoTranslation {
	public static void main(String[] args) {
		String8 filename = new String8(80);
		Container<IoFile> fp1;
		short pc = 0, sp = 0, ac = 0, ir;
		ShortContainer mem = new ShortContainer(4_096);
		filename.copyFrom(args[0] + ".mac");
		fp1 = fopen(filename, cs8("rb"));
		fread_U(mem, 2, 4_096, fp1);
		fclose(fp1);
		while(pc < 4_096) {
			ir = mem.get(pc);
			pc++;
			int opcode, address, din;
			address = ir & 0x0fff;
			opcode = ir & 0xf000;
			opcode = opcode >> 12;
			switch(opcode) {
			case 0:
				ac = mem.get(address);
				break;
			case 1:
				mem.set(address, ac);
				break;
			case 2:
				ac = (short)(ac + mem.get(address));
				break;
			case 3:
				ac = (short)(ac - mem.get(address));
				break;
			case 4:
				if(sp == 0) {
					sp = 4_096;
				}
				mem.set(--sp, ac);
				break;
			case 5:
				if(sp == 0) {
					sp = 4_096;
				}
				sp = (short)(sp - address);
				break;
			case 6:
				sp = (short)(sp + address);
				if(sp >= 4_096) {
					sp = (short)(sp - 4_096);
				}
				break;
			case 7:
				din = STDIN_SCANNER.nextInt();
				ac = (short)din;
				break;
			case 8:
				ac = (short)address;
				break;
			case 9:
				pc = (short)address;
				break;
			case 10:
				pc = mem.get(sp++);
				if(sp == 4_096) {
					sp = 0;
				}
				break;
			case 11:
				while(mem.get(ac) != 0) {
					System.out.print((char)Byte.toUnsignedInt((byte)mem.get(ac++)));
				}
				break;
			case 12:
				System.out.print(ac);
				break;
			case 13:
				if(ac != 0) {
					pc = (short)address;
				}
				break;
			case 14:
				mem.set(--sp, pc);
				pc = (short)address;
				break;
			case 15:
				System.exit(0);
			}
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}