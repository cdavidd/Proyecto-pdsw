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
import org.primefaces.model.chart.AxisType;
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

    private  BarChartModel pieModel;
    private  PieChartModel pieMode2;
    private  HashMap<String,Integer> pd;
    public void listar() throws ExcepcionServicesBanco{
        List<String[]> e=getEstadisticas();
        HashMap<String,Integer>l=new HashMap<>();
        for (int i=0;i<e.size();i++){
           l.put(e.get(i)[0], Integer.parseInt(e.get(i)[1]));
        }
        pd=l;
        graficar(l);
        graficar2(l);
    }
    public void graficar(HashMap<String,Integer> h){
        pieModel=new  BarChartModel();
        ChartSeries b = new ChartSeries();
        b.setLabel("Areas");
        for(Map.Entry<String, Integer> entry :h.entrySet()){
            b.set(entry.getKey(), entry.getValue());
            System.out.print(entry.getKey());
        }
         pieModel.addSeries(b);
        Axis xAxis = pieModel.getAxis(AxisType.X);
        xAxis.setLabel("Areas");
 
        Axis yAxis = pieModel.getAxis(AxisType.Y);
        yAxis.setLabel("numero Iniciativas");
        yAxis.setMin(0);
        yAxis.setMax(20);
        
    }
    public void graficar2(HashMap<String,Integer> h){
       pieMode2=new PieChartModel();
       for(Map.Entry<String, Integer> entry :h.entrySet()){
            pieMode2.set(entry.getKey(), entry.getValue());
        }
        pieMode2.setTitle("Iniciativas por Areas");
        pieMode2.setLegendPosition("e");
        pieMode2.setFill(false);
        pieMode2.setShowDataLabels(true);
        pieMode2.setDiameter(150);
        pieMode2.setShadow(false);
    }

    public HashMap<String, Integer> getPd() {
        return pd;
    }

    public PieChartModel getPieMode2() {
        return pieMode2;
    }

    public void setPieMode2(PieChartModel pieMode2) {
        this.pieMode2 = pieMode2;
    }
    

    public  BarChartModel getPieModel() {
        System.out.println("entro");
        return pieModel;
    }

    public void setPieModel( BarChartModel pieModel) {
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