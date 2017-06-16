import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ForgotHelpGUI implements ActionListener{
	
    private JFrame ForgotHelpFrame;
    private String[] Forgotname;
    private JTextField ForgotAccountText = new JTextField();
    private JTextField EmailText = new JTextField();
    public ManageAccount ManageAccount = new ManageAccount();
    
    public ForgotHelpGUI() 
    {
        ForgotHelpFrame = new JFrame("密碼尋找頁面");
        String Forgotn[] = {"Account", 
                      "Email", 
                      "Get My Password",
                      "Back"};
        Forgotname = Forgotn;
    }
     
    public void ForgotHelprun() 
    {
        ForgotHelpFrame.setSize(600, 160);
        ForgotHelpFrame.setLayout(new GridBagLayout());
        ForgotHelpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Account
        JLabel AccountLabel = new JLabel(Forgotname[0]);
        GridBagConstraints AccountGrid = new GridBagConstraints();
        AccountGrid.gridx = 0;
        AccountGrid.gridy = 0;
        AccountGrid.gridwidth = 1;
        AccountGrid.gridheight = 1;
        AccountGrid.weightx = 0;
        AccountGrid.weighty = 0;
        AccountGrid.fill = GridBagConstraints.NONE;
        AccountGrid.anchor = GridBagConstraints.WEST;
        ForgotHelpFrame.add(AccountLabel, AccountGrid);
        
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
        ForgotHelpFrame.add(ForgotAccountText, AccountTextGrid);
        
        //Email
        JLabel EmailLabel = new JLabel(Forgotname[1]);
        GridBagConstraints EmailGrid = new GridBagConstraints();
        EmailGrid.gridx = 0;
        EmailGrid.gridy = 3;
        EmailGrid.gridwidth = 1;
        EmailGrid.gridheight = 1;
        EmailGrid.weightx = 0;
        EmailGrid.weighty = 0;
        EmailGrid.fill = GridBagConstraints.NONE;
        EmailGrid.anchor = GridBagConstraints.WEST;
        ForgotHelpFrame.add(EmailLabel, EmailGrid);
        
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
        ForgotHelpFrame.add(EmailText, EmailTextGrid);
        
        //Forgot Button
        JButton ForgotButton = new JButton(Forgotname[2]);
        GridBagConstraints ForgotButtonGrid = new GridBagConstraints();
        ForgotButtonGrid.gridx = 1;
        ForgotButtonGrid.gridy = 4;
        ForgotButtonGrid.gridwidth = 1;
        ForgotButtonGrid.gridheight = 1;
        ForgotButtonGrid.weightx = 0;
        ForgotButtonGrid.weighty = 0;
        ForgotButtonGrid.fill = GridBagConstraints.BOTH;
        ForgotButtonGrid.anchor = GridBagConstraints.CENTER;
        ForgotButton.addActionListener(this);
        ForgotHelpFrame.add(ForgotButton, ForgotButtonGrid);
        
        //Back Button
        JButton BackButton = new JButton(Forgotname[3]);
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
        ForgotHelpFrame.add(BackButton, BackButtonGrid);
         
        ForgotHelpFrame.setVisible(true);
    }

	public void ForgotHelpOpen() 
	{
		ForgotHelpFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "Get My Password")
		{
			if(ManageAccount.mAccount == null)
			{
				JOptionPane.showMessageDialog(ForgotHelpFrame,"尚未註冊的帳號","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
				ForgotAccountText.setText(null);
			}
			else
			{
				//拿取資料值
				String Account = new String(ForgotAccountText.getText());
				String Email = new String(EmailText.getText());
				
				for(int i = 0; i < ManageAccount.getAccountDataSize(); i++)
				{
					if((Account.matches(ManageAccount.getAccountData(i).account)) == true)
					{	
						if((Email.matches(ManageAccount.getAccountData(i).email)) == true)
						{
							JOptionPane.showMessageDialog(ForgotHelpFrame,"你的密碼為" + ManageAccount.getAccountData(i).password,"成功訊息",JOptionPane.INFORMATION_MESSAGE);
							ForgotAccountText.setText(null);
							EmailText.setText(null);
						}
					}
					else
					{
						if(Account.matches((ManageAccount.getAccountData(ManageAccount.getAccountDataSize()-1)).account) == false)
						{
							JOptionPane.showMessageDialog(ForgotHelpFrame,"尚未註冊的帳號","錯誤訊息",JOptionPane.INFORMATION_MESSAGE);
							ForgotAccountText.setText(null);
						}
					}
				}

			}
						
		}
		else if(e.getActionCommand() == "Back")
		{
			ForgotHelpFrame.setVisible(false);
		}
		
	}
}
