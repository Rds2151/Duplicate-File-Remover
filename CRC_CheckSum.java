package CheckSum;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;
import Store.CkSumStore;

public class CRC_CheckSum
{
	FileInputStream instream = null;
	CkSumStore cobj = new CkSumStore();
	public static int iCnt = 0;
	
	public void cksum(String FilePath)
	{
		File directoryPath = null;
		File arr[] = null;
		
		try
		{
			directoryPath = new File(FilePath);
			arr = directoryPath.listFiles();
			for(File filename : arr)
			{
				CheckSum(filename.getAbsolutePath());
			}
			EmptyDir(FilePath);
		}
		catch(Exception obj)
		{
			System.out.println("The file is not present at given path");
		}
	}
	
	private void CheckSum(String FilePath)
	{
		long len = 0;
		int length = 0;	
		byte buffer[] = null; 	

		File FileName = new File(FilePath);
		try 
		{
			if(FileName.isFile())
			{
				CRC32 crc = new CRC32();
				len = FileName.length();
				if(len == 0)
				{
					FileName.delete();
					System.out.println("File Deleted successfully : "+FileName.getName());
					iCnt++;
				}
				else
				{
					buffer = new byte[(int)len];
					instream = new FileInputStream(FilePath);
					while((length = instream.read(buffer)) > 0)
					{
						crc.update(buffer);
						if(cobj.find(crc.getValue(),FilePath))
						{
							iCnt++;
						}
					}
					instream.close();
				}
			}
			else if(FileName.isDirectory())
			{
				cksum(FileName.toString());				
			}
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}
	
	private void EmptyDir(String FilePath)
	{
		File directoryPath = new File(FilePath);
		File arr[] = directoryPath.listFiles();

		try
		{
			if(directoryPath.length() == 0)
			{
				directoryPath.delete();
				System.out.println("Folder Deleted successfully : "+directoryPath.getName());
				iCnt++;
			}
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}
}
