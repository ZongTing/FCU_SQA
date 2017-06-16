import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginGUI implements ActionListener{
	
    private JFrame LoginFrame;
    private String[] Loginname;
    private JTextField LoginAccountText = new JTextField();
    private JPasswordField LoginPasswordText = new JPasswordField();
    private boolean isSignUpGUIOpen = false;
    private boolean isForgotHelpGUIOpen = false;
    public SignUpGUI SignUpData = new SignUpGUI();
    public ForgotHelpGUI ForgotHelpData = new ForgotHelpGUI();
    public ManageAccount ManageAccount = new ManageAccount();

    public LoginGUI() 
    {
        LoginFrame = new JFrame("會員登入頁面");
        String Loginn[] = {"Account", 
                      "Password", 
                      "Forgot your Password?", 
                      "Login", 
                      "SignUp"};
        Loginname = Loginn;
    }
     
    public void Loginrun() 
    {
        LoginFrame.setSize(600, 160);
        LoginFrame.setLayout(new GridBagLayout());
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Account
        JLabel AccountLabel = new JLabel(Loginname[0]);
        GridBagConstraints AccountGrid = new GridBagConstraints();
        AccountGrid.gridx = 0;
        AccountGrid.gridy = 0;
        AccountGrid.gridwidth = 1;
        AccountGrid.gridheight = 1;
        AccountGrid.weightx = 0;
        AccountGrid.weighty = 0;
        AccountGrid.fill = GridBagConstraints.NONE;
        AccountGrid.anchor = GridBagConstraints.WEST;
        LoginFrame.add(AccountLabel, AccountGrid);
        
        //Account Text
        GridBagConstraints AccountTextGrid = new GridBagConstraints();
        AccountTextGrid.gridx = 1;
        AccountTextGrid.gridy = 0;
        AccountTextGrid.gridwidth = 6;
        AccountTextGrid.gridheight = 1;
        AccountTextGrid.weightx = 0;
        AccountTextGrid.weighty = 0;
        AccountTextGrid.fill = GridBagConstraints.BOTH;
        AccountTextGrid.anchor = GridBagConstraints.WEST;
        LoginFrame.add(LoginAccountText, AccountTextGrid);
        
        //Password
        JLabel PasswordLabel = new JLabel(Loginname[1]);
        GridBagConstraints PasswordGrid = new GridBagConstraints();
        PasswordGrid.gridx = 0;
        PasswordGrid.gridy = 1;
        PasswordGrid.gridwidth = 1;
        PasswordGrid.gridheight = 1;
        PasswordGrid.weightx = 0;
        PasswordGrid.weighty = 0;
        PasswordGrid.fill = GridBagConstraints.NONE;
        PasswordGrid.anchor = GridBagConstraints.WEST;
        LoginFrame.add(PasswordLabel, PasswordGrid);
        
        //Password Text
        GridBagConstraints PasswordTextGrid = new GridBagConstraints();
        PasswordTextGrid.gridx = 1;
        PasswordTextGrid.gridy = 1;
        PasswordTextGrid.gridwidth = 6;
        PasswordTextGrid.gridheight = 1;
        PasswordTextGrid.weightx = 0;
        PasswordTextGrid.weighty = 0;
        PasswordTextGrid.fill = GridBagConstraints.BOTH;
        PasswordTextGrid.anchor = GridBagConstraints.WEST;
        LoginFrame.add(LoginPasswordText, PasswordTextGrid);
        
        //Forgot Password Button
        JButton ForgotPasswordButton = new JButton(Loginname[2]);
        ForgotPasswordButton.setToolTipText("按此尋找密碼");
        GridBagConstraints ForgotPasswordButtonGrid = new GridBagConstraints();
        ForgotPasswordButtonGrid.gridx = 1;
        ForgotPasswordButtonGrid.gridy = 3;
        ForgotPasswordButtonGrid.gridwidth = 5;
        ForgotPasswordButtonGrid.gridheight = 1;
        ForgotPasswordButtonGrid.weightx = 0;
        ForgotPasswordButtonGrid.weighty = 0;
        ForgotPasswordButtonGrid.fill = GridBagConstraints.BOTH;
        ForgotPasswordButtonGrid.anchor = GridBagConstraints.CENTER;
        ForgotPasswordButton.addActionListener(this);
        LoginFrame.add(ForgotPasswordButton, ForgotPasswordButtonGrid);
        
        //login Button
        JButton loginButton = new JButton(Loginname[3]);
        loginButton.setToolTipText("按此登入");
        GridBagConstraints loginButtonGrid = new GridBagConstraints();
        loginButtonGrid.gridx = 1;
        loginButtonGrid.gridy = 2;
        loginButtonGrid.gridwidth = 1;
        loginButtonGrid.gridheight = 1;
        loginButtonGrid.weightx = 0;
        loginButtonGrid.weighty = 0;
        loginButtonGrid.fill = GridBagConstraints.BOTH;
        loginButtonGrid.anchor = GridBagConstraints.WEST;
        loginButton.addActionListener(this);
        LoginFrame.add(loginButton, loginButtonGrid);
        
        
        //SignUp Button
        JButton SignUpButton = new JButton(Loginname[4]);
        SignUpButton.setToolTipText("按此註冊帳號");
        GridBagConstraints SignUpButtonGrid = new GridBagConstraints();
        SignUpButtonGrid.gridx = 2;
        SignUpButtonGrid.gridy = 2;
        SignUpButtonGrid.gridwidth = 1;
        SignUpButtonGrid.gridheight = 1;
        SignUpButtonGrid.weightx = 0;
        SignUpButtonGrid.weighty = 0;
        SignUpButtonGrid.fill = GridBagConstraints.BOTH;
        SignUpButtonGrid.anchor = GridBagConstraints.EAST;
        SignUpButton.addActionListener(this);
        LoginFrame.add(SignUpButton, SignUpButtonGrid);
         
        LoginFrame.setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Login")
		{
			//取得Account輸入值
			String Account = new String(LoginAccountText.getText());
			//取得Password輸入值
			String Password = new String(LoginPasswordText.getPassword());
			
			for(int i = 0; i < ManageAccount.getAccountDataSize(); i++)
			{
				if((Account.matches(ManageAccount.mAccount.get(i).account)) == true)
				{
					if((Password.matches(ManageAccount.getAccountData(i).password)) == true)
					{
						JOptionPane.showMessageDialog(LoginFrame, ManageAccount.getAccountData(i).account + "歡迎登入","登入訊息",JOptionPane.INFORMATION_MESSAGE);
						LoginAccountText.setText(null);
						LoginPasswordText.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(LoginFrame,"密碼輸入錯誤","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
						LoginPasswordText.setText(null);
					}
				}
				else
				{
					if(Account.matches((ManageAccount.getAccountData(ManageAccount.getAccountDataSize()-1)).account) == false)
					{
						JOptionPane.showMessageDialog(LoginFrame,"尚未註冊的帳號","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
						LoginAccountText.setText(null);
					}
				}
			}
			//資料清空
			Account = null;
			Password = null;
		}
		else if(e.getActionCommand() == "SignUp")
		{
			//清空資料欄
			LoginAccountText.setText(null);
			LoginPasswordText.setText(null);
			
			if(isSignUpGUIOpen == false)
			{
				SignUpData.SignUprun();
				isSignUpGUIOpen = true;
			}
			else
			{
				SignUpData.SignUpOpen();
			}
		}
		else if(e.getActionCommand() == "Forgot your Password?")
		{
			//清空資料欄
			LoginAccountText.setText(null);
			LoginPasswordText.setText(null);
			
			if(isForgotHelpGUIOpen == false)
			{
				ForgotHelpData.ForgotHelprun();
				isForgotHelpGUIOpen = true;
			}
			else
			{
				ForgotHelpData.ForgotHelpOpen();
			}
		}
		else
		{
			System.out.println("Unexpected Error.");
		} 	
	}
}