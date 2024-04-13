import javax.swing.table.DefaultTableModel;

public class CalculateIntegral implements Runnable {
    private final DefaultTableModel tableModel;
    private final int selectedRow;
    public CalculateIntegral(DefaultTableModel tableModel, int selectedRow){
        this.tableModel = tableModel;
        this.selectedRow = selectedRow;
    }
    @Override
    public void run(){
        double lowerLimit = Double.parseDouble(tableModel.getValueAt(selectedRow, 0).toString());
        double upperLimit = Double.parseDouble(tableModel.getValueAt(selectedRow, 1).toString());
        double step = Double.parseDouble(tableModel.getValueAt(selectedRow, 2).toString());

        double integralResult = IntegralCalculatorGUI.calculateIntegral(lowerLimit, upperLimit, step);
        if (selectedRow != -1) {
            tableModel.setValueAt(integralResult, selectedRow, 3);
        }
    }
}