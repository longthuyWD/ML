/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package machine.learning;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import weka.core.Instances;
import static weka.core.SerializationHelper.write;
import static weka.core.SerializationHelper.read;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;

/**
 *
 * @author Long Thuy
 */
public class MyKnowledgeModel {
    DataSource source;  //
    Instances dataset;  //đối tượng thuộc lớp Instance lưu trữ dữ liệu
    String[] model_options;
    String[] data_options;
    Instances trainset;
    Instances testset;
    

    public MyKnowledgeModel() {
    }

    public MyKnowledgeModel(String filename) throws Exception { //thao tác file nên cần exception
        this.source = new DataSource(filename);     //lưu data đọc từ file 
        this.dataset = source.getDataSet();     //đọc dataset vào bộ nhớ và lưu vào biến
    }
    
    public MyKnowledgeModel(String filename, String m_otps, String d_opts ) throws Exception { //thao tác file nên cần exception
        this.source = new DataSource(filename);     //lưu data đọc từ file 
        this.dataset = source.getDataSet();     //đọc dataset vào bộ nhớ và lưu vào biến
        //không truyền options có thể báo lỗi đặt câu lệnh if để có thể truyền option = null
        if (m_otps != null){
            this.model_options = Utils.splitOptions(m_otps);      
        }
        if (d_opts != null){
            this.data_options = Utils.splitOptions(d_opts);
        }
    }
    


    public  void saveData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();    //tạo 1 đối tượng arff saver
        outData.setInstances(this.dataset);     //đưa dữ liệu dataset vào outData
        outData.setFile(new File(filename));    //set file tạo 1 đối tượng file và thêm exception
        outData.writeBatch();       //ghi dữ liệu ra file
        System.out.println("Finished");
    }
    
    public void saveData2CSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Finished");
    }
      
    //Chuyển đổi file CSV sang Arff
    public void CSV2Arff(String inFile, String outFile) throws IOException{
        //load file CSV
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(inFile));
        Instances data = loader.getDataSet();   //lấy đối tượng dữ liệu
        
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);//set dữ liệu ta muốn chuyển đổi
        
        //lưu dưới dạng arff
        saver.setFile(new File(outFile));       //tạo file để lưu
        saver.writeBatch();     //ghi dữ liệu ra file
    }
       
    //chia dữ liệu train test theo lớp RemovePercentage
    public Instances divideTrainTest(Instances originalSet,
            double percent, boolean isTest) throws Exception{
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(percent);      //thiết lập tỉ lệ
        rp.setInvertSelection(isTest);  // isTest là true là tạo testset, false là tạo train set
        rp.setInputFormat(originalSet); //set dữ liệu
        return Filter.useFilter(originalSet, rp);
    }
    
    public Instances divideTrainTestR(Instances originalSet,
            double percent, boolean isTest) throws Exception{
        Resample rs = new Resample();
        rs.setNoReplacement(true);      //luôn set là true
        rs.setSampleSizePercent(percent);   //set tỉ lệ train
        rs.setInvertSelection(isTest);  //train hoặc test
        rs.setInputFormat(originalSet); //set dữ liệu 
        return Filter.useFilter(originalSet, rs);   //loại bỏ theo resample để chia train test
        
    }
    
    public void saveModel(String filename, Object model) throws Exception{
        weka.core.SerializationHelper.write(filename,model);
    }
    
    public Object loadModel(String filename) throws Exception{
        return weka.core.SerializationHelper.read(filename);
    }
    
    //thông báo về giá trị thống kê của tập dữ liệu tải vào bộ nhớ này
    @Override
    public String toString() {
        return dataset.toSummaryString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
