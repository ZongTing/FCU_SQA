import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class SignUpGUI implements ActionListener{

	private JFrame SignUpFrame;
    private String[] SignUpname;
    private JTextField SignUpAccountText = new JTextField();
    private JPasswordField SignUpPasswordText = new JPasswordField();
    private JPasswordField SignUpConfirmPasswordText = new JPasswordField();
    private JTextField SignUpEmailText = new JTextField();
    public ManageAccount ManageAccount = new ManageAccount();
		
    public SignUpGUI() 
    {
        SignUpFrame = new JFrame("會員註冊頁面");
        String n[] = {"Account", 
                      "Password", 
                      "Confirm Password",
                      "Email",
                      "Join us",
                      "Back"};
        SignUpname = n;
    }
     
    public void SignUprun() 
    {
        SignUpFrame.setSize(600, 160);
        SignUpFrame.setLayout(new GridBagLayout());
        SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Account
        JLabel AccountLabel = new JLabel(SignUpname[0]);
        GridBagConstraints AccountGrid = new GridBagConstraints();
        AccountGrid.gridx = 0;
        AccountGrid.gridy = 0;
        AccountGrid.gridwidth = 1;
        AccountGrid.gridheight = 1;
        AccountGrid.weightx = 0;
        AccountGrid.weighty = 0;
        AccountGrid.fill = GridBagConstraints.NONE;
        AccountGrid.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(AccountLabel, AccountGrid);
        
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
        SignUpFrame.add(SignUpAccountText, AccountTextGrid);
        
        //Password
        JLabel PasswordLabel = new JLabel(SignUpname[1]);
        GridBagConstraints PasswordGrid = new GridBagConstraints();
        PasswordGrid.gridx = 0;
        PasswordGrid.gridy = 1;
        PasswordGrid.gridwidth = 1;
        PasswordGrid.gridheight = 1;
        PasswordGrid.weightx = 0;
        PasswordGrid.weighty = 0;
        PasswordGrid.fill = GridBagConstraints.NONE;
        PasswordGrid.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(PasswordLabel, PasswordGrid);
        
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
        SignUpFrame.add(SignUpPasswordText, PasswordTextGrid);
        
        //Confirm Password
        JLabel ConfirmPasswordLabel = new JLabel(SignUpname[2]);
        GridBagConstraints ConfirmPassword = new GridBagConstraints();
        ConfirmPassword.gridx = 0;
        ConfirmPassword.gridy = 2;
        ConfirmPassword.gridwidth = 1;
        ConfirmPassword.gridheight = 1;
        ConfirmPassword.weightx = 0;
        ConfirmPassword.weighty = 0;
        ConfirmPassword.fill = GridBagConstraints.NONE;
        ConfirmPassword.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(ConfirmPasswordLabel, ConfirmPassword);
        
        //Confirm Password Text
        GridBagConstraints ConfirmPasswordTextGrid = new GridBagConstraints();
        ConfirmPasswordTextGrid.gridx = 1;
        ConfirmPasswordTextGrid.gridy = 2;
        ConfirmPasswordTextGrid.gridwidth = 6;
        ConfirmPasswordTextGrid.gridheight = 1;
        ConfirmPasswordTextGrid.weightx = 0;
        ConfirmPasswordTextGrid.weighty = 0;
        ConfirmPasswordTextGrid.fill = GridBagConstraints.BOTH;
        ConfirmPasswordTextGrid.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(SignUpConfirmPasswordText, ConfirmPasswordTextGrid);
        
        //Email
        JLabel EmailLabel = new JLabel(SignUpname[3]);
        GridBagConstraints EmailGrid = new GridBagConstraints();
        EmailGrid.gridx = 0;
        EmailGrid.gridy = 3;
        EmailGrid.gridwidth = 1;
        EmailGrid.gridheight = 1;
        EmailGrid.weightx = 0;
        EmailGrid.weighty = 0;
        EmailGrid.fill = GridBagConstraints.NONE;
        EmailGrid.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(EmailLabel, EmailGrid);
        
        //Email Text
        GridBagConstraints EmailTextGrid = new GridBagConstraints();
        EmailTextGrid.gridx = 1;
        EmailTextGrid.gridy = 3;
        EmailTextGrid.gridwidth = 6;
        EmailTextGrid.gridheight = 1;
        EmailTextGrid.weightx = 0;
        EmailTextGrid.weighty = 0;
        EmailTextGrid.fill = GridBagConstraints.BOTH;
        EmailTextGrid.anchor = GridBagConstraints.WEST;
        SignUpFrame.add(SignUpEmailText, EmailTextGrid);
        
        //Join Button
        JButton JoinButton = new JButton(SignUpname[4]);
        GridBagConstraints JoinButtonGrid = new GridBagConstraints();
        JoinButtonGrid.gridx = 1;
        JoinButtonGrid.gridy = 4;
        JoinButtonGrid.gridwidth = 1;
        JoinButtonGrid.gridheight = 1;
        JoinButtonGrid.weightx = 0;
        JoinButtonGrid.weighty = 0;
        JoinButtonGrid.fill = GridBagConstraints.BOTH;
        JoinButtonGrid.anchor = GridBagConstraints.WEST;
        JoinButton.addActionListener(this);
        SignUpFrame.add(JoinButton, JoinButtonGrid);
        
        //Back Button
        JButton BackButton = new JButton(SignUpname[5]);
        GridBagConstraints BackButtonGrid = new GridBagConstraints();
        BackButtonGrid.gridx = 2;
        BackButtonGrid.gridy = 4;
        BackButtonGrid.gridwidth = 1;
        BackButtonGrid.gridheight = 1;
        BackButtonGrid.weightx = 0;
        BackButtonGrid.weighty = 0;
        BackButtonGrid.fill = GridBagConstraints.BOTH;
        BackButtonGrid.anchor = GridBagConstraints.EAST;
        BackButton.addActionListener(this);
        SignUpFrame.add(BackButton, BackButtonGrid);
    
        SignUpFrame.setVisible(true);
    }
    
    public void SignUpOpen()
    {
    	SignUpFrame.setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Join us")
		{
			//拿取資料值
			String Account = new String(SignUpAccountText.getText());
			String Password = new String(SignUpPasswordText.getPassword());
			String ConfirmPassword = new String(SignUpConfirmPasswordText.getPassword());
			String Email = new String(SignUpEmailText.getText());
			
			//判斷帳號正確性
			if(ManageAccount.IsAccountValid(Account) == true)
			{
				//判斷密碼正確性
				if(ManageAccount.IsPasswordValid(Password) == true && Password.matches(ConfirmPassword) == true)
				{
					//判斷信箱正確性
					if(ManageAccount.IsEmailValid(Email) == true)
					{
						Account NewAccount = new Account(Account, Password, Email);
						ManageAccount.createAccount(NewAccount);
						//清空文字區
						SignUpAccountText.setText(null);
						SignUpPasswordText.setText(null);
						SignUpConfirmPasswordText.setText(null);
						SignUpEmailText.setText(null);
						//把變數歸零
						Account = null;
						Password = null;
						ConfirmPassword = null;
						Email = null;
						JOptionPane.showMessageDialog(SignUpFrame,"註冊成功!!\n您是第" + ManageAccount.getAccountDataSize()
																	+ "位註冊會員","歡迎加入",JOptionPane.INFORMATION_MESSAGE);
						
						//條件正確 關閉SignUpFrame
						SignUpFrame.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(SignUpFrame,"信箱重複或不符合規範","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
						SignUpEmailText.setText(null);
					}
				}
				else if(Password.matches(ConfirmPassword) == false)
				{
					JOptionPane.showMessageDialog(SignUpFrame,"密碼兩次輸入不相符","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
					SignUpConfirmPasswordText.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(SignUpFrame,"密碼不符合規範","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
					SignUpPasswordText.setText(null);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(SignUpFrame,"帳號重複或不符合規範","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
				SignUpAccountText.setText(null);
			}
		}
		else if(e.getActionCommand() == "Back")
		{
			SignUpFrame.setVisible(false);
		}
	}
}