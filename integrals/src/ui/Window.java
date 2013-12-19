package ui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import calculate.Integral;
import expression.IntegralBuilder;
import expression.InvalidIntegralException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frmIntegraisDuplasE;
	private JTextField integral;
	private JTextField result;
	private JTextField firstUpperLimit;
	private JTextField firstLowerLimit;
	private JTextField secondUpperLimit;
	private JTextField secondLowerLimit;
	private JTextField thirdUpperLimit;
	private JTextField thirdLowerLimit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmIntegraisDuplasE.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIntegraisDuplasE = new JFrame();
		frmIntegraisDuplasE.setTitle("Integrais Duplas e Triplas");
		frmIntegraisDuplasE.setBounds(100, 100, 675, 366);
		frmIntegraisDuplasE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		integral = new JTextField();
		integral.setColumns(20);
		
		JButton btnNewButton = new JButton("Calcular Integral");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String integralStr = integral.getText();
				
				String firstUpperStr = firstUpperLimit.getText();
				String firstLowerStr = firstLowerLimit.getText();

				String secondUpperStr = secondUpperLimit.getText();
				String secondLowerStr = secondLowerLimit.getText();
				
				String thirdUpperStr = thirdUpperLimit.getText();
				String thirdLowerStr = thirdLowerLimit.getText();
				
				try {
					Integral asIntegral = IntegralBuilder.asIntegral(integralStr, firstUpperStr, firstLowerStr, secondUpperStr, secondLowerStr, thirdUpperStr, thirdLowerStr);
					double resultF = asIntegral.evaluate();
					result.setText(Double.toString(resultF));
				} catch (InvalidIntegralException e) {
				}
				
			}
		});
		
		JLabel lblResultado = new JLabel("Resultado:");
		
		result = new JTextField();
		result.setEnabled(false);
		result.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblLimiteSuperiorPrimeira = new JLabel("Limite Superior Primeira Integral:");
		
		JLabel lblLimiteSuperiorSegunda = new JLabel("Limite Superior Terceira Integral:");
		
		JLabel lblLimiteInferiorPrimeira = new JLabel("Limite Inferior Primeira Integral:");
		
		JLabel lblLimiteSuperiorSegunda_1 = new JLabel("Limite Superior Segunda Integral:");
		
		JLabel lblLimiteInferiorSegunda = new JLabel("Limite Inferior Segunda Integral:");
		
		JLabel lblLimiteInferiorTerceira = new JLabel("Limite Inferior Terceira Integral:");
		
		firstUpperLimit = new JTextField();
		firstUpperLimit.setColumns(10);
		
		firstLowerLimit = new JTextField();
		firstLowerLimit.setColumns(10);
		
		secondUpperLimit = new JTextField();
		secondUpperLimit.setColumns(10);
		
		secondLowerLimit = new JTextField();
		secondLowerLimit.setColumns(10);
		
		thirdUpperLimit = new JTextField();
		thirdUpperLimit.setColumns(10);
		
		thirdLowerLimit = new JTextField();
		thirdLowerLimit.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmIntegraisDuplasE.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(integral, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLimiteSuperiorPrimeira)
								.addComponent(lblLimiteInferiorPrimeira)
								.addComponent(lblLimiteSuperiorSegunda_1)
								.addComponent(lblLimiteInferiorSegunda)
								.addComponent(lblLimiteSuperiorSegunda)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLimiteInferiorTerceira)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(firstUpperLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(firstLowerLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(secondUpperLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(secondLowerLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(thirdUpperLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(thirdLowerLimit, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(207)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))))
					.addGap(48))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(203, Short.MAX_VALUE)
					.addComponent(lblResultado)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(result, 157, 157, 157)
					.addGap(237))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(integral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(firstUpperLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLimiteSuperiorPrimeira))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLimiteInferiorPrimeira)
						.addComponent(firstLowerLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLimiteSuperiorSegunda_1)
						.addComponent(secondUpperLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLimiteInferiorSegunda)
						.addComponent(secondLowerLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLimiteSuperiorSegunda)
						.addComponent(thirdUpperLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLimiteInferiorTerceira)
						.addComponent(thirdLowerLimit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResultado))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		frmIntegraisDuplasE.getContentPane().setLayout(groupLayout);
	}
}
