package GUI;

import javax.swing.JPanel;

import Model.MesController;

public class GUIStartMes extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIStartMes() {
		MesController mes = new MesController();
		mes.getActive();
	}

}
