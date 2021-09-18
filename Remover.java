import java.io.*;
import java.util.*;
import CheckSum.CRC_CheckSum;

class Remover
{
	public static void main(String arg[])
	{
		Scanner sobj = new Scanner(System.in);
		boolean Run = true;
		
		while(Run)
		{
			System.out.println("1. Scan Folder\n0. Exit\n");
			System.out.println("Enter choice: ");
			int ch = sobj.nextInt();
		
			switch(ch)
			{
				case 1:
					System.out.println("Enter Folder Name: ");
					sobj.nextLine();
					String FolderName = sobj.nextLine();
					CRC_CheckSum checksum = new CRC_CheckSum();
					checksum.cksum(FolderName);
					System.out.println();
					break;
				case 0:
					Run = false;
					break;
				default:
					System.out.println("Invalid input");
			}
		}
		System.out.println("\nTotal Files/Folder deleted : "+CRC_CheckSum.iCnt);
	}
}
