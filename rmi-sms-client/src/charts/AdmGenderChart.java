package charts;

import com.sms.api.entity.Admin;
import com.sms.api.services.Services;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class AdmGenderChart extends Application{
	
	private Services services;
	

	@Override
	public void start(Stage stage) throws Exception {
		try {
            Registry registry = LocateRegistry.getRegistry("localhost", 6710);
            services = (Services) registry.lookup("service");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		final SwingNode admGenderChartSwingNode = new SwingNode();
		admGenderChartSwingNode.setContent(
                new ChartPanel(
                        generatePieChart1()
                )
        );


        stage.setScene(
                new Scene(
                        new StackPane(
                        		admGenderChartSwingNode    
                        )
                      
                )
        );

        stage.show();
	}
		
		public Services getServices(){
			return services;
	        }

	    private JFreeChart generatePieChart1() throws RemoteException {
	        DefaultPieDataset dataSet = new DefaultPieDataset();
	        int m =0;
	        int f=0;
	        List<Admin> list = services.getAllAdmin();
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).getGender().equals("Male")) {
					m++;
				}else if (list.get(i).getGender().equals("Female")) {
					f++;
				}
	        }
	        
	        dataSet.setValue("Male", m);
	        dataSet.setValue("Female", f);

	        return ChartFactory.createPieChart(
	                "Admins", dataSet, true, true, false
	        );
	    }
		
	    public static void main(String[] args) {
	        launch(args);
	    }

}
