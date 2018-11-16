package edu.eci.pdsw.view;


import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import static edu.eci.pdsw.samples.services.ServiciosBancoFactory.getInstance;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;
import org.primefaces.model.chart.DonutChartModel;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.chart.PieChart;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import static org.primefaces.model.chart.AxisType.X;
import static org.primefaces.model.chart.AxisType.Y;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name ="chartView")
@ViewScoped
public class ChartView implements Serializable {


    private PieChartModel pieModel;
    
    public ChartView() throws ExcepcionServicesBanco {

    }

    @PostConstruct
    public void init() {
        
    }
    public void listar(){
        HashMap<String,Integer>l=new HashMap<>();
        for (int i=0;i<10;i++){
           l.put(Integer.toString(i), i);
           System.out.print("entro");
        }
          System.out.print("entro");
        graficar(l);
    }
    public void graficar(HashMap<String,Integer> h){
        pieModel=new PieChartModel();
        for(Map.Entry<String, Integer> entry :h.entrySet()){
            pieModel.set(entry.getKey(), entry.getValue());
            System.out.print(entry.getKey());
        }
       
        pieModel.setTitle("PRUEB");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
        
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    

    

}