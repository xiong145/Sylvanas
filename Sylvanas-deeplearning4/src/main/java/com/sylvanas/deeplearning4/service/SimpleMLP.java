package com.sylvanas.deeplearning4.service;

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.util.ModelSerializer;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.conf.layers.Layer;
import org.deeplearning4j.eval.Evaluation;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.File;
import java.io.IOException;
/**
 * @author an-hou.xiong
 */
public class SimpleMLP {
    public static void main(String[] args) throws Exception {
        // Load the MNIST data
        int batchSize = 64;
        int outputNum = 10; // 10 classes for MNIST digits
        int inputSize = 28 * 28; // 28x28 pixels
        int epochs = 5;

        // Create the training and testing datasets
        DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, 12345);
        DataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, 12345);

        // Build a simple MLP model
        MultiLayerNetwork model = buildModel(inputSize, outputNum);

        // Train the model
        model.fit(mnistTrain, epochs);

        // Evaluate the model on the test set
        Evaluation eval = model.evaluate(mnistTest);
        System.out.println(eval.stats());

        // Save the model
        saveModel(model);
    }

    // Build the MLP model
    private static MultiLayerNetwork buildModel(int inputSize, int outputNum) {
        // Neural network configuration
        NeuralNetConfiguration.ListBuilder listBuilder = new NeuralNetConfiguration.Builder()
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Adam(0.001)) // Adam优化器，学习率为 0.001
                .weightInit(WeightInit.XAVIER)
                .list();

        // Add layers to the model
        listBuilder.layer(0, new DenseLayer.Builder() // First hidden layer
                .nIn(inputSize)
                .nOut(128)
                .activation(Activation.RELU)
                .build());

        listBuilder.layer(1, new DenseLayer.Builder() // Second hidden layer
                .nIn(128)
                .nOut(64)
                .activation(Activation.RELU)
                .build());

        listBuilder.layer(2, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD) // Output layer
                .nIn(64)
                .nOut(outputNum)
                .activation(Activation.SOFTMAX)
                .build());


        MultiLayerNetwork model = new MultiLayerNetwork(listBuilder.build());
        model.init();

        return model;
    }

    // Save the model to a file
    private static void saveModel(MultiLayerNetwork model) throws IOException {
        File locationToSave = new File("mnistModel.zip");
        ModelSerializer.writeModel(model, locationToSave, true);
    }
}