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


          //đổi CSV sang arff
//        MyKnowledgeModel model = new MyKnowledgeModel();
//        model.CSV2Arff("E:\\ML\\bongda.csv", "E:\\ML\\bongda.arff");



//        Dữ liệu iris 
//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Users\\Long Thuy\\Downloads\\iris.arff",
//                                    "-C 0.25 -M 2",null);
//        model.saveData2CSV("C:\\Users\\Long Thuy\\Downloads\\iris.csv") ; 
//        model.buildDecisionTree();
//        System.out.println(model);
//        model.saveModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model", model.tree);
//        model.tree = (J48) model.loadModel("C:\\Users\\Long Thuy\\Downloads\\decisiontree.model");
//        model.predictClassLabel(model.testset);
                

//        Du lieu bong da chung
        MyDecisionTreeModel model = new MyDecisionTreeModel("E:\\ML\\bongda.arff",
                                    "-C 0.25 -M 2",null);



//          Du lieu bong da train va test
//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Users\\Long Thuy\\Downloads\\iris.arff","C:\\Users\\Long Thuy\\Downloads\\iris_test.arff",
//                                    "-C 0.25 -M 2",null);
//        model.buildDecisionTree2();
//
//
//
        model.buildDecisionTree1();
        System.out.println(model);
        model.saveModel("E:\\ML\\decisiontree.model", model.tree);
        model.tree = (J48) model.loadModel("E:\\ML\\decisiontree.model");
//        System.out.println(model.trainset);
        System.out.println(model.testset.numInstances());
        
        model.predictClassLabel(model.testset);
//        
      
        
        
          
    }
    
}
