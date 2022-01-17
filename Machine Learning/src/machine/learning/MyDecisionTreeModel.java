/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package machine.learning;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Long Thuy
 */
public class MyDecisionTreeModel extends MyKnowledgeModel{
    J48 tree;   //tạo cây
    DataSource source1;
    DataSource source2;
    
    public MyDecisionTreeModel(String filename, String m_otps, String d_opts) throws Exception {
        super(filename, m_otps, d_opts);
    }
    
//    public MyDecisionTreeModel(String filename1, String filename2, String m_otps, String d_opts ) throws Exception {
//        this.source1 = new DataSource(filename1);     //lưu data đọc từ file 
//        this.trainset = source1.getDataSet();     //đọc dataset vào bộ nhớ và lưu vào biến
//        this.source2 = new DataSource(filename2);     //lưu data đọc từ file 
//        this.testset = source2.getDataSet();     //đọc dataset vào bộ nhớ và lưu vào biến
//        if (m_otps != null){
//            this.model_options = Utils.splitOptions(m_otps);      
//        }
//        if (d_opts != null){
//            this.data_options = Utils.splitOptions(d_opts);
//        }
//    }

    public MyDecisionTreeModel(DataSource source1, DataSource source2) {
        this.source1 = source1;
        this.source2 = source2;
    }
    
    public  void buildDecisionTree() throws Exception{
        //Tao tap du lieu train test
        this.trainset = divideTrainTestR(this.dataset, 80, false);
        this.testset = divideTrainTestR(this.dataset, 80, true);
        System.out.println("so luong thuoc tinh " + (this.trainset.numAttributes()-1));
        this.trainset.setClassIndex(this.trainset.numAttributes()-1);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        
        //Thiết lâp thông số cho mô hình cây quyết định
        tree = new J48();
        tree.setOptions(this.model_options);
       
        
        //Huấn luyện mô hình với tập dữ liệu train 
        tree.buildClassifier(this.trainset);
    }
    
    
    public void predictClassLabel(Instances input) throws Exception{
        System.out.println(""+ input.numInstances());
        for (int i = 0; i < input.numInstances() ; i++){
            System.out.println("input " + input.instance(i));
            double predict = tree.classifyInstance(input.instance(i));
//            double actual = input.instance(i).classValue();
            System.out.println("Instance "+ i + ": predict = "+ input.classAttribute().value((int) predict));
          
//            input.instance(i).setClassValue(predict);
        }
    }

    @Override
    public String toString() {
        return tree.toSummaryString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
