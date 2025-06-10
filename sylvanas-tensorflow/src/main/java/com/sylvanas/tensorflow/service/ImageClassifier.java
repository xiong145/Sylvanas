//package com.sylvanas.tensorflow.service;
//
//
//import org.tensorflow.Graph;
//import org.tensorflow.Session;
//import org.tensorflow.Tensor;
//import org.tensorflow.Tensors;
//import org.tensorflow.ndarray.buffer.ByteBuffer;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class ImageClassifier {
//    private byte[] modelData;
//
//    public ImageClassifier(String modelPath) throws IOException {
//        // 加载模型文件
//        this.modelData = Files.readAllBytes(Paths.get(modelPath));
//    }
//
//    public String classifyImage(byte[] imageBytes) {
//        try (Graph graph = new Graph()) {
//            // 导入计算图
//            graph.importGraphDef(modelData);
//            try (Session session = new Session(graph)) {
//                // 输入数据处理（假设是预处理后的图像数据）
//                Tensor<Float> inputTensor = Tensors.create(new float[][]{{1.0f, 2.0f, 3.0f}}); // 示例输入
//
//                // 执行推理
//                Tensor<?> outputTensor = session.runner()
//                        .feed("input", inputTensor)
//                        .fetch("output")
//                        .run()
//                        .get(0);
//
//                // 输出结果解析
//                return outputTensor.toString();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            ImageClassifier classifier = new ImageClassifier("src/main/resources/model/model.pb");
//            byte[] imageData = new byte[0]; // 替换为实际图像数据读取逻辑
//            String result = classifier.classifyImage(imageData);
//            System.out.println("Classification Result: " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}