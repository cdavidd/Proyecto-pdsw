package edu.eci.pdsw.view;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import static edu.eci.pdsw.samples.services.ServiciosBancoFactory.getInstance;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;
import org.primefaces.model.chart.DonutChartModel;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.*;
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
public class ChartView extends BasePageBean implements Serializable {
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosBanco servicioBanco;

    private PieChartModel pieModel;

    
    public void listar() throws ExcepcionServicesBanco{
        System.out.println(servicioBanco);
        getEstadisticas();
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
    
    public List<String[]> getEstadisticas(){
        try{
            return servicioBanco.getEstadisticas();
        }catch(ExcepcionServicesBanco e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    

}
