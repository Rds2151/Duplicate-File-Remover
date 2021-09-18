package Store;
import java.io.File;

class Node
{
	public long Data;
	public String Path;
	public Node lchild;
	public Node rchild;
	
	public Node(long iValue,String Path)
	{
		this.Data = iValue;
		this.Path = Path;
		this.lchild = null;
		this.rchild = null;
	}
}

public class CkSumStore
{
	private Node First;
	
	public CkSumStore()
	{
		First = null;
	}
	
	public boolean find(long iValue,String FileName)
	{
		Node newn = new Node(iValue,FileName);
		boolean bRet = false;
		if(First == null)
		{
			First = newn;
		}
		else
		{
			Node temp = First;
			while(true)
			{
				if(((temp.Data == iValue) && (temp.Path != FileName)))
				{
					bRet = DeleteFile(FileName);
					break;
				}
				if((temp.Data > iValue) && (temp.Path != FileName))
				{
					if(temp.rchild == null)
					{
						temp.rchild = newn;
						break;				
					}
					temp = temp.rchild;
				}
				else if((temp.Data < iValue) && (temp.Path != FileName))
				{
					if(temp.lchild == null)
					{
						temp.lchild = newn;
						break;
					}
					temp = temp.lchild;
				}
			}
		}
		return bRet;
	}
	
	
	private boolean DeleteFile(String FileName)
	{
		File file = new File(FileName);
		if(file.delete())
		{
			System.out.println("File Deleted successfully : "+file.getName());
			return true;
		}
		else
		{
			System.out.println("Failed to delete "+file.getName());
			return false;
		}
	}
}
