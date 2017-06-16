import java.util.ArrayList;

public class ManageAccount {

	public static ArrayList<Account> mAccount = new ArrayList<Account>();
	
	public static void createAccount(Account account) 
	{
		mAccount.add(account);
		System.out.println(account.account);
		System.out.println(account.password);
		System.out.println(account.email);
	}
	
	//取得Account, password, email資料
	public static Account getAccountData(int i) 
	{
		return mAccount.get(i);
	}
	
	//取得資料數量
	public static int getAccountDataSize() 
	{
		return mAccount.size();
	}
	
	//比較Account, password, email正確性
	//Account比較
	public static boolean IsAccountValid(String account)
	{
		if (account == null) 
		{
			return false;
		}
		else
		{
			//比較是否有相同帳號
			for(int i = 0;i < mAccount.size(); i++)
			{
				if(account.matches(mAccount.get(i).account))
				{
					return false;
				}
			}
			/*
			 * 比較是否符合規範
			 * 
			 * 可包含英文或數字的字元以及底線「_」字元。
			 * 必須要以英文字元為開頭。
			 * 字元長度在8到30之間(包含8和30)
			 * 
			 * */
			String accountPattern = "\\A[a-zA-Z](\\w){7,29}\\z";
			
			return account.matches(accountPattern);

		}
		
	}

	//Password比較
	public static boolean IsPasswordValid(String password)
	{
		if (password == null) 
		{
			return false;
		}
		else
		{
			/*
			 * 比較是否符合規範
			 * 
			 * 密碼長度在 6-30 字元內，且只能包含數字、英文字
			 * 
			 * */
			
			String passwordPattern = "^(?=.*[a-zA-Z]+)(?=.*\\d+)[a-zA-Z0-9]{6,16}$";

			return password.matches(passwordPattern);
		}
	}
	
	//Email比較
	public static boolean IsEmailValid(String email) 
	{
		if (email == null) 
		{
			return false;
		}
		else
		{
			//比較是否有相同信箱
			for(int i = 0;i < mAccount.size(); i++)
			{
				if(email.matches(mAccount.get(i).email))
				{
					return false;
				}
			}
			
			String emailPattern = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

			return email.matches(emailPattern);
		}
		
	}
	
}