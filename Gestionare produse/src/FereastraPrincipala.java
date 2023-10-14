import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FereastraPrincipala extends JFrame{
	private JTextField codField;
	private JTextField denumireField;
	private JTextField pretField;
	JCheckBox chckbxNewCheckBox;
	JCheckBox discountBox;
	JList list = new JList();
	JList list2 = new JList();
	
	ArrayList<Produs> listOfProducts = new ArrayList<Produs>();
	ArrayList<Produs> produseBandaList =new ArrayList<Produs>();
	public FereastraPrincipala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cumparaturi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(393, 43, 117, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel produsLabel = new JLabel("Cod produs");
		produsLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		produsLabel.setBounds(95, 127, 85, 13);
		getContentPane().add(produsLabel);
		
		JLabel denumireLabel = new JLabel("Denumire produs");
		denumireLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		denumireLabel.setBounds(298, 127, 96, 13);
		getContentPane().add(denumireLabel);
		
		JLabel pretLabel = new JLabel("Pret produs");
		pretLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pretLabel.setBounds(516, 127, 96, 13);
		getContentPane().add(pretLabel);
		
		JLabel glutenLabel = new JLabel("Gluten free");
		glutenLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		glutenLabel.setBounds(742, 127, 87, 13);
		getContentPane().add(glutenLabel);
		
		codField = new JTextField();
		codField.setBounds(95, 150, 96, 19);
		getContentPane().add(codField);
		codField.setColumns(10);
		
		denumireField = new JTextField();
		denumireField.setBounds(298, 150, 96, 19);
		getContentPane().add(denumireField);
		denumireField.setColumns(10);
		
		pretField = new JTextField();
		pretField.setBounds(516, 150, 96, 19);
		getContentPane().add(pretField);
		pretField.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Fara gluten");
		chckbxNewCheckBox.setBounds(736, 149, 93, 21);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton adaugaProdusButton = new JButton("Adauga produs in cos");
		adaugaProdusButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				int cod = Integer.parseInt(codField.getText());
				String denumire = denumireField.getText();
				double pret = Double.parseDouble(pretField.getText());
				boolean glutenFree = chckbxNewCheckBox.isSelected();
				
				Produs produs = new Produs(cod,denumire, pret,glutenFree);
				listOfProducts.add(produs);
				
				rewriteProductsList(listOfProducts,list);
			}
		});
		adaugaProdusButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		adaugaProdusButton.setBounds(168, 202, 151, 37);
		getContentPane().add(adaugaProdusButton);
		
		JButton StergeProdusButton = new JButton("Sterge produs din cos");
        StergeProdusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userInput = JOptionPane.showInputDialog(null, "Introduceti codul produsului care sa fie sters");
				int cod = Integer.parseInt(userInput);
				
				Produs productToBeDeleted = null;
				for(Produs produs : listOfProducts)
				{
					if(produs.getCod() == cod)
						productToBeDeleted = produs;
				}
				
				if(productToBeDeleted == null)
				{
					JOptionPane.showMessageDialog(null, "Produsul cu codul " + userInput + " nu a fost gasit!");
				}
				else {
					listOfProducts.remove(productToBeDeleted);
					JOptionPane.showMessageDialog(null, "Produsul cu codul " + userInput + " a fost sters!");
					rewriteProductsList(listOfProducts,list);
				}
			}
		});	
        
        
       // JButton StergeProdusButton = new JButton("Sterge produs din cos");
       // StergeProdusButton.addActionListener(new ActionListener() {
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
			//	// TODO Auto-generated method stub
			//try	
       // String userInput = JOptionPane.showInputDialog(null, "Introduceti codul produsului care sa fie sters");
			//	int cod = Integer.parseInt(userInput);
				
				//Produs productToBeDeleted = null;
				//for(Produs produs : listOfProducts)
				//{
				//	if(produs.getCod() == cod)
				//		productToBeDeleted = produs;
				//}
				
				//if(productToBeDeleted == null)
				//{
				//	JOptionPane.showMessageDialog(null, "Produsul cu codul " + userInput + " nu a fost gasit!");
				//}
				//else {
				//	listOfProducts.remove(productToBeDeleted);
			//		JOptionPane.showMessageDialog(null, "Produsul cu codul " + userInput + " a fost sters!");
			//		rewriteProductsList(listOfProducts,list);
			//	}
		//}
	//	});	
             
		StergeProdusButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StergeProdusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StergeProdusButton.setBounds(536, 202, 151, 37);
		getContentPane().add(StergeProdusButton);
		
		JLabel cosLabel = new JLabel("Cos de cumparaturi");
		cosLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		cosLabel.setBounds(393, 271, 130, 27);
		getContentPane().add(cosLabel);
		
		
		list.setBounds(25, 310, 837, 176);
		getContentPane().add(list);
		
		JLabel lblNewLabel_6 = new JLabel("Banda produse");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(25, 526, 96, 13);
		getContentPane().add(lblNewLabel_6);
		
		JButton bandaButton = new JButton("Pune produsul pe banda");
		bandaButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Produs produsMutat = (Produs)list.getSelectedValue();
			       if(produsMutat!=null)
			       {
			    	   if(!produseBandaList.contains(produsMutat))
			    	   {
			    		   produseBandaList.add(produsMutat);
			    		   rewriteProductsList(produseBandaList,list2);
			    		   
			       }
			    	   
			    	   }
				}
			});
		bandaButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bandaButton.setBounds(168, 506, 183, 37);
		getContentPane().add(bandaButton);
		
		
		list2.setBounds(25, 552, 607, 155);
		getContentPane().add(list2);
		
		JButton totalCosButton = new JButton("Total cos");
		totalCosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double suma = 0;
                for (Produs produs : listOfProducts) {
                    suma = suma + produs.getPret();
                }

                JOptionPane.showMessageDialog(null, "Cosul de cumparaturi costa " + suma,"Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		totalCosButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		totalCosButton.setBounds(667, 506, 93, 33);
		getContentPane().add(totalCosButton);
		
		JButton bandaTotalButton = new JButton("Total banda");
		bandaTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double suma = 0;
                double maxPret = 0;
                Produs produsDiscount = listOfProducts.get(0);
                if(discountBox.isSelected())
                {
                  
                    produsDiscount.setPret((double) (produsDiscount.getPret()*0.8));
                }

                for (Produs produs : listOfProducts) {
                    suma = suma + produs.getPret();
                }

                JOptionPane.showMessageDialog(null, "Banda de cumparaturi costa " + suma,"Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		bandaTotalButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bandaTotalButton.setBounds(667, 575, 130, 33);
		getContentPane().add(bandaTotalButton);
		
		discountBox = new JCheckBox("20% discount");
		discountBox.setBounds(667, 614, 117, 21);
		getContentPane().add(discountBox);
		
		this.setSize(900,770);
		this.setVisible(true);
	}
	
	public void rewriteProductsList(List<Produs> listOfProducts, JList list) {
		DefaultListModel listModel = new DefaultListModel();
		for(Produs p: listOfProducts) {
			listModel.addElement(p);
		}
		list.setModel(listModel);
	}
	
	public Produs cautaProdus(ArrayList<Produs>listOfProducts, int cod) throws ProdusNotFoundException
	{
	
		Produs productToBeDeleted = null;
		for(Produs produs : listOfProducts)
		{
			if(produs.getCod() == cod)
				productToBeDeleted = produs;
			else
			{
				throw new ProdusNotFoundException("Nu exista produsul cu acest cod");
				
			}	
		}
		 return productToBeDeleted;
		
	}
	
	
}
