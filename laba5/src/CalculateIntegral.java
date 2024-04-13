import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CalculateIntegral implements Runnable {
    private DefaultTableModel tableModel;
    private JTable table;
    public CalculateIntegral(DefaultTableModel tableModel, JTable table){
        this.tableModel = tableModel;
        this.table = table;
    }
    @Override
    public void run(){
        int selectedRow = table.getSelectedRow();
        double lowerLimit = Double.parseDouble(tableModel.getValueAt(selectedRow, 0).toString());
        double upperLimit = Double.parseDouble(tableModel.getValueAt(selectedRow, 1).toString());
        double step = Double.parseDouble(tableModel.getValueAt(selectedRow, 2).toString());

        double integralResult = IntegralCalculatorGUI.calculateIntegral(lowerLimit, upperLimit, step);
        if (selectedRow != -1) {
            tableModel.setValueAt(integralResult, selectedRow, 3);
        }
    }
}