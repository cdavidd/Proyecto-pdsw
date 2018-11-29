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
    private  BarChartModel pieMode3;
    private  PieChartModel pieMode4;
    private  HashMap<String,Integer> pd;
    private List<String[]> e;
    public void listar() throws ExcepcionServicesBanco{
        e=getEstadisticas();
        List<String[]> c=servicioBanco.getEstadisticasEstado();
        HashMap<String,Integer>l=new HashMap<>();
        HashMap<String,Integer>c2=new HashMap<>();
        for (int i=0;i<e.size();i++){
           l.put(e.get(i)[0], Integer.parseInt(e.get(i)[1]));
        }
        for (int i=0;i<c.size();i++){
            c2.put(c.get(i)[0], Integer.parseInt(c.get(i)[1]));
        }
        graficar(l);
        graficar2(l);
        graficar3(c2);
        graficar4(c2);
    }

    public void setE(List<String[]> e) {
        this.e = e;
    }

    public List<String[]> getE() {
        return e;
    }
    public void graficar(HashMap<String,Integer> h){
        pieModel=new  BarChartModel();
        ChartSeries b = new ChartSeries();
        b.setLabel("Areas");
        for(Map.Entry<String, Integer> entry :h.entrySet()){
            b.set(entry.getKey(), entry.getValue());
        }
         pieModel.addSeries(b);
        Axis xAxis = pieModel.getAxis(AxisType.X);
        xAxis.setLabel("Areas");
 
        Axis yAxis = pieModel.getAxis(AxisType.Y);
        yAxis.setLabel("numero Iniciativas");
        yAxis.setMin(0);
        yAxis.setMax(10);
        
    }
    public void graficar3(HashMap<String,Integer> h){
        pieMode3=new  BarChartModel();
        ChartSeries b = new ChartSeries();
        b.setLabel("Estados");
        for(Map.Entry<String, Integer> entry :h.entrySet()){
            b.set(entry.getKey(), entry.getValue());
        }
         pieMode3.addSeries(b);
        Axis xAxis = pieMode3.getAxis(AxisType.X);
        xAxis.setLabel("Estados");
 
        Axis yAxis = pieMode3.getAxis(AxisType.Y);
        yAxis.setLabel("Iniciativas Por Estado");
        yAxis.setMin(0);
        yAxis.setMax(20);
        
    }

    public void setPieMode3(BarChartModel pieMode3) {
        this.pieMode3 = pieMode3;
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
    public void graficar4(HashMap<String,Integer> h){
       pieMode4=new PieChartModel();
       for(Map.Entry<String, Integer> entry :h.entrySet()){
            pieMode4.set(entry.getKey(), entry.getValue());
        }
        pieMode4.setTitle("Iniciativas Por Estado");
        pieMode4.setLegendPosition("e");
        pieMode4.setFill(false);
        pieMode4.setShowDataLabels(true);
        pieMode4.setDiameter(150);
        pieMode4.setShadow(false);
    }

    public void setPieMode4(PieChartModel pieMode4) {
        this.pieMode4 = pieMode4;
    }

    public PieChartModel getPieMode4() {
        return pieMode4;
    }

    public HashMap<String, Integer> getPd() {
        return pd;
    }

    public BarChartModel getPieMode3() {
        return pieMode3;
    }

    public PieChartModel getPieMode2() {
        return pieMode2;
    }

    public void setPieMode2(PieChartModel pieMode2) {
        this.pieMode2 = pieMode2;
    }
    

    public  BarChartModel getPieModel() {
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