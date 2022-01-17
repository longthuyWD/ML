/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package machine.learning;

import weka.classifiers.trees.J48;

/**
 *
 * @author Long Thuy
 */
public class MachineLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Để xuất nhập dữ liệu trên file cần exception
//        MyKnowledgeModel model1 = new MyKnowledgeModel("C:\\Users\\Long Thuy\\Downloads\\iris.arff");
//        System.out.println(model1);


//          đổi CSV sang arff
//        MyKnowledgeModel model = new MyKnowledgeModel();
//        model.CSV2Arff("C:\\Users\\Long Thuy\\Documents\\bongda_test.csv", "C:\\Users\\Long Thuy\\Documents\\bongda_test.arff");



//        MyKnowledgeModel model = new MyKnowledgeModel("C:\\Users\\Long Thuy\\Downloads\\labor.arff");
//        model.saveData2CSV("C:\\Users\\Long Thuy\\Downloads\\labor.csv");
    
//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Users\\Long Thuy\\Downloads\\iris.arff",
//                                    "-C 0.25 -M 2",null);
//        model.buildDecisionTree();
//        System.out.println(model);
//        model.saveModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model", model.tree);
//        model.tree = (J48) model.loadModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model");
//        model.predictClassLabel(model.testset);
                
        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Users\\Long Thuy\\Documents\\bongda.arff",
                                    "-C 0.25 -M 2",null);

//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Users\\Long Thuy\\Documents\\bongda.arff","C:\\Users\\Long Thuy\\Documents\\bongda_test.arff",
//                                    "-C 0.25 -M 2",null);
        model.buildDecisionTree();
        System.out.println(model);
        model.saveModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model", model.tree);
        model.tree = (J48) model.loadModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model");
//        System.out.println(model.trainset);
        
        model.predictClassLabel(model.testset);
        
        
        
        
          
    }
    
}
